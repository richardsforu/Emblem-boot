package com.cts.pss.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {

	@Bean
	public Queue queue1() {
		System.out.println(">>>>>>>> executed <<<<<<<<");
		return new Queue("MyQ1", false);
	}

	@RabbitListener(queues = "MyQ1")
	public void test(Map<String, Object> data) {

		String name = (String) data.get("NAME");
		String city = (String) data.get("CITY");
		int age = (int) data.get("AGE");

		System.out.println(">>>>>>>>>>> ======= <<<<<<<<<<<<<<");
		System.out.println(">>>> Name: " + name);
		System.out.println(">>>> City: " + city);
		System.out.println(">>>> Age:: " + age);

		System.out.println(">>>>>>>>>>> ======= <<<<<<<<<<<<<<");

	}

}
