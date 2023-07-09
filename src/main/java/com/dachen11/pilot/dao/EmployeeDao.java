package com.dachen11.pilot.dao;

import com.dachen11.pilot.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();
    int addEmployee(Employee employee);
    Optional<Employee> findById(int id);
    int deleteEmployee(int id);
    int updateEmployee(int id, Employee employee);
}
