package com.save.dao;

import com.common.util.page.PageUtil;
import com.common.util.session.UserSession;
import com.save.dto.GoInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GoInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    //新增信息
    public int add(GoInfoVO goInfoVO) {
        String sql = "INSERT INTO BIS_FORM_GO (ID,FROMSTATION,TRAINNUMBER,DEPARTDATE,EXITPORTSTATION,OVERSEASSTATION,OVERSEASCOUNTRY,OVERSEASCITY,TRAINTYPE,ORGID,USERID,CREATETIME,TRAINQTY,CARRIAGEQTY,HEAVYQTYTWENTY,EMPTYQTYTWENTY,HEAVYQTYFORTY,EMPTYQTYFORTY,HEAVYQTYFORTYFIVE,EMPTYQTYFORTYFIVE,TEU,COLDTEU,COLDWEIGHT,REMARK,STATUS,TOTALLOAD) " +
                "VALUES(:id,:fromStation,:trainNumber,to_timestamp(:departDate, 'yyyy-mm-dd'),:exitPortStation,:overseasStation,:overseasCountry,:overseasCity,:trainType,:orgID,:userID,sysdate,:trainQty,:carriageQty,:HeavyQtyTwenty,:EmptyQtyTwenty,:HeavyQtyForty,:EmptyQtyForty,:HeavyQtyFortyfive,:EmptyQtyFortyfive,:TEU,:coldTEU,:coldWeight,:remark,:status,:totalLoad)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //修改信息
    public int update(GoInfoVO goInfoVO) {
        String sql = "update BIS_FORM_GO set FROMSTATION=:fromStation,TRAINNUMBER=:trainNumber,DEPARTDATE=to_timestamp(:departDate, 'yyyy-mm-dd'),EXITPORTSTATION=:exitPortStation,OVERSEASSTATION=:overseasStation,OVERSEASCOUNTRY=:overseasCountry,OVERSEASCITY=:overseasCity,TRAINTYPE=:trainType,UPDATETIME=sysdate,TRAINQTY=:trainQty,CARRIAGEQTY=:carriageQty,HEAVYQTYTWENTY=:HeavyQtyTwenty,EMPTYQTYTWENTY=:EmptyQtyTwenty,HEAVYQTYforty=:HeavyQtyForty,EMPTYQTYFORTY=:EmptyQtyForty,HEAVYQTYFORTYFIVE=:HeavyQtyFortyfive,EMPTYQTYFORTYFIVE=:EmptyQtyFortyfive,TEU=:TEU,COLDTEU=:coldTEU,COLDWEIGHT=:coldWeight,REMARK=:remark,TOTALLOAD=:totalLoad,STATUS=:status where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //删除信息
    public int delete(GoInfoVO goInfoVO) {
        String sql = "UPDATE BIS_FORM_GO SET STATUS=3 WHERE ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //展示信息
    public int listCount(GoInfoVO goInfoVO,UserSession userSession) {
        int userid = userSession.getUserId();
        String sql;
        if("4".equals(goInfoVO.getStatus()) ){
            sql= "select count(*) from BIS_FORM_GO where USERID = "+userid+" and STATUS !=3";
        }
        else {
            sql = "select count(*) from BIS_FORM_GO where USERID = " + userid + " and STATUS=" + goInfoVO.getStatus();
        }
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
    }

    public List<GoInfoVO> listGoinfo(GoInfoVO goInfoVO,UserSession userSession) {
        int userid = userSession.getUserId();
        String sql;
        if("4".equals(goInfoVO.getStatus()))
        {
            sql = "select * from BIS_FORM_GO where USERID="+userid+" and STATUS!=3";
        }
        else {
            sql = "select * from BIS_FORM_GO where USERID=" + userid + " and STATUS=" + goInfoVO.getStatus();
        }
        sql = PageUtil.createOraclePageSQL(sql, goInfoVO.getPage(), goInfoVO.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        List<GoInfoVO> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(GoInfoVO.class));
        return list;
    }

    //提交数据
    public int submit(GoInfoVO goInfoVO) {
        String sql = "UPDATE BIS_FORM_GO SET STATUS=2 WHERE ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int createTrainId() {
    String sql = "select SEQ_BIS_TRAIN.Nextval from dual";

    return jdbcTemplate.queryForObject(sql,Integer.class);
}
    public  String createDate() {
        String sql = "select to_char(sysdate,'yyyyMMdd') from dual";

        return jdbcTemplate.queryForObject(sql,String.class);
    }
}
