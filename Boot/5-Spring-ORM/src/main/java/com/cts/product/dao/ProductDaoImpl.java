package com.cts.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sf;
	
	public void save(Product product) {
	    sf.getCurrentSession().save(product);
	}
	
	public List<Product> findAll(){
		return sf.getCurrentSession().createQuery("from Product").getResultList();
	}
	
	
	
	

}
