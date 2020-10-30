package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductDao prodDao = ac.getBean(ProductDao.class);

		Product product = new Product();

		product.setId(1);
		product.setName("Watch");
		product.setDescription("Digital Samsung");
		product.setPrice(35000);

		prodDao.save(product);
		
		

	}

}
