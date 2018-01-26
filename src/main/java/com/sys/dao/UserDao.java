package com.sys.dao;

import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUserId() {
        String sql = "select SEQ_SYS_USER.Nextval from dual";
        int userId = jdbcTemplate.queryForObject(sql,Integer.class);
        return userId;
    }

    public int add(User user) {
        String sql = "INSERT INTO SYS_USER (ID,USERNAME,PASSWORD,RANDOMCODE,STATUS,ROLEID,USERROLESTR,CREATEDATE,CREATEPERSONID,ORGID,ORGNAME,REALNAME,GENDER,MOBILE) " +
                     "VALUES(:id,:username,:password,:randomCode,:status,:roleId,:userRoleStr,:createDate,:createPersonId,:orgId,:orgName,:realName,:gender,:mobile) ";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);

    }

    public int update(User user) {
        String sql = "update SYS_USER set REALNAME=:realName,GENDER=:gender,MOBILE=:mobile,USERNAME=:username where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public User getUserByPhoneNum(String mobile) {
        Object[] params = new Object[] { mobile };
        String sql = "select * from SYS_USER where MOBILE=?";
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public User getUserByUsername(String username) {
        Object[] params = new Object[] { username };
        String sql = "select * from SYS_USER where USERNAME=?";
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
