package com.cts.service;

public class DepartmentServiceImpl {
	public DepartmentServiceImpl() {
		System.out.println("DepartmentServiceImpl: "+System.identityHashCode(this));
	}
	
	public void f2() {
		System.out.println();
		System.out.println("-- f2 method of DepartmentServiceImpl by "+this.hashCode());
	}
}
