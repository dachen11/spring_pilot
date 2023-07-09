package com.dachen11.pilot.dao;

import com.dachen11.pilot.model.Employee;
import com.dachen11.pilot.model.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql = """
                SELECT id, first_name, last_name, email
                FROM employee
                """;
        return this.jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int addEmployee(Employee employee) {
       // String values = employee.getId() + "," + employee.getFirstName() + "," + employee.getLastName() + "," + employee.getEmail();
        String sql = """
                INSERT INTO employee(id,first_name,last_name,email) 
                VALUES (CC_ENTITY_HIST_SEQ.nextval,?,?,?)
                """;
        return this.jdbcTemplate.update(sql, employee.getFirstName(),
                employee.getLastName(), employee.getEmail());
    }

    @Override
    public Optional<Employee> findById(int id) {
        String sql = """
                SELECT id, first_name, last_name, email
                FROM employee
                WHERE id = ?
                """;
       // Optional<Employee> thing = jdbcTemplate.query(sql, new EmployeeRowMapper()).get;
        return this.jdbcTemplate.query(sql, new EmployeeRowMapper(), id).stream().findFirst() ;
    }

    @Override
    public int deleteEmployee(int id) {
        String sql = """
                DELETE FROM employee
                WHERE id = ?
                """;
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateEmployee(int id, Employee employee) {
        String sql = """
                UPDATE employee
                SET first_name = ?, last_name = ?, email = ?
                WHERE id = ?
                """;
        return this.jdbcTemplate.update(sql, employee.getFirstName(),
                employee.getLastName(), employee.getEmail(), employee.getId());
    }
}
