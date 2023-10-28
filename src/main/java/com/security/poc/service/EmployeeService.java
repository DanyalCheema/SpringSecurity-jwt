package com.security.poc.service;

import com.security.poc.dto.EmployeeDTO;
import com.security.poc.entity.Employee;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * @author by Danyal
 * @classname EmployeeService
 * @Date 28/10/2023 7:48 pm
 */

public interface EmployeeService {

  List<EmployeeDTO> getAllEmployee();

  ResponseEntity<EmployeeDTO> getEmployeeById(Integer employeeId);

  ResponseEntity<EmployeeDTO> addEmployee(Employee employee);

  ResponseEntity<EmployeeDTO> editEmployee(Employee employee);

  ResponseEntity<String> deleteEmployee(Integer employeeId);

}
