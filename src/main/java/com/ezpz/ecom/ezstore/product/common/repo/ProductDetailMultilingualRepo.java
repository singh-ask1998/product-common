package com.ezpz.ecom.ezstore.product.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezpz.ecom.ezstore.product.common.entities.ProductDetailMultilingual;
import com.ezpz.ecom.ezstore.product.common.entities.ProductDetailMultilingualEmbeddedId;

@Repository
public interface ProductDetailMultilingualRepo extends JpaRepository<ProductDetailMultilingual,ProductDetailMultilingualEmbeddedId> {

}
