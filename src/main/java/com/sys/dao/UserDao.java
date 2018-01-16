package com.sys.dao;

import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

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
        String sql = "INSERT INTO SYS_USER (ID,USERNAME,PASSWORD,RANDOMCODE,STATUS,ROLEID,USERROLESTR,CREATEDATE,CREATEPERSONID,ORGID,ORGNAME,REALNAME,MOBILE,GENDER) " +
                "VALUES(:id,:username,:password,:randomCode,:status,:roleId,:userRoleStr,:createDate,:createPersonId,:orgId,:orgName,:realName,:gender,:mobile) ";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);

    }
}
