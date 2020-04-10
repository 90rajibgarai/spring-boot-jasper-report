package com.spring.jrrepo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jrrepo.model.Employee;
import com.spring.jrrepo.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> saveAllEmployee(List<Employee> parseCSVFile)
	{
		return (List<Employee>) employeeRepository.saveAll(parseCSVFile);
	}

	@Override
	public List<Employee> getEmployees() 
	{
		return (List<Employee>) employeeRepository.findAll();
	}

}
