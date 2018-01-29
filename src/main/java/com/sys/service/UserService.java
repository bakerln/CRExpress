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
import java.util.List;

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
            user.setStatus(1);
            user.setCreateDate(new Date());
            user.setCreatePersonId(userSession.getUserId());
            String salt = StringUtil.createRandomCode(8);
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");
            user.setRandomCode(salt);
            user.setPassword(encoderMd5.encode(user.getPassword()));
            //判断是否是路局管理员
            if (2 == userSession.getRoleId()){
                user.setRoleId(3);
                user.setOrgId(userSession.getOrgId());
                user.setOrgName(userSession.getOrgName());
            }else{
                //系统管理员
                user.setRoleId(2);
                user.setOrgId(user.getOrgId());
                user.setOrgName(user.getOrgName());
            }
            //判断数据合法
            if(null == userDao.getUserByPhoneNum(user.getMobile()) && null == userDao.getUserByUsername(user.getUsername())){
                userDao.add(user);
                return new ResultMsg(0,"添加成功",null);
            }else{
                //已删除
                User userHasName = userDao.getUserByUsername(user.getUsername());
                User userHasMobile = userDao.getUserByPhoneNum(user.getMobile());
                if (2 == userHasMobile.getStatus() || 2 == userHasName.getStatus()){
                    userDao.add(user);
                    return new ResultMsg(0,"添加成功",null);
                }
                return new ResultMsg(2,"用户名或电话已存在",null);
            }

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

    //删除用户
    public ResultMsg delete(User user) {
        //无子用户
        if(3 == user.getRoleId()){
            user.setStatus(2);
            userDao.delete(user);
            return new ResultMsg(0,"删除成功",null);
        }else if (null == userDao.getUserByCreateUserId(user.getId())){
            user.setStatus(2);
            userDao.delete(user);
            return new ResultMsg(0,"删除成功",null);
        }else {
            return new ResultMsg(1,"有子用户未删除",null);
        }
    }

    public ResultMsg resetPassWord(UserSession userSession, String password, String newPassword) {
        User user;
        if (!StringUtil.isNullOrEmpty(userSession.getUsername())){
            user = userDao.getUserByPhoneNum(userSession.getUsername());
            //判断原密码是否正确
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(user.getRandomCode(), "MD5");
            String passwordWithSalt = encoderMd5.encode(password);
            if (passwordWithSalt.equals(user.getPassword())){
                //修改密码
                user.setPassword(encoderMd5.encode(newPassword));
                userDao.resetPassWord(user);
                return new ResultMsg(0,"修改成功",null);
            }else{
                return new ResultMsg(1,"原密码不正确",null);
            }
        }else {
            return new ResultMsg(2,"未取得登陆信息",null);
        }
    }



    public List<User> listUser(User user){
        List<User> userlist = userDao.listUser(user);

        return userlist;
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
                if(user.getStatus() == 1){
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

    //保存session
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

    public int listCount(User user) {
        return userDao.listCount(user);
    }
}
