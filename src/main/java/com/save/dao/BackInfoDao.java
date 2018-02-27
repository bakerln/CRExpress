package com.save.dao;
import com.save.dto.BackInfoVO;
import com.common.util.page.PageUtil;
import com.common.util.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BackInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //新增信息
    public int add(BackInfoVO backInfoVO){
        String sql = "INSERT INTO BIS_FORM_BACK(ID,PORTSTATION,TRAINNUMBER,DEPARTDATE,DOMESTICSTATION,OVERSEASSTATION,OVERSEASCOUNTRY,OVERSEASCITY,TRAINTYPE,ORGID,USERID,CREATETIME,TRAINQTY,CARRIAGEQTY,HEAVYQTYTWENTY,EMPTYQTYTWENTY,HEAVYQTYFORTY,EMPTYQTYFORTY,HEAVYQTYFORTYFIVE,EMPTYQTYFORTYFIVE,TEU,COLDTEU,COLDWEIGHT,REMARK,STATUS,TOTALLOAD)"+
                "VALUES(:id,:portStation,:trainNumber,to_timestamp(:departDate, 'yyyy-mm-dd'),:domesticStation,:overseasStation,:overseasCountry,:overseasCity,:trainType,:orgID,:userID,sysdate,:trainQty,:carriageQty,:HeavyQtyTwenty,:EmptyQtyTwenty,:HeavyQtyForty,:EmptyQtyForty,:HeavyQtyFortyfive,:EmptyQtyFortyfive,:TEU,:coldTEU,:coldWeight,:remark,:status,:totalLoad)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //修改信息
    public int update(BackInfoVO backInfoVO) {
        String sql = "update BIS_FORM_BACK set PORTSTATION=:portStation,TRAINNUMBER=:trainNumber,DEPARTDATE=to_timestamp(:departDate, 'yyyy-mm-dd'),DOMESTICSTATION=:domesticStation,OVERSEASSTATION=:overseasStation,OVERSEASCOUNTRY=:overseasCountry,OVERSEASCITY=:overseasCity,UPDATETIME=sysdate,TRAINQTY=:trainQty,CARRIAGEQTY=:carriageQty,HEAVYQTYTWENTY=:HeavyQtyTwenty,EMPTYQTYTWENTY=:EmptyQtyTwenty,HEAVYQTYforty=:HeavyQtyForty,EMPTYQTYFORTY=:EmptyQtyForty,HEAVYQTYFORTYFIVE=:HeavyQtyFortyfive,EMPTYQTYFORTYFIVE=:EmptyQtyFortyfive,TEU=:TEU,COLDTEU=:coldTEU,COLDWEIGHT=:coldWeight,REMARK=:remark,TOTALLOAD=:totalLoad where ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    //删除信息
    public int delete(BackInfoVO backInfoVO) {
        String sql = "UPDATE BIS_FORM_BACK SET STATUS=3 WHERE ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    //展示信息
    public int listCount(BackInfoVO backInfoVO, UserSession userSession) {
        int userid = userSession.getUserId();
        String sql;
        if("4".equals(backInfoVO.getStatus())){
            sql = "select count(*) from BIS_FORM_BACK where USERID = " + userid + " and STATUS !=3";
        }
else{
            sql = "select count(*) from BIS_FORM_BACK where USERID = " + userid + " and STATUS=" + backInfoVO.getStatus();
        }
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
    }

    public List<BackInfoVO> listBackinfo(BackInfoVO backInfoVO, UserSession userSession) {
        int userid = userSession.getUserId();
        String sql;
        if ("4".equals(backInfoVO.getStatus())) {
            sql = "select * from BIS_FORM_BACK where USERID=" + userid + " and STATUS!=3";
        } else {
            sql = "select * from BIS_FORM_BACK where USERID=" + userid + " and STATUS=" + backInfoVO.getStatus();
        }
        sql = PageUtil.createOraclePageSQL(sql, backInfoVO.getPage(), backInfoVO.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        List<BackInfoVO> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(BackInfoVO.class));
        return list;
    }


    //提交数据
    public int submit(BackInfoVO backInfoVO) {
        String sql = "UPDATE BIS_FORM_BACK SET STATUS=2 WHERE ID=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(backInfoVO);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


}
