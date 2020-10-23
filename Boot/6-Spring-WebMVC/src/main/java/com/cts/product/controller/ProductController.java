package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value = "/s1")
	public void f1() {
		System.out.println("f1 metghod of ProductController");
	}
	
	@RequestMapping(value = "/s2")
	public String f2(Model model) {
		String[] cities= {"Chenmai","Bangalore","Hyderabad","Pune","Delhi"};
		model.addAttribute("pname", "Praveen Reddy S");
		model.addAttribute("myCities", cities);
		System.out.println("--- f2 method");
		return "test";
	}
	
	@RequestMapping(value = "/products")
	public String listProducts(Model model) {
		
		List<Product> prods=ps.listAll();
		model.addAttribute("products", prods);
		return "products";
	}
	
	

}
