package com.export.dao;

import com.export.dto.SearchFormVO;
import com.export.model.FormGo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public int listCount(SearchFormVO searchFormVO) {
        return 0;
    }

    public List listForm(SearchFormVO searchFormVO) {
        return null;
    }

    public List<FormGo> out(SearchFormVO searchFormVO) {
        String sql;
        if ("formGo".equals(searchFormVO.getFormType())){
            sql = "select * from BIZ_FORM_GO where 1=1";
        } else if ("formBack".equals(searchFormVO.getFormType())){
            sql = "select * from BIZ_FORM_BACK where 1=1";
        } else{
            return null;
        }
        sql += createSearchSql(searchFormVO);
        return null;
    }

    private String createSearchSql(SearchFormVO searchFormVO) {
        String sql;
        return "";
    }
}
