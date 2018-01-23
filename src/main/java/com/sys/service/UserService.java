package com.sys.service;

import com.common.util.String.Md5SaltUtil;
import com.common.util.String.StringUtil;
import com.common.util.session.UserSession;
import com.sys.dao.UserDao;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by linan on 2018-01-04.
 * Description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //新增用户
    public int add(User user, UserSession userSession) {
        int userId = userDao.createUserId();
        user.setId(userId);
        user.setStatus(0);
        user.setCreateDate(new Date());

        if(userSession != null){
            user.setCreatePersonId(userSession.getUserId());
        }
        String salt = StringUtil.createRandomCode(8);
        Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");
        user.setRandomCode(salt);
        user.setPassword(encoderMd5.encode(user.getPassword()));

        return userDao.add(user);
    }

    //修改信息
    public int update(User user, UserSession userSession) {
        if(userSession != null){
            user.setId(userSession.getUserId());
        }
        return userDao.update(user);
    }

    public int delete(User user) {
        return 0;
    }

    public int resetPassWord(User user,String newPassword) {
        return 0;
    }

    public User getByUsername(String username) {
        return null;
    }

    public boolean checkPass(User user, String password) {
        return false;
    }

    public ArrayList<User> listUser(User user){
        return null;
    }

}
