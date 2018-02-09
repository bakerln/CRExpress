package com.common.filter;

import com.common.util.session.UserSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LiNan on 2018-01-31.
 * Description: HTTP过滤器
 */
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //TODO respose的对象属性是否会改变res的
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        System.out.println("拦截器中的session的id是====" + session.getId());
        UserSession userSession = (UserSession) session.getAttribute("userSession");
        if (null != userSession){
            System.out.println("登录用户为====" + userSession.getUsername());
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
