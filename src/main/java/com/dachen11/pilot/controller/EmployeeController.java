package com.dachen11.pilot.controller;

import com.dachen11.pilot.dao.EmployeeDao;
import com.dachen11.pilot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @GetMapping("/all")
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @PostMapping("/add")
    public int addEmployee(@RequestBody Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @PostMapping("/update")
    public int updateEmployee(@RequestBody Employee employee) {
        return employeeDao.updateEmployee(employee.getId(), employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
    }




}
