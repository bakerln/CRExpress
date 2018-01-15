package com.sys.model;

/**
 * Created by LiNan on 2018-01-15.
 * Description: 单位model
 */
public class Org {
    private int id; //单位ID
    private String OrgStr; //单位名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgStr() {
        return OrgStr;
    }

    public void setOrgStr(String orgStr) {
        OrgStr = orgStr;
    }
}
