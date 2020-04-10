package com.spring.jrrepo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.jrrepo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CSVOperation 
{
	public static List<Employee> parseCSVFile(MultipartFile file)
	{
		final List<Employee> employees = new ArrayList<>();		
        try 
        {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) 
            {
                String line;
                
                while ((line = br.readLine()) != null) 
                {
                    final String[] data = line.split(",");
                    
                    final Employee employee = new Employee();
                    
                    employee.setName(data[0]);
                    employee.setEmail(data[1]);
                    employee.setMobile(data[2]);
                    employee.setSalary(Double.parseDouble(data[3]));
                    
                    employees.add(employee);
                }
                return employees;
            }
        } 
        catch (final IOException e) 
        {
            log.error("Failed to parse CSV file {}", e);
        }
		return employees;
	}
}
