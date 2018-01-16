package com.sys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
