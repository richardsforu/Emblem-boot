package com.cts.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		ProductService ps = ac.getBean(ProductService.class);
		
		Product p1=new Product();
		p1.setId(10);
		p1.setName("pen");
		
		ps.saveProduct(p1);
		
		
		
		
		
	}

}
