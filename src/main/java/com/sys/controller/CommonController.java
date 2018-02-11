package com.sys.controller;

import com.common.util.json.JsonUtil;
import com.common.util.web.WebUtil;
import com.sys.model.Org;
import com.sys.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-02-11.
 * Description:
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 获取OrgList
     * @param request
     * @param response
     */
    @RequestMapping(value = "/orgList")
    public void OrgList(HttpServletRequest request, HttpServletResponse response){
        List<Org> list = commonService.OrgList();
        WebUtil.out(response, JsonUtil.toStr(list));

    }

    /**
     * 获取OrgId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getOrg")
    public void getOrg(HttpServletRequest request,HttpServletResponse response,int orgId){
        Org org = commonService.getOrg(orgId);
        String json = JsonUtil.toStr(org);
        WebUtil.out(response,json);
    }
}
