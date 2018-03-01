package com.common.filter;

import com.common.util.session.UserSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LiNan on 2018-01-31.
 * Description: HTTP过滤器  基于Servlet
 */
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        System.out.println("Filter中的session的id是====" + session.getId());
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
