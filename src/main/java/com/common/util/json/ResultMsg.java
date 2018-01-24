package com.common.util.json;

/**
 * Created by LiNan on 2018-01-24.
 * Description: 封装返回的结果,把webapi的结果封装返回给webapp
 */
public class ResultMsg {

    private int errcode;
    private String errmsg;
    private Object data;

    public ResultMsg(int ErrCode, String ErrMsg, Object data) {
        this.errcode = ErrCode;
        this.errmsg = ErrMsg;
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
