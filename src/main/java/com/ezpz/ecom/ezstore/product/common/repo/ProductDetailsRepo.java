package com.ezpz.ecom.ezstore.product.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezpz.ecom.ezstore.product.common.entities.Product;
import com.ezpz.ecom.ezstore.product.common.entities.ProductDetails;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails,Long>{

}
