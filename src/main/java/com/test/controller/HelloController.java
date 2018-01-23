package com.test.controller;

import com.common.util.json.JsonUtil;
import com.common.util.json.Student;
import com.common.util.web.WebUtil;
import com.test.dao.HelloDao;
import com.test.model.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-01-03.
 * Description:
 */
@RequestMapping(value = "/helloWorld")
@Controller
public class HelloController {
    @Autowired
    private HelloDao helloDao;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/add")
    public void add (){
        UserTest user = new UserTest();
        user.setId("3");
        user.setName("Briareos");
        int flag = helloDao.add(user);
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
