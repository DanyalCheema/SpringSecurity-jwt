package com.security.poc.repository;

import com.security.poc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author by Danyal
 * @classname EmployeeRepo
 * @Date 28/10/2023 7:50 pm
 */

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
