package com.save.dao;

import com.save.model.GoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class GoInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createGOInfoId() {
        String sql = "select SEQ_SYS_GoInfo.Nextval from dual";
        int goInfoId = jdbcTemplate.queryForObject(sql, Integer.class);
        return goInfoId;
    }

    public int add(GoInfo goInfo) {
        String sql = "INSERT INTO SYS_GOINFO (ID,FROMSTATION,TRAINNUMBER,FROMDATE,EXITPORTSTATION,OVERSESASSTATION,OVERSEASCOUNTRY,OVERSEASCITY,TRAINSTATE,ORGID,USERID,CREATTIME,TRAINQTY,CARRIAGEQTY,HEAVYQTYTWENTY,EMPTYQTYTWENTY,HEAVYQTYFORTY,EMPTYQTYFORTY,HEAVYQTYFORTYFIVE,EMPTYQTYFORTYFIVE,TEU,COLDTEU,COLDWEIGHT,REMARK) " +
                "VALUES(:id,fromStation,tiranNumber,fromData,exitPortStation,overseasStation,overseasCountry,overseasCity,trainState,orgID,userID,creatTime,trainQty,carriageQty,heavyQtyTwenty,emptyQtyTwenty,heavyQtyForty,emptyQtyForty,heavyQtyFortyfive,emptyFortyfive,TEU,coldTEU,coldWeight,remark)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }
}
