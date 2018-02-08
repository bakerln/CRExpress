package com.common.util.session;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
public class SessionUtil {

    public static UserSession getUserSession(HttpServletRequest request){
        if (request.getSession().getAttribute("userSession") != null ){
            return (UserSession) request.getSession().getAttribute("userSession");
        }else{
            return null;
        }
    }
}
