# Spring Boot Report Generation Using Jasper Libarary

We sould follow following steps to generate jasper report :

STEP-1 :
--------
Create an API for upload a CSV file and Save into Database using Spring Boot Async Method.

API-Details : 
-------------
	Request URL : http://localhost:9191/employees
	HTTP Method : POST
	Request Parameter : CSV File [File Location : src/main/resources/datasource/Employees.csv]
	Response Status : OK (200)

STEP-2 : 
--------
Create Jasper Template using Jaster Studio [Created File is available : src/main/resources/templates/employees.jrxml]

STEP-3 : 
--------
Read data from database and write into employees.jrxml.

STEP-4 :
--------
Base on input type(html/pdf) it's generate reports in different file format and save in [D:/COVID-2020/jasper-repo/] this directory.

API-Details : 
-------------
	Requested URL : http://localhost:9191/employees/report/:type
	HTTP Method : POST
	Request Parameter : pdf
	Response Status : OK (200)

* Request Parameter can be html/pdf.



