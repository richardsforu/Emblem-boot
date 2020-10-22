package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.dao.EmployeeDao;

@Service(value = "empService")
//@Lazy
//@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
    @Qualifier(value = "accountsDao")
	private EmployeeDao empDao;
	
	/*@Autowired
	public EmployeeServiceImpl(EmployeeDao empDao) {
		this.empDao=empDao;
	}
	*/
	
	public void findAll() {
		System.out.println("EmployeeServiceImpl: findAll");
		empDao.findAll();
	}
}
