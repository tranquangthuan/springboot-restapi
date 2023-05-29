package com.fa.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fa.springboot.restapi.entity.Product;
import com.fa.springboot.restapi.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public Product save2(@RequestBody Product product) {
		return productService.save(product);
	}

	@PostMapping()
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product productResult = productService.save(product);
		return new ResponseEntity<Product>(productResult, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDetail(@PathVariable(name = "id") long id) {
		Product product = productService.findById(id);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.badRequest().body("Product with Id not exist");
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		List<Product> all = productService.getAll();
		return ResponseEntity.ok(all);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Product product) {
		Product p = productService.findById(id);
		if (p != null) {
			product.setId(id);
			Product update = productService.update(product);
			return ResponseEntity.ok(update);
		}
		return ResponseEntity.badRequest().body("Product with Id not exist");
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		Product product = productService.findById(id);
		if (product != null) {
			productService.delete(product);
			return ResponseEntity.ok("Deleted");
		}
		return ResponseEntity.badRequest().body("Product with Id not exist");
	}

}
