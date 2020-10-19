package com.pricematrix;

import org.springframework.stereotype.Repository;

@Repository
public class PriceMatrixImpl {

	public PriceMatrixImpl() {
		System.out.println("PriceMatrix Object is created...");
	}

	public double getItemPrice(String itemCode) {
		// code to fetch price of given itemCode
		return 100.00;
	}

}
