package com.sys.controller;

import com.common.util.String.StringUtil;
import com.common.util.json.JsonUtil;
import com.common.util.session.UserSession;
import com.common.util.web.WebUtil;
import com.sys.model.User;
import com.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    /**
     * 登录校验
     * @param request
     * @param response
     * @param username
     * @param password
     */
    @RequestMapping(value = "/checkLogin")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response,String username,String password){
        User user = UserService.getByUsername(username);
        if (user == null || !UserService.checkPass(user,password)){
            WebUtil.out(response, JsonUtil.createOperaStr(false,"用户名或密码错误"));
        }else{
            if (user.getStatus() == 2){
                WebUtil.out(response, JsonUtil.createOperaStr(false, "该用户已锁定"));
            }else{
                UserSession userSession = new UserSession();
                userSession.setUserId(user.getId());
                userSession.setUsername(user.getUsername());
                userSession.setUserIp(StringUtil.getIp(request));
                userSession.setMobile(user.getMobile());//电话
                userSession.setRoleId(user.getRoleId());
                request.getSession().setAttribute("userSession", userSession);
                //TODO 登录日志
                WebUtil.out(response, JsonUtil.createOperaStr(true, "登录成功"));
            }
        }
    }
}
