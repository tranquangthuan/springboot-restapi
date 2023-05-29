package com.fa.springboot.restapi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private int quantity;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate productDate;

	public Product() {
		super();
	}

	public Product(long id, String name, int quantity, LocalDate productDate) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.productDate = productDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getProductDate() {
		return productDate;
	}

	public void setProductDate(LocalDate productDate) {
		this.productDate = productDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", productDate=" + productDate + "]";
	}

}
