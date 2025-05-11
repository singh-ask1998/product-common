package com.ezpz.ecom.ezstore.product.common.convertor;


import java.io.IOException;

import com.ezpz.ecom.ezstore.product.common.model.Price;
import com.ezpz.ecom.ezstore.product.common.model.ProductInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PriceObjectConvertor implements AttributeConverter<Price, String> {


	    private final ObjectMapper objectMapper = new ObjectMapper();

	    @Override
	    public String convertToDatabaseColumn(Price object) {
	        try {
	            if (object == null) {
	                return null;
	            }
	            // Serialize the object to a JSON string
	            return objectMapper.writeValueAsString(object);
	        } catch (IOException e) {
	            throw new IllegalArgumentException("Error converting object to JSON", e);
	        }
	    }

	    @Override
	    public Price convertToEntityAttribute(String dbData) {
	        try {
	            if (dbData == null) {
	                return null;
	            }
	            // Deserialize the JSON string back to an object (use the appropriate class)
	            return objectMapper.readValue(dbData, Price.class);
	        } catch (IOException e) {
	            throw new IllegalArgumentException("Error converting JSON to object", e);
	        }
	    }
}
