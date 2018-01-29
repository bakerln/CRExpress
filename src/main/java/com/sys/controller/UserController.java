package com.sys.controller;

import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.sys.model.User;
import com.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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
            WebUtil.out(response,JsonUtil.createOperaStr(false,"用户已存在"));
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
        }
    }

    /**
     * 删除用户
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
     * 修改密码
     * @param request
     * @param response
     * @param password
     * @param newPassword
     */
    @RequestMapping(value = "/updatePassword")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response, String password,String newPassword) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = userService.resetPassWord(userSession,password,newPassword);
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
     * @param user
     */
    @RequestMapping(value = "/listUser")
    public void listUser(HttpServletRequest request, HttpServletResponse response, User user){
        int count = userService.listCount(user);
        String json = JsonUtil.createPageJson(count,userService.listUser(user));
        WebUtil.out(response,json);
    }
}
