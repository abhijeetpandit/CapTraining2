package org.abhi.s1.dao;

import java.util.List;

import org.abhi.s1.datamodel.Employee;

public interface EmployeeDao {
	public Employee getSingleEmployee(String kinId);
	
	public List<Employee> getEmployeesByName(String name);
	
	public List<Employee> getAllEmployees();
	
}
