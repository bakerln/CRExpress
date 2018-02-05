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
        String sql = "INSERT INTO SYS_GOINFO (ID,FROMSTATION,TRAINNUMBER,FROMDATE,EXITPORTSTATION,OVERSEASSTATION,OVERSEASCOUNTRY,OVERSEASCITY,TRAINSTATE,ORGID,USERID,CREATETIME,TRAINQTY,CARRIAGEQTY,HEAVYQTYTWENTY,EMPTYQTYTWENTY,HEAVYQTYFORTY,EMPTYQTYFORTY,HEAVYQTYFORTYFIVE,EMPTYQTYFORTYFIVE,TEU,COLDTEU,COLDWEIGHT,REMARK,ISDELETE,SAVETYPE) " +
                "VALUES(:id,fromStation,tiranNumber,fromDate,exitPortStation,overseasStation,overseasCountry,overseasCity,trainState,orgID,userID,createTime,trainQty,carriageQty,HeavyQtyTwenty,EmptyQtyTwenty,HeavyQtyForty,EmptyQtyForty,HeavyQtyFortyfive,EmptyFortyfive,TEU,coldTEU,coldWeight,remark,isDelete,saveType)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int update(GoInfo goInfo){
        String sql = "UPDATE SYS_GOINFO SET FROMSTATION=:fromStation,TRAINNUMBER=:trainNumber,FROMDATE=:fromDate,EXITPORTSTATION=:exitPortStation,OVERSEASSTATION=:overseasStation,OVERSEASCOUNTRY=:overseasCountry,OVERSEASCITY=:overseasCity,TRAINSTATE:=trainState,UPDATETIME=:updateTime,TRAINQTY=:trainQty,CARRIAGEQTY=:carriageQty,HEAVYQTYTWENTY=:HeavyQtyTwenty,EMPTYQTYTWENTY=:EmptyQtyTwenty,HEAVYQTYforty=:HeavyQtyForty,EMPTYQTYFORTY=:EmptyQtyForty,HEAVYQTYFORTYFIVE=:HeavyQtyFortyfive,EMPTYQTYFORTYFIVE=:EmptyQtyFortyfive,TEU=:TEU,COLDTEU=:coldTEU,COLDWEIGHT=:coldWeight,REMARK=:remark,ISDELETE=:isDelete,SAVETYPE=:saveType";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }







}
