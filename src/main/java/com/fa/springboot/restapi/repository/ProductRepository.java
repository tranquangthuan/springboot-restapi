package com.fa.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.springboot.restapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
