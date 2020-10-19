package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bill.BillingImpl;
import com.config.AppConfig;

public class Test {

	public static void main(String[] args) {

		String[] cart1 = { "I001", "I002", "I003" };
		String[] cart2 = { "I001", "I002"};
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//--------------------------------------------
		//PriceMatrixImpl price=new PriceMatrixImpl(); // dependency
		//--------------------------------------------

		//BillingImpl biller = new BillingImpl(); // dependent
		
		BillingImpl biller = ac.getBean(BillingImpl.class);
		
		
		//-----------------------
		//biller.setPrice(price);//  Injecting dependency (price) to the dependent obj (biller) is called DI
		//-----------------------
		
		double total = biller.getCartTotal(cart1);

		System.out.println("Cart1 Total is " + total);
		
		
		total = biller.getCartTotal(cart2);

		System.out.println("Cart2 Total is " + total);


	}

}
