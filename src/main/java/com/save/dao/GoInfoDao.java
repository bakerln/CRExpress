package com.save.dao;

import com.common.util.page.PageUtil;
import com.common.util.session.UserSession;
import com.save.model.GoInfo;
import com.sys.model.User;
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

    public int createGOInfoId() {
        String sql = "select SEQ_SAVE_GOINFO.Nextval from dual";
        int goInfoId = jdbcTemplate.queryForObject(sql,Integer.class);
        return goInfoId;
    }

    //新增信息
    public int add(GoInfo goInfo) {
        String sql = "INSERT INTO SYS_GOINFO (ID,FROMSTATION,TRAINNUMBER,FROMDATE,EXITPORTSTATION,OVERSEASSTATION,OVERSEASCOUNTRY,OVERSEASCITY,TRAINSTATE,ORGID,USERID,CREATETIME,TRAINQTY,CARRIAGEQTY,HEAVYQTYTWENTY,EMPTYQTYTWENTY,HEAVYQTYFORTY,EMPTYQTYFORTY,HEAVYQTYFORTYFIVE,EMPTYQTYFORTYFIVE,TEU,COLDTEU,COLDWEIGHT,REMARK,ISDELETE,SAVETYPE) " +
                "VALUES(:id,:fromStation,:trainNumber,:fromDate,:exitPortStation,:overseasStation,:overseasCountry,:overseasCity,:trainState,:orgID,:userID,:createTime,:trainQty,:carriageQty,:HeavyQtyTwenty,:EmptyQtyTwenty,:HeavyQtyForty,:EmptyQtyForty,:HeavyQtyFortyfive,:EmptyQtyFortyfive,:TEU,:coldTEU,:coldWeight,:remark,:isDelete,:saveType)";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //修改信息
    public int update(GoInfo goInfo) {
        String sql = "update SYS_GOINFO set FROMSTATION=:fromStation,TRAINNUMBER=:trainNumber,FROMDATE=:fromDate,EXITPORTSTATION=:exitPortStation,OVERSEASSTATION=:overseasStation,OVERSEASCOUNTRY=:overseasCountry,OVERSEASCITY=:overseasCity,TRAINSTATE=:trainState,UPDATETIME=:updateTime,TRAINQTY=:trainQty,CARRIAGEQTY=:carriageQty,HEAVYQTYTWENTY=:HeavyQtyTwenty,EMPTYQTYTWENTY=:EmptyQtyTwenty,HEAVYQTYforty=:HeavyQtyForty,EMPTYQTYFORTY=:EmptyQtyForty,HEAVYQTYFORTYFIVE=:HeavyQtyFortyfive,EMPTYQTYFORTYFIVE=:EmptyQtyFortyfive,TEU=:TEU,COLDTEU=:coldTEU,COLDWEIGHT=:coldWeight,REMARK=:remark where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //删除信息
    public int delete(GoInfo goInfo) {
        String sql = "UPDATE SYS_GOINFO SET ISDELETE=:isDelete WHERE ID=id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //展示信息
    public int listCount(GoInfo goInfo,UserSession userSession) {
        int userid = userSession.getUserId();
        String sql = "select count(*) from SYS_GOINFO where USERID = "+userid+" and ISDELETE=1";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
    }

    public List<GoInfo> listGoinfo(GoInfo goInfo,UserSession userSession) {
        int userid = userSession.getUserId();
        String sql = "select * from SYS_GOINFO where USERID="+userid+" and ISDELETE=1";
        sql = PageUtil.createOraclePageSQL(sql, goInfo.getPage(), goInfo.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        List<GoInfo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(GoInfo.class));
        return list;
    }

    //提交数据
    public int submit(GoInfo goInfo) {
        String sql = "UPDATE SYS_GOINFO SET SAVETYPE=:saveType WHERE ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(goInfo);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


}
