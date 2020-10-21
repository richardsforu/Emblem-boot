package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.service.DepartmentServiceImpl;
import com.cts.service.EmployeeServiceImpl;
import com.cts.service.Product;

public class Test {

	public static void main(String[] args) {

		// Steps
		// 1- load spring context - spring.xml

		System.out.println("-- Welcome to spring");

		//Product p1 = Product.getProdObj();
		// Product p2=Product.getProdObj();
		// Product p3=Product.getProdObj();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		EmployeeServiceImpl empService = (EmployeeServiceImpl) ctx.getBean("es");
		EmployeeServiceImpl empService1 = (EmployeeServiceImpl) ctx.getBean("es2");
		EmployeeServiceImpl empService2 = (EmployeeServiceImpl) ctx.getBean("https://www.abc.com");

		empService.f1();
		empService.getDeptService().f2();
		empService1.getDeptService().f2();
		empService2.getDeptService().f2();
		//deptService.f2();
		// empService1.f1();
		// empService2.f1();

	}

}
