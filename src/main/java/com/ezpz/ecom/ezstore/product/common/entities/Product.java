package com.ezpz.ecom.ezstore.product.common.entities;

import java.util.List;
import java.util.UUID;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

@Column(unique = true)
private UUID uuid;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="product_id")
private Long productId;

@Column(name="product_identifier",unique = true)//this could be model number which will be same for different variants of same product
private String productIdentifier;

@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
private List<ProductDetails> productDetails;

//@OneToOne(mappedBy = "product",cascade = CascadeType.REMOVE)
//private ProductInventory productInventory;

@Column(unique = true,name = "category_id")
private Long categoryId;


@Column(columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
private String status;

@Column(name="tags",columnDefinition = "VARCHAR(1000) DEFAULT 'ACTIVE'")
private String tags;



@PrePersist
public void prePersist() {
    if (uuid == null) {
        uuid = UUID.randomUUID();  // Auto-generate UUID before persisting
    }
}

}
