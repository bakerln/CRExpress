package com.sys.service;

import com.common.util.String.Md5SaltUtil;
import com.common.util.String.StringUtil;
import com.common.util.global.GlobalConst;
import com.common.util.json.ResultMsg;
import com.common.util.session.UserSession;
import com.sys.dao.CommonDao;
import com.sys.dao.UserDao;
import com.sys.dto.UserLoginDTO;
import com.sys.model.Org;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CommonDao commonDao;

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
            //用户初始密码11111111
            user.setPassword(encoderMd5.encode(GlobalConst.password));
            //判断是否是路局管理员
            if (2 == userSession.getRoleId()){
                user.setRoleId(3);
                user.setOrgId(userSession.getOrgId());
                user.setOrgName(userSession.getOrgName());

            }else if (1 == userSession.getRoleId() ){
                //系统管理员
                user.setRoleId(2);
                if (0 == user.getOrgId()){
                    return new ResultMsg(3,"未填写所属路局",null);
                }
                user.setOrgId(user.getOrgId());
                Org org = commonDao.getOrg(user.getOrgId()+"");
                user.setOrgName(org.getOrgStr());
            }
            //判断数据合法
            if(null == userDao.getUserByPhoneNum(user.getMobile()) && null == userDao.getUserByUsername(user.getUsername())){
                userDao.add(user);
                return new ResultMsg(0,"添加成功",null);
            }else{
                //已删除
                //TODO 删除后重新添加导致用户名不唯一
                User userHasName = userDao.getUserByUsername(user.getUsername());
                User userHasMobile = userDao.getUserByPhoneNum(user.getMobile());
                if (null != userHasName && null != userHasMobile){
                    if (2 == userHasMobile.getStatus() && 2 == userHasName.getStatus()){
                        userDao.add(user);
                        return new ResultMsg(0,"添加成功",null);
                    }else {
                        return new ResultMsg(2,"用户名或电话已存在",null);
                    }
                } else if (null != userHasName && 2 == userHasName.getStatus()){
                    userDao.add(user);
                    return new ResultMsg(0,"添加成功",null);
                } else if (null != userHasMobile && 2 == userHasMobile.getStatus()){
                    userDao.add(user);
                    return new ResultMsg(0,"添加成功",null);
                }else{
                    return new ResultMsg(2,"用户名或电话已存在",null);
                }
            }

        }else {
            return new ResultMsg(1,"未取得登陆信息",null);
        }

    }


    //修改信息
    public ResultMsg update(User user, UserSession userSession) {
        if(userSession != null){
            user.setId(userSession.getUserId());
            if (!userSession.getUsername().equals(user.getUsername())){
                if (null != userDao.getUserByUsername(user.getUsername())){
                    return new ResultMsg(2,"用户名已占用",null);
                }
            }
            if (!userSession.getMobile().equals(user.getMobile())){
                if (null != userDao.getUserByPhoneNum(user.getMobile())){
                    return new ResultMsg(3,"电话已占用",null);
                }
            }
            if (StringUtil.isNullOrEmpty(user.getRealName())) user.setRealName(userSession.getRealName());
            if (user.getGender() == 0) user.setGender(userSession.getGender());
            if (StringUtil.isNullOrEmpty(user.getMobile())) user.setMobile(userSession.getMobile());
            if (StringUtil.isNullOrEmpty(user.getUsername())) user.setUsername(userSession.getUsername());
            userDao.update(user);
            return new ResultMsg(0,"修改成功",null);
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

    //修改密码
    public ResultMsg updatePassword(UserSession userSession, String password, String newPassword) {
        if (null != userSession){
            User user = userDao.getUserByUserID(userSession.getUserId());
            //判断原密码是否正确
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(user.getRandomCode(), "MD5");
            String passwordWithSalt = encoderMd5.encode(password);
            if (passwordWithSalt.equals(user.getPassword())){
                //修改密码
                user.setPassword(encoderMd5.encode(newPassword));
                userDao.updatePassword(user);
                return new ResultMsg(0,"修改成功",null);
            }else{
                return new ResultMsg(1,"原密码不正确",null);
            }
        }else {
            return new ResultMsg(2,"未取得登陆信息",null);
        }
    }



    public List<User> listUser(UserSession userSession){
        List<User> userlist = userDao.listUser(userSession);

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
                    return new ResultMsg(3,"用户已被删除",null);
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

    public int listCount(UserSession userSession) {
        return userDao.listCount(userSession);
    }

    public ResultMsg resetPassword(User user) {
        if(0 != user.getId()){
            User oldUser = userDao.getUserByUserID(user.getId());
            String salt = oldUser.getRandomCode();
            //用户初始密码11111111
            Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");
            user.setPassword(encoderMd5.encode(GlobalConst.password));
           userDao.resetPassword(user);
           return new ResultMsg(0,"修改成功",null);
        } else
            return new ResultMsg(1,"重置失败",null);
    }

    //批量删除(只允许删除普通用户)
    public ResultMsg deleteList(String idString) {
        //无子用户
        userDao.deleteList(idString);
        return new ResultMsg(0,"删除成功",null);
    }
}
