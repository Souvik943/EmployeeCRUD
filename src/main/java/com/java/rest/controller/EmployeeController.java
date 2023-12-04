package com.java.rest.controller;

import com.java.rest.model.Employees;
import com.java.rest.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //CREATE Employee API
    @PostMapping("/employee/create")
    public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees){

        return new ResponseEntity<>(employeeService.saveEmployees(employees), HttpStatus.CREATED);

    }

    //Get All Employees API
    @GetMapping("/employee/getAllEmployees")
    public List<Employees> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable("id") long id , @RequestBody Employees employees){
        return new ResponseEntity<>(employeeService.updateEmployee(employees,id),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Deleted",HttpStatus.OK);
    }
}
