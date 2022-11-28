package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return  employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees(int size) {
        Pageable p = PageRequest.ofSize(size);
        Page<Employee> pageEmployee = employeeRepository.findAll(p);
        return pageEmployee.getContent();
    }

    @Override
    public List<Employee> filterEmployee(String query) {
        List<Employee> employees = employeeRepository.filterEmployee(query);
        return  employees;
    }

}
