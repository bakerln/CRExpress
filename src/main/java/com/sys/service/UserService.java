package com.sys.service;

import com.common.util.String.Md5SaltUtil;
import com.common.util.String.StringUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.UserSession;
import com.sys.dao.UserDao;
import com.sys.dto.UserLoginDTO;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by linan on 2018-01-04.
 * Description: 用户业务逻辑
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //新增用户
    public ResultMsg add(User user, UserSession userSession) {
        if(userSession != null){
            int userId = userDao.createUserId();
            user.setId(userId);
            user.setStatus(0);
            user.setCreateDate(new Date());
            user.setCreatePersonId(userSession.getUserId());
            String salt = StringUtil.createRandomCode(8);
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");
            user.setRandomCode(salt);
            user.setPassword(encoderMd5.encode(user.getPassword()));
            //判断数据合法
            if(null == userDao.getUserByPhoneNum(user.getMobile()) && null == userDao.getUserByUsername(user.getUsername())){
                userDao.add(user);
                return new ResultMsg(0,"添加成功",null);
            }
            return new ResultMsg(2,"用户已存在",null);
        }else {
            return new ResultMsg(1,"未取得登陆信息",null);
        }

    }

    //修改信息
    public ResultMsg update(User user, UserSession userSession) {
        if(userSession != null){
            user.setId(userSession.getUserId());
            if(null == userDao.getUserByPhoneNum(user.getMobile()) && null == userDao.getUserByUsername(user.getUsername())){
                if (StringUtil.isNullOrEmpty(user.getRealName())) user.setRealName(userSession.getRealName());
                if (user.getGender() == 0) user.setGender(userSession.getGender());
                if (StringUtil.isNullOrEmpty(user.getMobile())) user.setRealName(userSession.getMobile());
                if (StringUtil.isNullOrEmpty(user.getUsername())) user.setUsername(userSession.getUsername());
                userDao.update(user);
                return new ResultMsg(0,"修改成功",null);
            }
            return new ResultMsg(2,"用户名已占用",null);
        }else {
            return new ResultMsg(1,"未取得登陆信息",null);
        }
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


    public ArrayList<User> listUser(User user){
        return null;
    }

    public ResultMsg checkLogin(UserLoginDTO userLoginDTO) {
        User user;
        //判断用户名是否是手机号
        boolean flag = StringUtil.isPhoneNum(userLoginDTO.getUsername());
        if (flag){
            user = userDao.getUserByPhoneNum(userLoginDTO.getUsername());
        }else{
            user = userDao.getUserByUsername(userLoginDTO.getUsername());
        }
        //判断用户是否存在
        if (null != user){
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(user.getRandomCode(), "MD5");
            String passwordWithSalt = encoderMd5.encode(userLoginDTO.getPassword());
            //判断用户密码是否正确
            if (passwordWithSalt.equals(user.getPassword())){
                //判断用户状态
                if(user.getStatus() == 0){
                    return new ResultMsg(0,"登录成功",user);
                }else{
                    return new ResultMsg(1,"用户已被删除",null);
                }
            }else{
                return new ResultMsg(1,"密码错误",null);
            }
        }else{
            //登录失败
            return new ResultMsg(2,"用户不存在",user);
        }
    }

    public UserSession saveSession(User user, UserLoginDTO userLoginDTO) {
        UserSession userSession = new UserSession();

        userSession.setUserId(user.getId());
        userSession.setUsername(user.getUsername());
        userSession.setRealName(user.getRealName());
        userSession.setMobile(user.getMobile());

        userSession.setRoleId(user.getRoleId());
        userSession.setUserRoleStr(user.getUserRoleStr());
        userSession.setOrgId(user.getOrgId());
        userSession.setOrgName(user.getOrgName());
        userSession.setGender(user.getGender());
        userSession.setUserIp(userLoginDTO.getIp());
        userSession.setClient_browser_info(userLoginDTO.getClient_browser_info());

        return userSession;
    }
}
