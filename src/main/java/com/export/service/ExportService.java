package com.export.service;

import com.export.dao.ExportDao;
import com.export.dto.SearchFormVO;
import com.export.model.FormGo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-01-30.
 * Description:
 */
@Service
public class ExportService {

    @Autowired
    private ExportDao exportDao;
    //查询总数
    public int listCount(SearchFormVO searchFormVO) {
        return exportDao.listCount(searchFormVO);
    }

    public List listForm(SearchFormVO searchFormVO) {
        return exportDao.listForm(searchFormVO);
    }

    //导出数据
    public void out(HttpServletRequest request, HttpServletResponse response, SearchFormVO searchFormVO) {
        List<FormGo> list = exportDao.out(searchFormVO);

    }
}
