package org.abhi.s1.service;

import java.util.List;

import org.abhi.s1.datamodel.Employee;

public interface EmployeeService {
	public Employee getEmployeeById(String kinId);
	
	public List<Employee> getEmployeeByName(String name);
	
}
