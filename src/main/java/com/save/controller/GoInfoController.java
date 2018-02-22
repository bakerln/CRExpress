package com.save.controller;


import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.save.model.GoInfo;
import com.save.service.GoInfoService;
import com.save.dto.GoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linan on 2018-01-04.
 * Description: 处理所有数据录入业务逻辑
 */
@RequestMapping(value = "/saveGo")
@Controller
public class GoInfoController {

    @Autowired
    private GoInfoService goInfoService;

    /**
     * 增加信息
     *
     * @param request
     * @param response
     * @param goInfoVO
     */
    @RequestMapping(value = "/add")
    public void add(HttpServletRequest request, HttpServletResponse response, GoInfoVO goInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = goInfoService.add(goInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "添加成功"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "该用户不允许添加信息"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "用户未登陆"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "保存失败"));
        }
    }

    /**
     * 修改信息
     *
     * @param request
     * @param response
     * @param goInfoVO
     */
    @RequestMapping(value = "/update")
    public void update(HttpServletRequest request, HttpServletResponse response, GoInfoVO goInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = goInfoService.update(goInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "修改成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "已提交信息不允许修改"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "修改失败"));
        }
    }

    /**
     * 删除信息
     *
     * @param request
     * @param response
     * @param goInfoVO
     */

    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, GoInfoVO goInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = goInfoService.delete(goInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "未取得登录信息，请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "已提交的数据不可删除"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "删除失败"));
        }
    }

    /**
     * 信息展示
     * @param request
     * @param response
     * @param goInfoVO
     */
    @RequestMapping(value = "/list", method= RequestMethod.POST )
    public void listGoinfo(HttpServletRequest request, HttpServletResponse response, GoInfoVO goInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        int count = goInfoService.listCount(goInfoVO,userSession);
        String json = JsonUtil.createPageJson(count, goInfoService.listGoinfo(goInfoVO,userSession));
        WebUtil.out(response, json);
    }


    /**
     * 提交
     * @param request
     * @param response
     * @param goInfoVO
     */
    @RequestMapping(value = "/submit")
    public void submit(HttpServletRequest request, HttpServletResponse response, GoInfoVO goInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = goInfoService.submit(goInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "提交成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "未取得登录信息，请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "已提交的数据不可再次提交"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "提交失败"));
        }
    }



}