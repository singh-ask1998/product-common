package com.ezpz.ecom.ezstore.product.common.util;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

	public String message;
	public String status; 
}
