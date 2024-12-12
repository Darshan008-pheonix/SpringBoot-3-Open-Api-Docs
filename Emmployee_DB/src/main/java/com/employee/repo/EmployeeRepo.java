package com.employee.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.entity.*;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
List<Employee> findByDesignation(String desgn);
	
}
