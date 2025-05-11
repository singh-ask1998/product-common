package com.ezpz.ecom.ezstore.product.common.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Embeddable
public class ProductDetailMultilingualEmbeddedId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "serial_number") // unique for a type of product like size, color etc.
	private Long serialNumber;

	 @Column(name="lang_code")
	 private String languageCode;
}
