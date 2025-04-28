package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DaaTaskApplication {

	public static void main(String[] args) {
		System.out.println("Daa Task Start");
		SpringApplication.run(DaaTaskApplication.class, args);
	}
	
	@Bean
	  public RestTemplate rt() {
		 
		  return new RestTemplate();
		  
	  }

}
