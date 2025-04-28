package com.cjc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.model.Employee;
import com.cjc.repository.EmployeeRepository;
import com.cjc.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{
   @Autowired
	  EmployeeRepository er;
   
	@Override
	public String registerData(Employee e) {
		
		if(er.existsByEmailId(e.getEmailId())){
			
			return "email already exists";
			
		}
		
		
		if(e.getPassword().length()!=8) {
			
			return "password should contained 8 character";
		}
		
		
		er.save(e);
		return "data saved successfully";
		
		
		
		
		
		 
	
	}

	@Override
	public String loginData(String userName, String password) {
		
		
		   Iterable<Employee>itr= er.findAll();
		     for(Employee e:itr) {
		    	 
		    	 if(e.getUserName().equals(userName)&&e.getPassword().equals(password)) {
		    		 
		    		 return "username and password matched";
		    	 }
		    	
		     }
		     
		     return "authantication failed";
	
	}

	
	
	

}
