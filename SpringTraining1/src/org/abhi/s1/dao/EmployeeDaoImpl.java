package org.abhi.s1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.abhi.s1.datamodel.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private Map<String, Employee> employeesMap = new HashMap<>();
	
	{
		Employee employee1 = new Employee("57359_FS", "Abhijeet", "Pandit", "+918087246208", "abhijeet.pandit@capgemini.com");
		Employee employee2 = new Employee("58886_FS", "Ramnivas", "Gupta", "+919730590319", "ramnivas.gupta@capgemini.com");
		Employee employee3 = new Employee("45666_FS", "Shashank", "Bodkhe", "+915654565455", "shsank.bodke@capgemini.com");
		Employee employee4 = new Employee("43534_FS", "Sagar", "Kulkarni", "+913534534534", "sagar.kulkarni@capgemini.com");
		Employee employee5 = new Employee("34543_FS", "Tom", "Jerry", "+9134534534434", "tom.jerry@capgemini.com");
		
		employeesMap.put(employee1.getKinId(), employee1);
		employeesMap.put(employee2.getKinId(), employee2);
		employeesMap.put(employee3.getKinId(), employee3);
		employeesMap.put(employee4.getKinId(), employee4);
		employeesMap.put(employee5.getKinId(), employee5);
	}
	
	@Override
	public Employee getSingleEmployee(String kinId) {
		return employeesMap.get(kinId);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		Set<String> keySet = employeesMap.keySet();
		List<Employee> employees = new ArrayList<>();
		for(String key : keySet) {
			Employee employee = employeesMap.get(key);
			if(employee.getEmpFirstName().contains(name) || employee.getEmpLastName().contains(name)) {
				employees.add(employee);
			}
		}
		return employees;
	}
	@Override
	public List<Employee> getAllEmployees() {
		Set<String> keySet = employeesMap.keySet();
		List<Employee> employees = new ArrayList<>();
		for(String key : keySet) {
			employees.add(employeesMap.get(key));
		}
		return employees;
	}
}
