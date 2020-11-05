package com.cts.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	
	@GetMapping
	public String f1() {
		return "GET Mapping";
	}
	
	@GetMapping("/{productId}")
	public String f11(@PathVariable("productId") int id) {
		return "GET Mapping "+id;
	}
	
	@GetMapping("/{start}/{end}")
	public String f12(@PathVariable("start") int start,@PathVariable("end") int end) {
		return "Starting range is "+start+" and ending is "+end;
	}
	
	@PostMapping()
	public String f2(@RequestBody Object data) {
		return "POST Mapping  >>> "+data;
	}
	
	@PostMapping("/{id}")
	public String f22(@PathVariable int id) {
		return "POST Mapping >> p1 << "+id;
	}
	
	

	
	@PutMapping
	public String f3() {
		return "PUT Mapping";
	}

	
	@DeleteMapping
	public String f4() {
		return "Delete Mapping";
	}

	
	@PatchMapping
	public String f5() {
		return "Patch Mapping";
	}


}
