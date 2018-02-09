package com.export.dao;

import com.common.util.String.StringUtil;
import com.common.util.page.PageUtil;
import com.export.dto.SearchFormVO;
import com.export.model.FormBack;
import com.export.model.FormGo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-01-30.
 * Description:
 */
@Repository
public class ExportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String createSearchSql(SearchFormVO searchFormVO) {
        String sql = " AND STATUS = 2";
        //车次类型 1：中欧 2：中亚 0:未指定
        if(0 != searchFormVO.getTrainType()){
            sql += " AND t.TRAINRTYPE = :trainType";
        }
        //所属路局id
        if (0 != searchFormVO.getTrainType()){
            sql += " AND t.ORGID = :orgID";
        }
        if (!StringUtil.isNullOrEmpty(searchFormVO.getDepartDateBegin())) {
            sql += " and t.DEPARTDATE >= to_date(:departDateBegin ,'yyyy-MM-dd hh24:mi:ss')";
        }
        if (!StringUtil.isNullOrEmpty(searchFormVO.getDepartDateEnd())) {
            sql += " and t.DEPARTDATE <= to_date(:departDateEnd ,'yyyy-MM-dd hh24:mi:ss') ";
        }
        return sql;
    }

    //查询列表
    public int listCountGo(SearchFormVO searchFormVO) {
        String sql = "select count(*) from BIS_FORM_GO t where 1=1";
        sql += createSearchSql(searchFormVO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchFormVO);
        return namedParameterJdbcTemplate.queryForObject(sql,paramSource,Integer.class);
    }

    public int listCountBack(SearchFormVO searchFormVO) {
        String sql = "select count(*) from BIS_FORM_BACK t where 1=1";
        sql += createSearchSql(searchFormVO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchFormVO);
        return namedParameterJdbcTemplate.queryForObject(sql,paramSource,Integer.class);
    }


    public List listFormGo(SearchFormVO searchFormVO) {
        String sql = "select * from BIS_FORM_GO t where 1=1 ";
        sql += createSearchSql(searchFormVO);
        sql += " order by t.DEPARTDATE desc";
        sql = PageUtil.createOraclePageSQL(sql,searchFormVO.getPage(),searchFormVO.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchFormVO);
        List<FormGo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(FormGo.class));
        return list;
    }

    public List listFormBack(SearchFormVO searchFormVO) {
        String sql = "select * from BIS_FORM_BACK t where 1=1 ";
        sql += createSearchSql(searchFormVO);
        sql += " order by t.DEPARTDATE desc";
        sql = PageUtil.createOraclePageSQL(sql,searchFormVO.getPage(),searchFormVO.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchFormVO);
        List<FormBack> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(FormBack.class));
        return list;
    }

    //导出列表
    public List<FormGo> outGo(SearchFormVO searchFormVO) {
        String sql = "select * from BIS_FORM_GO t where 1=1";
        sql = PageUtil.createOraclePageSQL(sql,searchFormVO.getPage(),searchFormVO.getLimit());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchFormVO);
        List<FormGo> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper<>(FormGo.class));
        return list;
    }

    public List<FormBack> outBack(SearchFormVO searchFormVO) {
        String sql = "select * from BIS_FORM_BACK t where 1=1";
        return null;
    }


}
