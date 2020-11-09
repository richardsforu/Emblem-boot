package com.cts.pss.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {
	
	@Autowired
	private RabbitMessagingTemplate template;
	
	
	@Bean
	public Queue q1() {
		return new Queue("MyQ1",false);
	}
	
	
	// Write data to MyQ1 queue
	
	public  Map<String, Object> send() {
		
		Map<String, Object> myData=new HashMap<>();
		myData.put("NAME", "P3");
		myData.put("CITY", "C3");
		myData.put("AGE", 103);
		
		template.convertAndSend("MyQ1",myData);
		return myData;
	}

}
