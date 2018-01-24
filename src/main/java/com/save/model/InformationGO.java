package com.save.model;

import java.util.Date;

public class InformationGO {
    private int id; //用户ID
    private String fromStation; //发站
    private String trainNumber; //车号
    private Date fromnDate; //发车日期
    private String exitPortStation; //出境口岸站
    private String overseasStation;  //境外到站
    private String overseasCountry; //境外到站所属国
    private String overseasCity;  //境外到站所属城市
    private int trainState; //车次类型 0：中欧 1：中亚
    private int orgID; //所属单位id
    private int updaterID; //添加人id
    private Date creatTime; //录入时间
    private Date updateTime; //更新时间
    private String trainQty; //列数
    private String carriageQty; //车数
    private String twHeavyQty; //20尺重箱数
    private String twEmptyQty; //20尺空箱数
    private String ftHeavyQty; //40尺重箱数
    private String frEmptyQty; //40尺空箱数
    private String ffHeavyQty; //45尺重箱数
    private String ffEmptyQty; //45尺空箱数
    private String TEU; //折合TEU
    private String coldTEU; //其中冷藏箱TEU
    private String coldWeight; //冷藏箱重量
    private String remark; //备注



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Date getFromnDate() {
        return fromnDate;
    }

    public void setFromnDate(Date fromnDate) {
        this.fromnDate = fromnDate;
    }

    public String getExitPortStation() {
        return exitPortStation;
    }

    public void setExitPortStation(String exitPortStation) {
        this.exitPortStation = exitPortStation;
    }

    public String getOverseasStation() {
        return overseasStation;
    }

    public void setOverseasStation(String overseasStation) {
        this.overseasStation = overseasStation;
    }

    public String getOverseasCountry() {
        return overseasCountry;
    }

    public void setOverseasCountry(String overseasCountry) {
        this.overseasCountry = overseasCountry;
    }

    public String getOverseasCity() {
        return overseasCity;
    }

    public void setOverseasCity(String overseasCity) {
        this.overseasCity = overseasCity;
    }

    public int getTrainState() {
        return trainState;
    }

    public void setTrainState(int trainState) {
        this.trainState = trainState;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public int getUpdaterID() {
        return updaterID;
    }

    public void setUpdaterID(int updaterID) {
        this.updaterID = updaterID;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTrainQty() {
        return trainQty;
    }

    public void setTrainQty(String trainQty) {
        this.trainQty = trainQty;
    }

    public String getCarriageQty() {
        return carriageQty;
    }

    public void setCarriageQty(String carriageQty) {
        this.carriageQty = carriageQty;
    }

    public String getTwHeavyQty() {
        return twHeavyQty;
    }

    public void setTwHeavyQty(String twHeavyQty) {
        this.twHeavyQty = twHeavyQty;
    }

    public String getTwEmptyQty() {
        return twEmptyQty;
    }

    public void setTwEmptyQty(String twEmptyQty) {
        this.twEmptyQty = twEmptyQty;
    }

    public String getFtHeavyQty() {
        return ftHeavyQty;
    }

    public void setFtHeavyQty(String ftHeavyQty) {
        this.ftHeavyQty = ftHeavyQty;
    }

    public String getFrEmptyQty() {
        return frEmptyQty;
    }

    public void setFrEmptyQty(String frEmptyQty) {
        this.frEmptyQty = frEmptyQty;
    }

    public String getFfHeavyQty() {
        return ffHeavyQty;
    }

    public void setFfHeavyQty(String ffHeavyQty) {
        this.ffHeavyQty = ffHeavyQty;
    }

    public String getFfEmptyQty() {
        return ffEmptyQty;
    }

    public void setFfEmptyQty(String ffEmptyQty) {
        this.ffEmptyQty = ffEmptyQty;
    }

    public String getTEU() {
        return TEU;
    }

    public void setTEU(String TEU) {
        this.TEU = TEU;
    }

    public String getColdTEU() {
        return coldTEU;
    }

    public void setColdTEU(String coldTEU) {
        this.coldTEU = coldTEU;
    }

    public String getColdWeight() {
        return coldWeight;
    }

    public void setColdWeight(String coldWeight) {
        this.coldWeight = coldWeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}






