package com.export.model;

import com.common.util.page.SearchPage;

import java.util.Date;
/**
 * Created by linan on 2018-01-04.
 * Description: 发站model
 */
public class FormGo extends SearchPage{

    private String fromStation; //发站
    private String trainNumber; //车号
    private Date departDate; //发车日期
    private String exitPortStation; //出境口岸站
    private String overseasStation;  //境外到站
    private String overseasCountry; //境外到站所属国
    private String overseasCity;  //境外到站所属城市
    private String trainQty; //列数
    private String carriageQty; //车数
    private String HeavyQtyTwenty; //20尺重箱数
    private String emptyQtyTwenty; //20尺空箱数
    private String HeavyQtyForty; //40尺重箱数
    private String EmptyQtyForty; //40尺空箱数
    private String HeavyQtyFortyfive; //45尺重箱数
    private String EmptyQtyFortyfive; //45尺空箱数
    private String TEU; //折合TEU
    private String coldTEU; //其中冷藏箱TEU
    private String coldWeight; //冷藏箱重量
    private String remark; //备注

    private int id; //信息ID
    private int trainType; //车次类型 1：中欧 2：中亚 0:未指定
    private int orgID; //所属路局id
    private int userID; //添加人id
    private Date createTime; //录入时间
    private Date updateTime; //更新时间

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

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
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

    public String getHeavyQtyTwenty() {
        return HeavyQtyTwenty;
    }

    public void setHeavyQtyTwenty(String heavyQtyTwenty) {
        HeavyQtyTwenty = heavyQtyTwenty;
    }

    public String getEmptyQtyTwenty() {
        return emptyQtyTwenty;
    }

    public void setEmptyQtyTwenty(String emptyQtyTwenty) {
        this.emptyQtyTwenty = emptyQtyTwenty;
    }

    public String getHeavyQtyForty() {
        return HeavyQtyForty;
    }

    public void setHeavyQtyForty(String heavyQtyForty) {
        HeavyQtyForty = heavyQtyForty;
    }

    public String getEmptyQtyForty() {
        return EmptyQtyForty;
    }

    public void setEmptyQtyForty(String emptyQtyForty) {
        EmptyQtyForty = emptyQtyForty;
    }

    public String getHeavyQtyFortyfive() {
        return HeavyQtyFortyfive;
    }

    public void setHeavyQtyFortyfive(String heavyQtyFortyfive) {
        HeavyQtyFortyfive = heavyQtyFortyfive;
    }

    public String getEmptyQtyFortyfive() {
        return EmptyQtyFortyfive;
    }

    public void setEmptyQtyFortyfive(String emptyQtyFortyfive) {
        EmptyQtyFortyfive = emptyQtyFortyfive;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}






