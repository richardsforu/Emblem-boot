package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductService ps = ac.getBean(ProductService.class);
		
		
		Product product=new Product();
		product.setId(8);
		product.setName("Ipad");
		product.setPrice(120000);
		product.setDescription("Ipad Pro with ios 14");
		
		ps.saveProduct(product);
		
		//-----------------------------
		
		ps.listAll().forEach(prod->{
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
			System.out.println("----------------------------");
		});
		
		
	}

}
