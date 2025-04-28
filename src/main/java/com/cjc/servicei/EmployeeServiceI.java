package com.cjc.servicei;

import com.cjc.model.Employee;

public interface EmployeeServiceI {
	
	public String registerData(Employee e);
	public String loginData(String userName,String password);
	
}
