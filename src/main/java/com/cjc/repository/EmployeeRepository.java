package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public boolean existsByEmailId(String emailId);

//while using jpa entity field name and method name must be same
}
