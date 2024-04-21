package com.checongbinh.Nexflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.thymeleaf.extras.springsecurity6.util.SpringSecurityContextUtils;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})	
public class WebNetFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebNetFlixApplication.class, args);
	}

}
