package org.abhi.s1.test;

import java.util.List;

import org.abhi.s1.dao.EmployeeDaoImpl;
import org.abhi.s1.datamodel.Employee;
import org.abhi.s1.service.EmployeeService;
import org.abhi.s1.service.EmployeeServiceImpl;
import org.junit.Test;

public class TestClient {
	@Test
	public void testGetEmployeeById() {
		EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoImpl());
		Employee employee = employeeService.getEmployeeById("57359_FS");
		System.out.println(employee);
		
		Employee employee2 = employeeService.getEmployeeById("58886_FS");
		System.out.println(employee2);
	}
	
	@Test
	public void testGetEmployeeByName() {
		EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoImpl());
		List<Employee> employees = employeeService.getEmployeeByName("asdas");
		System.out.println(employees);
		
		List<Employee> employees2 = employeeService.getEmployeeByName("s");
		System.out.println(employees2);
	}
}
