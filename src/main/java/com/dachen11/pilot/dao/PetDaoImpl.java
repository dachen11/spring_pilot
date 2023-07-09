package com.dachen11.pilot.dao;

import com.dachen11.pilot.model.Pet;
import com.dachen11.pilot.model.PetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetDaoImpl implements PetDao{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Pet> findAll() {
        String sql = """
                SELECT id, name, birth_date, type_id, owner_id
                FROM pets
                """;
        return this.jdbcTemplate.query(sql, new PetRowMapper());
    }
}
