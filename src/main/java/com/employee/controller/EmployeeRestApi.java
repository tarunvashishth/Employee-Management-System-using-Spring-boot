package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestApi {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public List<Employee> getEmployeeInfo(@RequestParam(value = "size",defaultValue = "1", required = false) Integer size){
        return this.employeeService.getAllEmployees(size);
    }

    @GetMapping(value = "/employeefilter")
    public ResponseEntity<List<Employee>> getEmployeeFiltered(@RequestParam("query") String query){
        return ResponseEntity.ok(employeeService.filterEmployee(query));
    }
}
