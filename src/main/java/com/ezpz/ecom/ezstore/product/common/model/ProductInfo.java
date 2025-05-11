package com.ezpz.ecom.ezstore.product.common.model;

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
public class ProductInfo {
	
	private String name;
	private String description;
	private String brand;
	private String creationTime;
	
}
