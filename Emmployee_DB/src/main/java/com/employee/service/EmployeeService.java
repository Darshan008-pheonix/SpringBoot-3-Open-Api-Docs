package com.employee.service;
import com.employee.entity.Employee;

import java.util.*;

public interface EmployeeService {
 
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	List<Employee> getEmployeeBySorting();
	Employee findById(int id);
	String deleteById(int id);
	List<Employee> findByDesgn(String desgn);
}
