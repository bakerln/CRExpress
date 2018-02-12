package com.export.dto;

import com.common.util.page.SearchPage;

import java.util.Date;

/**
 * Created by LiNan on 2018-01-30.
 * Description: Form查询VO
 */
public class SearchFormVO extends SearchPage{
    private String formType; // formBack、formGo
    private String orgID; //所属路局id
    private String departDateBegin; //发车日期开始
    private String departDateEnd; //发车日期结束
    private String trainType; //车次类型 1：中欧 2：中亚 0:未指定
    private String status;  //状态  1：暂存 2：提交 3：删除

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
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

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
