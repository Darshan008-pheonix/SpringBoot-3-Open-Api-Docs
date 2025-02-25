package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping
public class EmployeeController {


	
	@Autowired
	EmployeeServiceImpl serviceImpl;

	
	@PostMapping("addEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(serviceImpl.saveEmployee(employee),HttpStatus.CREATED);

	}
	@GetMapping("employees")
	public List<Employee> getAllEmployee()	{
		return serviceImpl.getAllEmployee();	
	}
	@GetMapping(path = "/employee/sorted")
	public List<Employee> empBySort(){
		return serviceImpl.getEmployeeBySorting();
	}
	
	@GetMapping("byId")
	ResponseEntity<Employee> findById(@RequestHeader int id) {
		return new ResponseEntity<Employee>(serviceImpl.findById(id),HttpStatus.FOUND);
	}
	
	@DeleteMapping("byId")
	String deleteById(@RequestHeader int id) {
		return serviceImpl.deleteById(id);
	}
	
	@GetMapping("byDesg")
	ResponseEntity<List<Employee>> findByDesgn(@RequestHeader String desgn){
		return new ResponseEntity<List<Employee>>(serviceImpl.findByDesgn(desgn),HttpStatus.FOUND);
	}
	
}

