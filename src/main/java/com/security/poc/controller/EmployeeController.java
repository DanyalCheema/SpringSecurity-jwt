package com.security.poc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by Danyal
 * @classname EmployeController
 * @Date 28/10/2023 2:55 am
 */

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  @GetMapping
  public ResponseEntity<String> getEmployee() {
    return ResponseEntity.ok("Employee secured endpoint");
  }
}
