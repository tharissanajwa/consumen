package com.exercise.consumen.repositories;

import com.exercise.consumen.models.Consumen;
import com.exercise.consumen.models.ConsumenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// Class yang berfungsi sebagai repository
@Repository
public class ConsumenRepository implements ConsumenDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Consumen> getAll() {
        String sql = "SELECT id, name, address, city, province, registration_date, status FROM consumens";
        List<Consumen> consumens = jdbcTemplate.query(sql, new ConsumenMapper());
        return consumens;
    }

    @Override
    public Consumen getById(Integer id) {
        String sql = "SELECT id, name, address, city, province, registration_date, status FROM consumens WHERE id=?";
        Consumen consumen = jdbcTemplate.queryForObject(sql, new Object[]{id}, new ConsumenMapper());
        return consumen;
    }

    @Override
    public void insertConsumen(Consumen consumen) {
        String sql = "INSERT INTO consumens (name, address, city, province) "
                + "	VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, consumen.getName(), consumen.getAddress(), consumen.getCity(), consumen.getProvince());
    }

}
