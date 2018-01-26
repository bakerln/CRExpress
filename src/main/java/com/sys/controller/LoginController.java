package com.sys.controller;

import com.common.util.String.StringUtil;
import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.SessionUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.sys.dto.UserLoginDTO;
import com.sys.model.User;
import com.sys.service.UserService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by LiNan on 2018-01-09.
 * Description: 用户登录
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param request
     * @param response
     * @param userLoginDTO
     */
    @RequestMapping(value = "/checkLogin")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response, UserLoginDTO userLoginDTO){
        //处理用户请求所带信息
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        userLoginDTO.setIp(StringUtil.getIp(request));
        userLoginDTO.setClient_browser_info(userAgent.getBrowser().toString());
//        userLoginDTO.setClient_browser_version(userAgent.getBrowserVersion().toString());
        userLoginDTO.setClient_os_info(userAgent.getOperatingSystem().toString());
        //TODO 二维码验证

        //验证登录 （resultMsg返回user）
        ResultMsg resultMsg = userService.checkLogin(userLoginDTO);

        int state = resultMsg.getErrcode();
        if (state == 0){
            //登陆成功
            User user = (User)resultMsg.getData();
            UserSession userSession = userService.saveSession(user,userLoginDTO);
            request.getSession().setAttribute("userSession", userSession);
            //TODO 登录日志（userLoginDTO）
            WebUtil.out(response, JsonUtil.createOperaStr(true, "登录成功"));
        } else {
            //登陆失败
            WebUtil.out(response, JsonUtil.createOperaStr(false,"用户名或密码错误"));
        }
    }

    /**
     * 首页面
     * @param request
     * @param response
     */
    @RequestMapping(value = "/index")
    public void index(HttpServletRequest request,HttpServletResponse response){
        UserSession userSession = SessionUtil.getUserSession(request);
        if (userSession != null){
            ArrayList<String> list = new ArrayList<String>();
            list.add("");
        }
    }

    /**
     * 退出
     * @param request
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userSession");
//        request.getSession().invalidate();
        WebUtil.out(response, JsonUtil.createOperaStr(true, "操作成功"));
    }
}
