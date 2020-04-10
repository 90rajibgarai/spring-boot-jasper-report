package com.spring.jrrepo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.spring.jrrepo.constant.KeyConstant;
import com.spring.jrrepo.dao.EmployeeDao;
import com.spring.jrrepo.model.Employee;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService
{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Value("${jasper.report.path}")
	private String jrRepoPath;
	
	@Override
	public boolean geterateReport(String type)
	{		
		List<Employee> employees = employeeDao.getEmployees();
		
		try 
		{
			File file = ResourceUtils.getFile("classpath:templates/employees.jrxml");
			
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
			
			Map<String, Object> parameters = new HashMap<>();
			
			parameters.put("createdBy", "Rajib Garai");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			
			switch (type.toUpperCase())
			{
				case KeyConstant.REPO_TYPE_HTML :
					 JasperExportManager.exportReportToHtmlFile(jasperPrint, jrRepoPath + "employees.html");
					break;
				case KeyConstant.REPO_TYPE_PDF :
					JasperExportManager.exportReportToPdfFile(jasperPrint, jrRepoPath + "employees.pdf");
					break;				
			}			
		} 
		catch (FileNotFoundException e)
		{
			log.error("FileNotFoundException : ", e.getMessage(), e.getCause());
		} 
		catch (JRException e) 
		{
			log.error("JRException : ", e.getMessage(), e.getCause());
		}		
		return true;
	}

}
