package com.bill;

import com.pricematrix.PriceMatrixImpl;

// dependent
public class BillingImpl {
	
	/*
	 * 	
	 * Notes: Types of Objects: 2 types
	 * 	1. dependency object
	 * 	2. dependent object
	 * 	
	 * 
	 * 	1. dependency object -> works independently
	 * 	2. dependent object -> always depends on dependency objects
	 * 
	 * 
	 * Design Issues
	 * -----------------
	 * 
	 * 1. Too many dependency object creations
	 * 		-> tough to handle memory management
	 * 		-> low application performance
	 * 
	 *  Why this issue happened?
	 *  --------------------------
	 *  	-> Dependent class itself creating dependency class objects
	 *  
	 *  What is the solution?
	 *  -----------------------
	 *  	-> Do not create dependency objects in the dependent classes 
	 *  	   directly. 
	 *  	-> instead,  use concepts like JNDI / look up techniques
	 *  	-> JNDI location is tightly binded with dependent class
	 *  	
	 *  What is the best solution?
	 *  -----------------------------
	 *  	-> do not create or search, instead ask some one / container to inject (IOC) ->Inversion of control
	 *  	
	 *   Dependency Injection
	 *   ----------------------
	 *   -> Passing / injecting dependency obj to the dependent is called DI 
	 *   
	 *   How many ways DI can be implemented? : 2 ways
	 *   1. setter based DI
	 *   2. constructor based DI
	 *   
	 *    1. setter based DI
	 *    ----------------------
	 *    	-> Define Dependency object ref at class level
	 *    	-> create setter for the defined dependency object ref
	 *   
	 *   
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	private PriceMatrixImpl price;
	
	

	public void setPrice(PriceMatrixImpl price) {
		this.price = price;
	}



	public double getCartTotal(String[] cart) {
		
		
		double total = 0.0;

		//PriceMatrixImpl price = new PriceMatrixImpl();
		
		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}

		return total;
	}

}
