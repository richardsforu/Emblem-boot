package com.cts.service;

public class EmployeeServiceImpl implements Cloneable {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeService: "+this.hashCode());
	}
	
	public EmployeeServiceImpl(DepartmentServiceImpl deptService) {
		this.deptService=deptService;
	}
	
	private DepartmentServiceImpl deptService;
	

	public DepartmentServiceImpl getDeptService() {
		return deptService;
	}


	public void setDeptService(DepartmentServiceImpl deptService) {
		this.deptService = deptService;
	}


	public void f1() {
		System.out.println("-- f1 method of EmployeeServiceImpl by "+this.hashCode());
	}

}
