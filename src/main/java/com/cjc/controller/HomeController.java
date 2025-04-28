package com.cjc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.model.Employee;
import com.cjc.servicei.EmployeeServiceI;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	EmployeeServiceI es;
	
	@PostMapping("/register")
	public ResponseEntity<String>registerEmployee(@RequestBody Employee e) {
		
		
		 String res= es.registerData(e);
		  
		 if(res.equalsIgnoreCase("email already exists")) {
			 
			 return new ResponseEntity<>(res,HttpStatus.CONFLICT);
		 }
		 else if(e.getPassword().equals("password should contained 8 character")) {
			 
			 return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		 }
		  
		 else {
			 
			 return new ResponseEntity<>(res,HttpStatus.CREATED);
		 }
		
	}
	// Check difference between, request body, request path parameter, and query parameter
	// body - Json, FormData
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@PathVariable("userName")String uname,@PathVariable("password")String pas) {
//		
//		  String itr= es.loginData(uname, pas);
//		  
//		  if(itr.equals("username and password matched")) {
//			  
//			  return new ResponseEntity<>(itr,HttpStatus.OK);
//		  }
//		  
//			  
//			  return new ResponseEntity<>(itr,HttpStatus.UNAUTHORIZED);
//		  
//		
//		
//		
//		
//	}
	
//	@GetMapping("/getUser")
//	public ResponseEntity<String> profile(){
//		
//		
//		
//		    
//		  
//		}

	}


