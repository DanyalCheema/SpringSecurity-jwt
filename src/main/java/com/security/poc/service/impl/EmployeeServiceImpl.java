package com.security.poc.service.impl;

import com.security.poc.dto.EmployeeDTO;
import com.security.poc.entity.Employee;
import com.security.poc.repository.EmployeeRepo;
import com.security.poc.service.EmployeeService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author by Danyal
 * @classname EmployeeServiceImpl
 * @Date 28/10/2023 7:49 pm
 */

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepo employeeRepo;

  @Override
  public List<EmployeeDTO> getAllEmployee() {
    return employeeRepo.findAll().stream().map(
      employee -> EmployeeDTO.builder().id(employee.getId()).firstName(employee.getFirstName())
        .lastName(employee.getLastName()).build()).collect(Collectors.toList());
  }

  @Override
  public ResponseEntity<EmployeeDTO> getEmployeeById(Integer employeeId) {
    Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
    if (optionalEmployee.isPresent()) {
      Employee employee = optionalEmployee.get();
      EmployeeDTO employeeDTO = EmployeeDTO.builder()
        .id(employee.getId())
        .firstName(employee.getFirstName())
        .lastName(employee.getLastName())
        .build();
      return ResponseEntity.ok(employeeDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<EmployeeDTO> addEmployee(Employee employee) {
    if (Objects.isNull(employee)) {
      ResponseEntity.badRequest().build();
    }
    employee.setCreatedAt(new Date());
    employee = employeeRepo.save(employee);
    return ResponseEntity.ok(
      EmployeeDTO.builder().id(employee.getId()).firstName(employee.getFirstName())
        .lastName(employee.getLastName()).build());
  }

  @Override
  public ResponseEntity<EmployeeDTO> editEmployee(Employee employee) {
    if (Objects.isNull(employee) || Objects.isNull(employee.getId())) {
      return ResponseEntity.badRequest().build();
    }
    employee.setUpdatedAt(new Date());
    employee = employeeRepo.save(employee);
    return ResponseEntity.ok(
      EmployeeDTO.builder().id(employee.getId()).firstName(employee.getFirstName())
        .lastName(employee.getLastName()).build());
  }

  @Override
  public ResponseEntity<String> deleteEmployee(Integer employeeId) {
    Optional<Employee> employeeToDelete = employeeRepo.findById(employeeId);

    if (employeeToDelete.isPresent()) {
      employeeRepo.deleteById(employeeId);
      return ResponseEntity.ok("Employee with ID " + employeeId + " was successfully deleted.");
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Employee with ID " + employeeId + " not found.");
    }
  }
}
