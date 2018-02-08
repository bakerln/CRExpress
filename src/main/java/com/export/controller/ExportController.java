package com.export.controller;

import com.common.util.json.JsonUtil;
import com.common.util.web.WebUtil;
import com.export.dto.SearchFormVO;
import com.export.service.ExportService;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linan on 2018-01-04.
 * Description: 处理所有的数据导出关系
 */
@RequestMapping(value = "/export")
@Controller
public class ExportController {

    @Autowired
    private ExportService exportService;
    /**
     *  查询
     * @param request
     * @param response
     * @param searchFormVO
     */
    @RequestMapping(value = "/view")
    public void view (HttpServletRequest request, HttpServletResponse response, SearchFormVO searchFormVO){
        int count = exportService.listCount(searchFormVO);
        String json = JsonUtil.createPageJson(count,exportService.listForm(searchFormVO));
        WebUtil.out(response,json);


    }

    @RequestMapping(value = "/out")
    public void out (HttpServletRequest request,HttpServletResponse response, SearchFormVO searchFormVO){
        exportService.out(request,response,searchFormVO);

    }


}
