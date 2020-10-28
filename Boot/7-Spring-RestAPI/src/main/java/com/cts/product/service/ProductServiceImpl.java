package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;

	@Transactional
	public List<Product> listAll() {

		return prodDao.findAll();
	}

	@Transactional
	public Product saveProduct(Product product) {
		return prodDao.save(product);
	}

	@Transactional
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id);
	}

}
