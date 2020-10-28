package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {

	List<Product> listAll();

	Product saveProduct(Product product);
	
	Product findById(int id);
	
	
	
}