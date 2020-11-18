package com.cts.product.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		auth.inMemoryAuthentication()
        .withUser("user").password("{noop}password").roles("USER")
        .and()
        .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	}
	
	// Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http
                //HTTP Basic authentication
               .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/products").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/products/orders").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/products/checkout").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/api/products/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/products/manager/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin();
    }
	
	

}
