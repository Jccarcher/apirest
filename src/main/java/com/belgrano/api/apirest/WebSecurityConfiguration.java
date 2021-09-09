package com.belgrano.api.apirest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers(HttpMethod.POST,"/user/create").permitAll()
		.antMatchers(HttpMethod.GET,"/user/getAllUser").permitAll()
		.antMatchers(HttpMethod.GET,"/user/getUser").permitAll()
		.anyRequest().authenticated();
	}

}
