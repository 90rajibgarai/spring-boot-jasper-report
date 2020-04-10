package com.spring.jrrepo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jrrepo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
