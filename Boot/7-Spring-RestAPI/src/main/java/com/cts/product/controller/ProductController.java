package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping
	public List<Product> listAllProducts(){
		return ps.listAll();
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return ps.saveProduct(product);
	}
	
	@GetMapping("{id}")
	public Product findById(@PathVariable("id") int id) {
		System.out.println("ID: >>>> "+id);
		return ps.findById(id);
	}
	
	
	
	
	
	
	
}
