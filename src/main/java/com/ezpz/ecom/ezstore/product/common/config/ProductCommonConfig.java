package com.ezpz.ecom.ezstore.product.common.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.ezpz.ecom.ezstore.product.common")
@EnableJpaRepositories(basePackages = "com.ezpz.ecom.ezstore.product.common")
public class ProductCommonConfig {

}
