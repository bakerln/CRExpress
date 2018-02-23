package com.save.controller;
import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.save.model.BackInfo;
import com.save.service.BackInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.save.dto.BackInfoVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by ren on 2018-02-09
 * Description:处理回程数据录入逻辑
 */

@RequestMapping(value = "/saveBack")
@Controller
public class BackInfoController {

    @Autowired
    private BackInfoService backInfoService;

    /**
     * 增加信息
     *
     * @param request
     * @param response
     * @param backInfoVO
     */
    @RequestMapping(value = "/add")
    public void add(HttpServletRequest request, HttpServletResponse response, BackInfoVO backInfoVO) {
//        UserSession userSession = (UserSession)request.getAttribute("userSession");
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = backInfoService.add(backInfoVO, userSession);
        if (0 == resultMsg.getErrcode()){
            WebUtil.out(response, JsonUtil.createOperaStr(true, "添加成功"));
        }else if(2 == resultMsg.getErrcode()){
            WebUtil.out(response, JsonUtil.createOperaStr(true, "该用户不允许添加信息"));
        }else if(1 == resultMsg.getErrcode()){
            WebUtil.out(response, JsonUtil.createOperaStr(true, "请重新登录"));
        }else{
            WebUtil.out(response, JsonUtil.createOperaStr(true, "保存失败"));
        }
    }


    /**
    * 修改信息
    * @param request
    * @param response
    * @param backInfoVO
    */
    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public void update(HttpServletRequest request, HttpServletResponse response, BackInfoVO backInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = backInfoService.update(backInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "修改成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "信息已提交"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "修改失败"));
        }
    }

    /**
     * 删除信息
     * @param request
     * @param response
     * @param backInfoVO
     */
    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response, BackInfoVO backInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = backInfoService.delete(backInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "删除成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "未取得登录信息，请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "信息已提交"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "删除失败"));
        }
    }


    /**
     * 信息展示
     * @param request
     * @param response
     * @param backInfoVO
     */
    @RequestMapping(value = "/list", method= RequestMethod.POST )
    public void listBackinfo(HttpServletRequest request, HttpServletResponse response, BackInfoVO backInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        int count = backInfoService.listCount(backInfoVO,userSession);
        String json = JsonUtil.createPageJson(count, backInfoService.listBackinfo(backInfoVO,userSession));
        WebUtil.out(response, json);
    }

    /**
     * 提交
     * @param request
     * @param response
     * @param backInfoVO
     */
    @RequestMapping(value = "/submit")
    public void submit(HttpServletRequest request, HttpServletResponse response, BackInfoVO backInfoVO) {
        UserSession userSession = SessionUtil.getUserSession(request);
        ResultMsg resultMsg = backInfoService.submit(backInfoVO, userSession);
        if (0 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "提交成功"));
        } else if (1 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "未取得登录信息，请重新登录"));
        } else if (2 == resultMsg.getErrcode()) {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "信息已提交"));
        } else {
            WebUtil.out(response, JsonUtil.createOperaStr(true, "提交失败"));
        }
    }


}
