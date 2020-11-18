package com.cts.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductRestController {
	
	@GetMapping
	public String welcome() {
		return "Welcome to my Application";
	}
	
	
	@GetMapping("/orders")
	public String welcome1() {
		return "Welcome to my Application Orders Section";
	}
	
	@GetMapping("/checkout")
	public String welcome2() {
		return "Welcome to my Application Checkout Section";
	}

}
