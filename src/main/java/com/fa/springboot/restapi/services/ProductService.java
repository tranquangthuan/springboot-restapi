package com.fa.springboot.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.springboot.restapi.entity.Product;
import com.fa.springboot.restapi.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

}
