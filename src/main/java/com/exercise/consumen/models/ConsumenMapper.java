package com.exercise.consumen.models;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumenMapper implements RowMapper<Consumen> {

    @Override
    public Consumen mapRow(ResultSet rs, int rowNum) throws SQLException {
        Consumen consumen = new Consumen();
        consumen.setId(rs.getInt("id"));
        consumen.setName(rs.getString("name"));
        consumen.setAddress(rs.getString("address"));
        consumen.setCity(rs.getString("city"));
        consumen.setProvince(rs.getString("province"));
        consumen.setRegistrationDate(rs.getTimestamp("registration_date"));
        consumen.setStatus(rs.getString("status"));

        return consumen;
    }
}
