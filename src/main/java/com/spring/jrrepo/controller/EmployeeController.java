package com.spring.jrrepo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.jrrepo.service.EmployeeService;
import com.spring.jrrepo.service.ReportService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ReportService reportService;
	
//----------------------------------[ASYNC METHOD FOR] GET DATA FROM CSV AND SAVE IN DB---------------------------------

	@PostMapping()
	public ResponseEntity<Object> saveEmployees(@RequestParam("file") MultipartFile file)
	{		
		employeeService.saveEmployees(file);	// READ 1000 RECORDS FROM CSV AND SAVE INTO DB -> THROUGH ASYNC METHOD
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/report/{type}")
	public ResponseEntity<Object> geterateReport(@PathVariable("type") String type)
	{
		reportService.geterateReport(type);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
