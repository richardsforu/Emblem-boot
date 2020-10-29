package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.cts,com.cts.employee,com.cts.product"})
public class Application {

	public static void main(String[] args) {
		
		System.out.println(">>> Welcome <<<");
		
		SpringApplication.run(Application.class,args);
		
	}

}
