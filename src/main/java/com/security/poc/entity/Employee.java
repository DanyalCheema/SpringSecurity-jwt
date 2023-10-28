package com.security.poc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by Danyal
 * @classname Employee
 * @Date 28/10/2023 7:54 pm
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee extends BaseEntity {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstName;
  private String lastName;

}
