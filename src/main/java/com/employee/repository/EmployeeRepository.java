package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT p FROM Employee p WHERE " +
            "p.department LIKE CONCAT('%',:query, '%')" +
            "Or p.position LIKE CONCAT('%', :query, '%')"
    )
    List<Employee> filterEmployee(String query);
}
