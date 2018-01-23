package com.sys.controller;

import com.common.util.json.JsonUtil;
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
        int flag = userService.add(user,userSession);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"保存失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"保存成功"));
        }else if (flag == 2){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"用户代码已存在"));
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
        int flag = userService.update(user,userSession);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"修改失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"修改成功"));
        }

    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, User user){
        int flag = userService.delete(user);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"删除失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"删除成功"));
        }
    }

    /**
     * 修改密码
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/updatePassword")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response, User user,String newPassword) {
        int flag = userService.resetPassWord(user,newPassword);
        if (flag == 0)
            WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
        else if (flag == 1)
            WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
    }

    /**
     * 查看所建用户
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value = "/listUser")
    public void listUser(HttpServletRequest request, HttpServletResponse response, User user){
        ArrayList<User> userList = userService.listUser(user);
        WebUtil.out(response,JsonUtil.toStr(userList));
    }
}
