package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.model.Fashion;

@Repository
public class FashionRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static RowMapper<Fashion> FASHION_ROW_MAPPER = new BeanPropertyRowMapper<>(Fashion.class);

    public List<Fashion> findFashionList(String color, Integer gender) {
        StringBuilder query = new StringBuilder().append("select category,genre,price,size, gender, color from clothes");
        query.append(" where gender = :gender and color = :color");
        SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
        List<Fashion> fashionList = template.query(query.toString(), param, FASHION_ROW_MAPPER);
        return fashionList;
    }
}
