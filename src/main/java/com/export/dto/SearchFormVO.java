package com.export.dto;

import java.util.Date;

/**
 * Created by LiNan on 2018-01-30.
 * Description: Form查询VO
 */
public class SearchFormVO {
    private String FormType; // formBack、formGo
    private int orgID; //所属路局id
    private Date departDateBegin; //发车日期开始
    private Date departDateEnd; //发车日期结束
    private int trainType; //车次类型 1：中欧 2：中亚 0:未指定

    public String getFormType() {
        return FormType;
    }

    public void setFormType(String formType) {
        FormType = formType;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public Date getDepartDateBegin() {
        return departDateBegin;
    }

    public void setDepartDateBegin(Date departDateBegin) {
        this.departDateBegin = departDateBegin;
    }

    public Date getDepartDateEnd() {
        return departDateEnd;
    }

    public void setDepartDateEnd(Date departDateEnd) {
        this.departDateEnd = departDateEnd;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }
}
