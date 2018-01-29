package com.export.controller;

import com.sys.model.User;
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

    /**
     *  查询
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/view")
    public void view (HttpServletRequest request, HttpServletResponse response, User user){

    }

}
