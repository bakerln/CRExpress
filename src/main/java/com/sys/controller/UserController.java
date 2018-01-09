package com.sys.controller;

import com.common.util.json.JsonUtil;
import com.common.util.web.WebUtil;
import com.sys.model.User;
import com.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liNan on 2018-01-04.
 * Description: 处理所有用户关系
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/add")
    public void add (HttpServletRequest request, HttpServletResponse response, User user){
        int flag = userService.add(user);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"保存失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"保存成功"));
        }else if (flag == 2){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"用户代码已存在"));
        }

    }

    @RequestMapping(value = "/update")
    public void update(HttpServletRequest request, HttpServletResponse response, User user){
        int flag = userService.update(user);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"保存失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"保存成功"));
        }

    }

    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, int id){
        int flag = userService.delete(id);
        if(flag == 0){
            WebUtil.out(response,JsonUtil.createOperaStr(false,"删除失败"));
        }else if (flag == 1){
            WebUtil.out(response,JsonUtil.createOperaStr(true,"删除成功"));
        }
    }


    @RequestMapping(value = "/resetPass")
    public void resetPassWord(HttpServletRequest request, HttpServletResponse response, int id) {
        int flag = userService.resetPassWord(id);
        if (flag == 0)
            WebUtil.out(response, JsonUtil.createOperaStr(false, "操作失败"));
        else if (flag == 1)
            WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
    }

}
