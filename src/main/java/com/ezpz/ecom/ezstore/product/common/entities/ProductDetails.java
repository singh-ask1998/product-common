package com.ezpz.ecom.ezstore.product.common.entities;

import java.security.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Type;


import com.ezpz.ecom.ezstore.product.common.convertor.PriceObjectConvertor;
import com.ezpz.ecom.ezstore.product.common.model.Price;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_number") // unique for a type of product like size, color etc.
	private Long serialNumber;
	
	@Column(name="product_id")
	private Long productId;

	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "serial_number", referencedColumnName = "serial_number")
	private List<ProductDetailMultilingual> productDetailMultilingual;

	//create a price history table for each product
	@Convert(converter = PriceObjectConvertor.class)
	@Column(name = "price_details", nullable = true)
	private Price priceDetails;

	@Column(name = "updated_by")
	private UUID updatedBy;
	
	//attribute on which products have options to select.
	@Type(JsonBinaryType.class)
	@Column(name="variation_attribute",columnDefinition = "jsonb")
	private Map<String,Object> variationAttribute;
	
	
	@CreationTimestamp
	@Column(name = "created_timestamp",updatable = false)
	private Instant createdTimestamp;

	 @UpdateTimestamp
	 @Column(name = "updated_timestamp")
	 private Instant updatedTimestamp;
	

	
	@Column(name = "offer_id",nullable = true)
	private Long offerId;
	
	 @PreUpdate
	    public void setUpdatedAtOnUpdate() {
		 if (product != null && productId == null) {
	            this.productId = product.getProductId(); // auto-fill FK from entity
	        }
	        this.priceDetails.setTimeStamp(System.currentTimeMillis()); // Current UTC time in millis
	    }
	 
	    @PrePersist
	   
	    private void syncProductId() {
	        if (product != null && productId == null) {
	            this.productId = product.getProductId(); // auto-fill FK from entity
	        }
	    }

	

}
