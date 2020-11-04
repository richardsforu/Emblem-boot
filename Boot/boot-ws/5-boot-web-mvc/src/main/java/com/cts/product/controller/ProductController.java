package com.cts.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.entity.Product;

@Controller
public class ProductController {
	
	@RequestMapping("/")
	public String f1(Model model) {
		
		model.addAttribute("userName", "Praveen");
		
		Product prod=new Product();
		prod.setId(10);
		prod.setName("Pen");
		prod.setDescption("Red Ink");
		prod.setPrice(350);
		
		
		model.addAttribute("product",prod);
		
		return "index";
	}

}
