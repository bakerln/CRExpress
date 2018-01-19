package com.sys.service;

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
        user.setCreateDate(new Date());
        user.setCreatePersonId(userSession.getUserId());
        return userDao.add(user);
    }

    public int update(User user) {
        return 0;
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
