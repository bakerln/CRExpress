package com.user.controller;

import com.user.model.BusinessMan;
import com.user.service.UserService;
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

//    @Autowired
//    private UserService userService;

    @RequestMapping(value = "/add")
    public void add (HttpServletRequest request, HttpServletResponse response, BusinessMan businessMan){

    }

    @RequestMapping(value = "/update")
    public void update(HttpServletRequest request, HttpServletResponse response, BusinessMan businessMan){

    }

    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, BusinessMan businessMan){

    }

}
