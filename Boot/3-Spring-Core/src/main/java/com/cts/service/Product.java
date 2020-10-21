package com.cts.service;

public class Product {

	private static Product prod = null;

	private Product() {
		System.out.println(this.hashCode()+" Object ctreated  for "+this.getClass().getName());
	}

	public static Product getProdObj() {

		if (prod == null) {
			prod = new Product();
		}

		return prod;
	}

}
