package com.cts.dao;

import org.springframework.stereotype.Repository;

@Repository("accountsDao")
public class AccountsDaoImpl implements EmployeeDao{
	public void findAll() {
		System.out.println("AccountsDaoImpl:: findAll");
		
	}

}
