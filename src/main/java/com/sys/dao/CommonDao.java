package com.sys.dao;

import com.sys.model.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-02-11.
 * Description:
 */
@Repository
public class CommonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Org> OrgList() {
        String sql = "select * from SYS_ORG";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<Org> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Org.class));
        return list;
    }

    public Org getOrg(String orgId) {
        Object[] params = new Object[] { orgId };
        String sql = "select * from SYS_ORG where ID=?";
        List<Org> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Org.class));
        return list.get(0);

    }
}
