package com.ezpz.ecom.ezstore.product.common.model;

import java.util.List;

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
public class Price {
	//original price would be 1st entry in the array of price
	private Double price;
	private Long timeStamp;
	private String currency;	
	
}
