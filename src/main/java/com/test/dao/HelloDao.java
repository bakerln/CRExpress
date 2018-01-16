package com.test.dao;

import com.test.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * Created by LiNan on 2018-01-10.
 * Description:
 */
@Repository
public class HelloDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add (UserTest userTest){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into TEST (id,name) values (:id,:name)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(userTest);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }
}
