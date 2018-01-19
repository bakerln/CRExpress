package com.sys.model;

/**
 * Created by LiNan on 2018-01-15.
 * Description: 单位model
 */
public class Org {
    private int id; //单位ID
    private String OrgStr; //单位名称
    private int flag;//单位级别 0:总公司 1:路局
    private int upperUnitId;//上级单位

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getUpperUnitId() {
        return upperUnitId;
    }

    public void setUpperUnitId(int upperUnitId) {
        this.upperUnitId = upperUnitId;
    }
}
