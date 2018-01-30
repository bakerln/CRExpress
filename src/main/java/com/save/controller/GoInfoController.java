package com.save.controller;

import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.save.model.GoInfo;
import com.save.service.GoInfoService;
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
public class GoInfoController {

    @Autowired
    private GoInfoService goInfoService;
    /**
     * 增加信息
     * @param request
     * @param response
     * @param goInfo //去程信息
     */
    @RequestMapping(value = "/add")
        public void add(HttpServletRequest request, HttpServletResponse response, GoInfo goInfo){
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = goInfoService.add(goInfo,userSession);

        WebUtil.out(response, JsonUtil.createOperaStr(true, "登录成功"));

    }


    @RequestMapping(value = "/update")
    public void update(){

    }

    @RequestMapping(value = "/delete")
    public void delete(){

    }

    @RequestMapping(value = "/list")
    public void list(){

    }
    @RequestMapping(value = "/weekSubmit")
    public void weekSubmit(){

    }

    @RequestMapping(value = "/monthSubmit")
    public void monthSubmit(){

    }
}
