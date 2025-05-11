package com.ezpz.ecom.ezstore.product.common.entities;


import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

import org.hibernate.annotations.UpdateTimestamp;

import com.ezpz.ecom.ezstore.product.common.convertor.ObjectConvertor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "product_detail_multilingual")
public class ProductDetailMultilingual {

@EmbeddedId
private ProductDetailMultilingualEmbeddedId productTranslationEmbeddedId;

@Column(name="product_name")
private String productName; 

@Column(name = "brand_name")
private String brandName;	

@Convert(converter = ObjectConvertor.class)
@Column(name="additional_information")
private Map<String,Map<String,String>> additionalInformation; 

// @Convert(converter = ObjectConvertor.class)
// @Column(name = "product_info")
// private ProductInfo productInfo;

 @UpdateTimestamp
 @Column(name="last_modified_time")
 private Instant lastModifiedTime;
 
 @MapsId("serialNumber")
 @ManyToOne()
 @JoinColumn(name = "serial_number")
 private ProductDetails productDetails;
 
// @PreUpdate
// public void setLastUpdatedTimeBeforeUpdate() {
//     this.lastModifiedTime = ZonedDateTime.now(ZoneOffset.UTC);  // Set to the current UTC time
// }
 
  
}
