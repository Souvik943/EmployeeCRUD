package com.java.rest.repository;

import com.java.rest.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
}
