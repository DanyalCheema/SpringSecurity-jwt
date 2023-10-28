package com.security.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author by Danyal
 * @classname EmployeeDTO
 * @Date 28/10/2023 8:04 pm
 */

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {

  private Integer id;
  private String firstName;
  private String lastName;
}
