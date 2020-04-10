package com.spring.jrrepo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.multipart.MultipartFile;

import com.spring.jrrepo.model.Employee;



public interface EmployeeService 
{
	public CompletableFuture<List<Employee>> saveEmployees(MultipartFile file);
}
