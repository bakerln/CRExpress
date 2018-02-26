package com.sys.controller;

import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.sys.model.User;
import com.sys.service.UserService;
import oracle.sql.OracleJdbc2SQLInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liNan on 2018-01-04.
 * Description: 处理所有用户关系
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 增加用户
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/add")
    public void add (HttpServletRequest request, HttpServletResponse response, User user){
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = userService.add(user,userSession);
        if(0 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"保存成功"));
        }else if (1 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"保存失败"));
        }else if (2 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"用户名或电话已存在"));
        }else if (3 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"未填写所属路局"));
        }

    }


    /**
     * 修改用户
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/update")
    public void update(HttpServletRequest request, HttpServletResponse response, User user){
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = userService.update(user,userSession);
        if (0 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"修改成功"));
        }else if(1 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"修改失败"));
        }else if(2 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"用户名已存在"));
        }else if(3 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"电话号已存在"));
        }
    }

    /**
     * 删除单个用户
     * @param request
     * @param response
     * @param user 中的id
     */
    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, User user){
        ResultMsg resultMsg = userService.delete(user);
        if(0 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"删除成功"));
        }else if (1 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"删除失败，有子用户未删除"));
        }
    }

    /**
     * 删除列表
     * @param request
     * @param response
     * @param listIdVO
     */
    @RequestMapping(value = "/deleteList")
    public void deleteList(HttpServletRequest request, HttpServletResponse response, String listIdVO){
        List listIds = (List) JsonUtil.toObject(listIdVO,List.class);
        String idString = "";
        for (Object i:listIds) {
            HashMap map = (HashMap) i;
            if ("".equals(idString)){
                idString += map.get("id");
            }else{
                idString += "," + map.get("id");
            }
        }
        ResultMsg resultMsg = userService.deleteList(idString);
        if(0 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"删除成功"));
        }else if (1 == resultMsg.getErrcode()){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"删除失败，有子用户未删除"));
        }
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @param password
     * @param newPassword
     */
    @RequestMapping(value = "/updatePassword")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response, String password, String newPassword) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = userService.updatePassword(userSession,password,newPassword);
        if (0 == resultMsg.getErrcode())
            WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
        else if (1 == resultMsg.getErrcode())
            WebUtil.out(response, JsonUtil.createOperaStr(false, "原密码不正确"));
        else if (2 == resultMsg.getErrcode())
            WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
    }

    /**
     * 查看所建用户
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listUser")
    public void listUser(HttpServletRequest request, HttpServletResponse response,User user){
        UserSession userSession = SessionUtil.getUserSession(request);
        userSession.setLimit(user.getLimit());
        userSession.setPage(user.getPage());
        if (null != userSession){
            int count = userService.listCount(userSession);
            String json = JsonUtil.createPageJson(count,userService.listUser(userSession));
            WebUtil.out(response,json);
        }else{
            WebUtil.out(response, JsonUtil.createOperaStr(false, "用户未登录"));
        }

    }

    /**
     * 查看个人信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/info")
    public void info(HttpServletRequest request,HttpServletResponse response){
        UserSession userSession = SessionUtil.getUserSession(request);
        if (null == userSession){
            WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
        }else{
            WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功",userSession ));
        }
    }

    /**
     * 重置密码
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/resetPassword")
    public void resetPassword (HttpServletRequest request,HttpServletResponse response,User user){
        ResultMsg resultMsg = userService.resetPassword(user);
        if (0 == resultMsg.getErrcode())
            WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
        else
            WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
    }
}
