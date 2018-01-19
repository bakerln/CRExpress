package com.sys.model;

import java.util.Date;

/**
 * Created by linan on 2018-01-04.
 * Description: 用户model
 */
public class User {
    private int id; //用户ID
    private String username;//用户名
    private String password;// 登录密码
    private String randomCode;// 随机数
    private int status;// 账号状态 0:正常 1:可疑 2:删除
    private int roleId;// 角色代码 0:管理员 1:局级管理员 2:用户
    private String userRoleStr;// 角色描述
    private Date createDate;// 创建时间
    private int createPersonId;// 创建人ID
    private int orgId;// 单位id
    private String orgName;// 单位名称
    private String realName;//真实姓名
    private String gender;// 性别 男:1 女:2
    private String mobile;// 手机


//    private String default_module;// 默认模块


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserRoleStr() {
        return userRoleStr;
    }

    public void setUserRoleStr(String userRoleStr) {
        this.userRoleStr = userRoleStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(int createPersonId) {
        this.createPersonId = createPersonId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
