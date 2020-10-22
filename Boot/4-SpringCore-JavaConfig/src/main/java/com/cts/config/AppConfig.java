package com.cts.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.cts.service,com.cts.dao"})
public class AppConfig {
	
	

}
