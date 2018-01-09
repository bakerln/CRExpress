package com.sys.model;

import java.util.Date;

/**
 * Created by linan on 2018-01-04.
 * Description:
 */
public class User {
    private int id;
    private String userRoleStr;// 角色描述
    private String code;// 代码
    private String username;// Email
    private String password;// 登录密码
    private String randomcode;// 随机数
    private int status;// 账号状态
    private String realname;// 姓名
    private String gender;// 性别
    private String mobile;// 手机
    private String phone;// 座机
    private int role_id;// 角色代码
    private String default_module;// 默认模块
    private Date create_date;// 创建时间
    private String create_person;// 创建人

    private int dwid;// 单位id
    private String dwmc;// 单位名称
    private String dwjb;// 单位级别

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRoleStr() {
        return userRoleStr;
    }

    public void setUserRoleStr(String userRoleStr) {
        this.userRoleStr = userRoleStr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getDefault_module() {
        return default_module;
    }

    public void setDefault_module(String default_module) {
        this.default_module = default_module;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreate_person() {
        return create_person;
    }

    public void setCreate_person(String create_person) {
        this.create_person = create_person;
    }

    public int getDwid() {
        return dwid;
    }

    public void setDwid(int dwid) {
        this.dwid = dwid;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwjb() {
        return dwjb;
    }

    public void setDwjb(String dwjb) {
        this.dwjb = dwjb;
    }
}
