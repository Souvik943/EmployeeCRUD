package com.java.rest.service.impl;

import com.java.rest.exception.ResourceNotFoundException;
import com.java.rest.model.Employees;
import com.java.rest.repository.EmployeeRepository;
import com.java.rest.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employees saveEmployees(Employees employees) {
        return employeeRepository.save(employees);
    }

    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employees getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employees updateEmployee(Employees employee, long id) {
        Employees existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
