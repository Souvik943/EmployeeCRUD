package com.java.rest.service;
import com.java.rest.model.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employees saveEmployees(Employees employees);

    List<Employees> getAllEmployees();

    Employees getEmployeeById(long id);

    Employees updateEmployee(Employees employee, long id);

    void deleteEmployee(long id);

}
