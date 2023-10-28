package com.security.poc.controller;

import com.security.poc.dto.EmployeeDTO;
import com.security.poc.entity.Employee;
import com.security.poc.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by Danyal
 * @classname EmployeController
 * @Date 28/10/2023 2:55 am
 */

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;


  @GetMapping("/all")
  public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
    return ResponseEntity.ok(employeeService.getAllEmployee());
  }

  @GetMapping("/{employeeId}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @PostMapping("/save")
  public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @PutMapping("/update")
  public ResponseEntity<EmployeeDTO> editEmployee(@RequestBody Employee employee) {
    return employeeService.editEmployee(employee);
  }

  @DeleteMapping("/{employeeId}")
  public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
    return employeeService.deleteEmployee(employeeId);
  }
}
