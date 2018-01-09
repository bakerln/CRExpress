package com.save.controller;

import com.save.model.TransForm;
import com.save.service.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by linan on 2018-01-04.
 * Description: 处理所有数据录入业务逻辑
 */
@RequestMapping(value = "/business")
@Controller
public class DataEntryController {

    @Autowired
    private DataEntryService dataEntryService;

    @RequestMapping(value = "/add")
    public void add(HttpServletRequest request, HttpServletResponse response, TransForm transForm){

    }

    @RequestMapping(value = "/update")
    public void update(){

    }

    @RequestMapping(value = "/delete")
    public void delete(){

    }

    @RequestMapping(value = "/weekSubmit")
    public void weekSubmit(){

    }

    @RequestMapping(value = "/monthSubmit")
    public void monthSubmit(){

    }
}
