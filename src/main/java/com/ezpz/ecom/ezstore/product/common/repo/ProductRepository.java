package com.ezpz.ecom.ezstore.product.common.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezpz.ecom.ezstore.product.common.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
