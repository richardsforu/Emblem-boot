package com.cts.pss.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pss")
public class MyRestController {
	
	
	@Autowired
	private Sender sender;
	
	@GetMapping
	public Map<String, Object> get() {
		
		return sender.send();
	}

}
