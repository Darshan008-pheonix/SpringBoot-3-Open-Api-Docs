package com.employee.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeAlreadyExistException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repo.EmployeeRepo;

import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(repo.existsById(employee.getId())) {
			throw new EmployeeAlreadyExistException("Employee Already Exists");
		}
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public List<Employee> getEmployeeBySorting() {
		List<Employee> list =repo.findAll(Sort.by("salary").descending().and(Sort.by("name")));
		return list;
	}

	
	@Override
	public String deleteById(int id) {
		Employee e=repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("user not found by id"));
		if(e!=null) {
			repo.deleteById(id);
			return "deleted..!!";
		}
		return "no found...!";
	
	}

	@Override
	public Employee findById(int id) {
		Employee e=repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("user not found by id"));
		return e;
	}

	@Override
	public List<Employee> findByDesgn(String desgn) {

		return repo.findByDesignation(desgn);
	}
	
	
}
