package com.ezpz.ecom.ezstore.product.common.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_inv")
public class ProductInventory {
	
////	
////	@Column(name = "product_id")
////	private Integer productId;
//	@Column(name = "quantity")
//	private Long quantityInStock;
	@Id
	@Column(unique = true,name = "product_id")
	private Long productId;
	
	
	@MapsId
	@OneToOne()
	@JoinColumn(name = "product_id", referencedColumnName = "product_id") 
	private Product product;
	
	@Column(name = "supplier_id")
	private List<UUID> supplierId;
	
	@Column(name = "warehouse_id")
	private List<UUID> warehouseId;
	//reorder level
	
	

}
