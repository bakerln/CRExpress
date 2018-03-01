package com.common.redis;

/**
 * Created by LiNan on 2018-02-27.
 * Description:
 */
public class RedisKeyUtil {
    /**
     * 注册短信验证码，注册时发送
     */
    public static final String SMSCODE_REGIST_KEY = "CRPAY:CACHE:SMSCODE:REGIST:";
    /**
     * 注册短信 验证码有效期
     */
    public static final int SMSCODE_REGIST_KEY_LONG = 5 * 60;
    /**
     * 注册短信验证码发送次数key
     */
    public static final String SMSCODE_REGIST_COUNT_KEY = "CRPAY:CACHE:SMSCODE:REGISTCOUNT:";

    /**
     * 找回密码短信验证码，找回密码时发送
     */
    public static final String SMSCODE_FINDPWD_KEY = "CRPAY:CACHE:SMSCODE:FINDPWD:";
    /**
     * 找回密码短信 验证码有效期
     */
    public static final int SMSCODE_FINDPWD_KEY_LONG = 5 * 60;
    /**
     * 找回密码短信验证码发送次数key
     */
    public static final String SMSCODE_FINDPWD_COUNT_KEY = "CRPAY:CACHE:SMSCODE:FINDPWDCOUNT:";

    /**
     * 注册短信验证码发送次数
     */
    public static final int SMSCODE_REGIST_COUNT = 5;
    /**
     * 密码输入错误redis过期时间key值
     */
    public static final String LOGIN_PASSWORDERROR_KEY = "CRPAY:CACHE:PASSWORDERROR:LOGIN:";//锁定一个小时
    /**
     * 密码输入错误redis过期时间
     */
    public static final int LOGIN_PASSWORDERROR_KEY_LONG = 60 * 60;//锁定一个小时
    /**
     * 该ip登陆错误redis过期时间key值
     */
    public static final String LOGIN_IPERROR_KEY = "CRPAY:CACHE:PASSWORDERROR:LOGIN:";//锁定一个小时
    /**
     * 该ip登陆错误redis过期时间
     */
    public static final int LOGIN_IPERROR_KEY_LONG = 60 * 60;//锁定一个小时

    /**
     * 转账短信验证码，转账时发送
     */
    public static final String SMSCODE_TRANSFER_KEY = "CRPAY:CACHE:SMSCODE:TRANSFER:";
    /**
     * 转账短信 验证码有效期
     */
    public static final int SMSCODE_TRANSFER_KEY_LONG = 5 * 60;
    /**
     * 转账短信验证码发送次数key
     */
    public static final String SMSCODE_TRANSFER_COUNT_KEY = "CRPAY:CACHE:SMSCODE:TRANSFERCOUNT:";

    /**
     * 提现短信验证码，转账时发送
     */
    public static final String SMSCODE_CASH_KEY = "CRPAY:CACHE:SMSCODE:CASH:";
    /**
     * 提现短信 验证码有效期
     */
    public static final int SMSCODE_CASH_KEY_LONG = 5 * 60;
    /**
     * 提现短信验证码发送次数key
     */
    public static final String SMSCODE_CASH_COUNT_KEY = "CRPAY:CACHE:SMSCODE:CASHCOUNT:";
}
