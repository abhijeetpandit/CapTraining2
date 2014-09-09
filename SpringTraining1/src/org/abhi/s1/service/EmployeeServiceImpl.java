package org.abhi.s1.service;

import java.util.List;

import org.abhi.s1.dao.EmployeeDao;
import org.abhi.s1.datamodel.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Employee getEmployeeById(String kinId) {
		return employeeDao.getSingleEmployee(kinId);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return employeeDao.getEmployeesByName(name);
	}
}
