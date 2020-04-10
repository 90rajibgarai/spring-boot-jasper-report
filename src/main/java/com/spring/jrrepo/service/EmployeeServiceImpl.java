package com.spring.jrrepo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.jrrepo.dao.EmployeeDao;
import com.spring.jrrepo.model.Employee;
import com.spring.jrrepo.util.CSVOperation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Async
	@Override
	public CompletableFuture<List<Employee>> saveEmployees(MultipartFile file)
	{
		List<Employee> employees = null;
		
		Long start = System.currentTimeMillis();
					
		employees = employeeDao.saveAllEmployee(CSVOperation.parseCSVFile(file));	// GET DATA FROM CSV AND SAVE IN DB		
		
		Long end = System.currentTimeMillis();
		
		log.info("Completation Time : {}", (end-start));
		
		return CompletableFuture.completedFuture(employees);
	}

}
