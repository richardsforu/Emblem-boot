package com.cts.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.dao.ProductDao;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao prodDao;
	
	@RequestMapping(value = "/findAll")
	public String findAllProducts(Model model){
		
		model.addAttribute("products", prodDao.findAll());
		
		return "products";
		
	}

}
