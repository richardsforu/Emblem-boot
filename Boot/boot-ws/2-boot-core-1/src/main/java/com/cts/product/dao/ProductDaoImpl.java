package com.cts.product.dao;

import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		System.out.println("DAO: Product is saved");
	}

}
