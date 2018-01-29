package com.common.util.session;

import java.util.Date;

/**
 * Created by LiNan on 2018-01-09.
 * Description:  系统用户Session信息
 */
public class UserSession {
    private int userId; //用户ID
    private String username;//用户名
    private String password;// 登录密码
    private String randomCode;// 随机数
    private int status;// 账号状态 1:正常 2:可疑 3:删除
    private int roleId;// 角色代码 1:管理员 2:局级管理员 3:用户
    private String userRoleStr;// 角色描述
    private Date createDate;// 创建时间
    private String createPersonId;// 创建人ID
    private int orgId;// 单位id
    private String orgName;// 单位名称
    private String realName;//真实姓名
    private int gender;// 性别
    private String mobile;// 手机
    private String userIp;// 用户IP
    private String client_os_info;
    private String client_browser_info;
    private String client_browser_version;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getClient_os_info() {
        return client_os_info;
    }

    public void setClient_os_info(String client_os_info) {
        this.client_os_info = client_os_info;
    }

    public String getClient_browser_info() {
        return client_browser_info;
    }

    public void setClient_browser_info(String client_browser_info) {
        this.client_browser_info = client_browser_info;
    }

    public String getClient_browser_version() {
        return client_browser_version;
    }

    public void setClient_browser_version(String client_browser_version) {
        this.client_browser_version = client_browser_version;
    }
}
