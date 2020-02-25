package com.example.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	public static final Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	
	@RequestMapping(value="/dummy", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody Employee getDummyEmployee() {
		Employee employee = new Employee();
		employee.setId(999);
		employee.setName("qwerty");
		employeeMap.putIfAbsent(999, employee);
		return employeeMap.get(999);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (Integer id : employeeMap.keySet()) {
			employees.add(employeeMap.get(id));
		}
		
		return employees;
	}
	
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, headers="Accept=application/xml, application/json")
	@ResponseBody
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeMap.get(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, headers="Accept=application/xml, application/json")
	public @ResponseBody Employee addEmployee(@RequestBody Employee employee) {
		employeeMap.putIfAbsent(employee.getId(), employee);
		return employeeMap.get(employee.getId());
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, headers="Accept=application/xml, application/json")
	public @ResponseBody boolean addEmployee(@PathVariable("id") int id) {
		employeeMap.remove(id);
		return true;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT, headers="Accept=application/xml, application/json")
	public @ResponseBody boolean updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeMap.put(id, employee);
		return true;
	}
}
