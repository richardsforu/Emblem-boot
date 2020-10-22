package com.cts.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "empDao")
//@Lazy
public class EmployeeDaoImpl implements EmployeeDao {

	public void findAll() {
		System.out.println("EmployeeDaoImpl: findAll");
	}

}
