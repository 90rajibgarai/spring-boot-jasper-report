package com.spring.jrrepo.dao;

import java.util.List;

import com.spring.jrrepo.model.Employee;

public interface EmployeeDao 
{
	public List<Employee> saveAllEmployee(List<Employee> parseCSVFile);

	public List<Employee> getEmployees();
}
