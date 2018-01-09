package com.test.controller;

import com.common.util.json.JsonUtil;
import com.common.util.json.Student;
import com.common.util.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-01-03.
 * Description:
 */
@RequestMapping(value = "")
@Controller
public class HelloController {
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping(value = "json")
    public void json(HttpServletRequest request, HttpServletResponse response){
        Student linan = new Student();
        linan.setAge(26);
        linan.setName("linan");
        String json = JsonUtil.toStr(linan);
        WebUtil.out(response,json);
    }
}
