package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cts.config.AppConfig;
import com.cts.service.EmployeeService;

public class Test {

	public static void main(String[] args) {
		System.out.println("Welcome to Spring");
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

		
		/*
		EmployeeServiceImpl es = ac.getBean("empService",EmployeeServiceImpl.class);
		//es.findAll();
		EmployeeDaoImpl ed=ac.getBean("empDao",EmployeeDaoImpl.class);
		//ed.findAll();
		 */
		
		
		EmployeeService es1 = ac.getBean(EmployeeService.class);
	
		es1.findAll();
		 
		 
	
		
		
	}

}
