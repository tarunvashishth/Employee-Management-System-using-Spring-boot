package com.employee.service;

import com.employee.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService{
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    List<Employee> getAllEmployees(int size);
    List<Employee> filterEmployee(String query);

}
