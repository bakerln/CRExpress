package com.export.dto;

import com.common.util.page.SearchPage;

import java.util.Date;

/**
 * Created by LiNan on 2018-01-30.
 * Description: Form查询VO
 */
public class SearchFormVO extends SearchPage{
    private String formType; // formBack、formGo
    private int orgID; //所属路局id
    private String departDateBegin; //发车日期开始
    private String departDateEnd; //发车日期结束
    private int trainType; //车次类型 1：中欧 2：中亚 0:未指定

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public String getDepartDateBegin() {
        return departDateBegin;
    }

    public void setDepartDateBegin(String departDateBegin) {
        this.departDateBegin = departDateBegin;
    }

    public String getDepartDateEnd() {
        return departDateEnd;
    }

    public void setDepartDateEnd(String departDateEnd) {
        this.departDateEnd = departDateEnd;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }
}
