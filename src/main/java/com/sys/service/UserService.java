package com.sys.service;

import com.sys.dao.UserDao;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by linan on 2018-01-04.
 * Description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int add(User user) {
        return 0;
    }

    public int update(User user) {
        return 0;
    }

    public int delete(int id) {
        return 0;
    }

    public int resetPassWord(int id) {
        return 0;
    }

    public static User getByUsername(String username) {
        return null;
    }

    public static boolean checkPass(User user, String password) {
        return false;
    }
}
