package com.kk.productmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.productmanagement.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
