package com.sys.dao;

//import com.alibaba.druid.sql.PagerUtils;
import com.common.util.page.PageUtil;
import com.common.util.session.UserSession;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //判断用户是否存在
    private String createSearchSql() {
        //1:正常 2:删除 3:可疑
        String sql = " AND STATUS = 1";

        return sql;
    }

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
        sql += createSearchSql();
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public User getUserByUserID(int id) {
        Object[] params = new Object[] { id };
        String sql = "select * from SYS_USER where ID=?";
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public User getUserByUsername(String username) {
        Object[] params = new Object[] { username };
        String sql = "select * from SYS_USER where USERNAME=?";
        sql += createSearchSql();
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public int updatePassword(User user) {
        String sql = "update SYS_USER set PASSWORD=:password where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int delete(User user) {
        String sql = "update SYS_USER set STATUS=:status where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public User getUserByCreateUserId(int id) {
        Object[] params = new Object[] { id };
        String sql = "select * from SYS_USER where CREATEPERSONID=?";
        sql += createSearchSql();
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public int listCount(UserSession userSession) {
        String sql = "select count(*) from SYS_USER where CREATEPERSONID=:userId";
        sql += createSearchSql();
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userSession);
        return namedParameterJdbcTemplate.queryForObject(sql,paramSource,Integer.class);
    }

    public List<User> listUser(UserSession userSession) {
        String sql = "select * from SYS_USER where CREATEPERSONID=:userId";
        sql += createSearchSql();
        sql = PageUtil.createOraclePageSQL(sql,userSession.getPage(),userSession.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(userSession);
        List<User> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public int resetPassword(User user) {
        String sql = "update SYS_USER set PASSWORD=:password where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }
}
