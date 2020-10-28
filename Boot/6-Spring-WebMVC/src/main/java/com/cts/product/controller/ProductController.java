package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@RequestMapping(value = "/")
	public String welcomePage() {
		return "home";
	}

	@RequestMapping(value = "/loadForm")
	public String loadForm() {
		return "form";
	}

	@RequestMapping(value = "/saveProduct")
	public void saveProduct(
			@RequestParam("id") int id, 
			@RequestParam("name") String name,
			@RequestParam("price") double price, 
			@RequestParam("description") String description) {

		System.out.println("-- saving Product...");
		System.out.println("ID: " + id);
		System.out.println("Name: "+name);
		System.out.println("Price: "+price);
		System.out.println("Description: "+description);
		
	}

	
	@RequestMapping(value = "saveProductV1")
	public String saveProductV1(@ModelAttribute Product product) {
		System.out.println("--- V1");
		
		ps.saveProduct(product);
		
		return "redirect:products";
		
		
	}
	@RequestMapping(value = "/s1")
	public void f1() {
		System.out.println("f1 metghod of ProductController");
	}

	@RequestMapping(value = "/s2")
	public String f2(Model model) {
		String[] cities = { "Chenmai", "Bangalore", "Hyderabad", "Pune", "Delhi" };
		model.addAttribute("pname", "Praveen Reddy S");
		model.addAttribute("myCities", cities);
		System.out.println("--- f2 method");
		return "test";
	}

	@RequestMapping(value = "/products",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_PDF_VALUE})
	public String listProducts(Model model) {

		List<Product> prods = ps.listAll();
		model.addAttribute("products", prods);
		return "products";
	}
	
	
	@RequestMapping(value = "/productsV1")
	public ModelAndView listProductsV1() {

		ModelAndView mav=new ModelAndView(); 
		List<Product> prods = ps.listAll();
		mav.addObject("products", prods);
		mav.setViewName("products");
		//model.addAttribute("products", prods);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
