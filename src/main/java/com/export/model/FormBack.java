package com.export.model;

import com.common.util.page.SearchPage;

import java.util.Date;

/**
 * Created by linan on 2018-01-04.
 * Description: 回站model
 */
public class FormBack extends SearchPage{
    private String portStation; //口岸站
    private String trainNumber; //车号
    private Date departDate; //发车日期
    private String domesticStation; //国内到站
    private String overseasStation;  //境外发
    private String overseasCountry; //境外发站所属国
    private String overseasCity;  //境外发站所属城市
    private int trainQty; //列数
    private int carriageQty; //车数
    private int HeavyQtyTwenty; //20尺重箱数
    private int EmptyQtyTwenty; //20尺空箱数
    private int HeavyQtyForty; //40尺重箱数
    private int EmptyQtyForty; //40尺空箱数
    private int HeavyQtyFortyfive; //45尺重箱数
    private int EmptyQtyFortyfive; //45尺空箱数
    private int TEU; //折合TEU
    private int coldTEU; //其中冷藏箱TEU
    private int coldWeight; //冷藏箱重量
    private String remark; //备注

    private int id; //趟次ID
    private int trainType; //车次类型 1：中欧 2：中亚 0:未指定
    private int orgID; //所属路局id
    private int userID; //添加人id
    private Date createTime; //录入时间
    private Date updateTime; //更新时间

    public String getPortStation() {
        return portStation;
    }

    public void setPortStation(String portStation) {
        this.portStation = portStation;
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

    public String getDomesticStation() {
        return domesticStation;
    }

    public void setDomesticStation(String domesticStation) {
        this.domesticStation = domesticStation;
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

    public int getTrainQty() {
        return trainQty;
    }

    public void setTrainQty(int trainQty) {
        this.trainQty = trainQty;
    }

    public int getCarriageQty() {
        return carriageQty;
    }

    public void setCarriageQty(int carriageQty) {
        this.carriageQty = carriageQty;
    }

    public int getHeavyQtyTwenty() {
        return HeavyQtyTwenty;
    }

    public void setHeavyQtyTwenty(int heavyQtyTwenty) {
        HeavyQtyTwenty = heavyQtyTwenty;
    }

    public int getEmptyQtyTwenty() {
        return EmptyQtyTwenty;
    }

    public void setEmptyQtyTwenty(int emptyQtyTwenty) {
        EmptyQtyTwenty = emptyQtyTwenty;
    }

    public int getHeavyQtyForty() {
        return HeavyQtyForty;
    }

    public void setHeavyQtyForty(int heavyQtyForty) {
        HeavyQtyForty = heavyQtyForty;
    }

    public int getEmptyQtyForty() {
        return EmptyQtyForty;
    }

    public void setEmptyQtyForty(int emptyQtyForty) {
        EmptyQtyForty = emptyQtyForty;
    }

    public int getHeavyQtyFortyfive() {
        return HeavyQtyFortyfive;
    }

    public void setHeavyQtyFortyfive(int heavyQtyFortyfive) {
        HeavyQtyFortyfive = heavyQtyFortyfive;
    }

    public int getEmptyQtyFortyfive() {
        return EmptyQtyFortyfive;
    }

    public void setEmptyQtyFortyfive(int emptyQtyFortyfive) {
        EmptyQtyFortyfive = emptyQtyFortyfive;
    }

    public int getTEU() {
        return TEU;
    }

    public void setTEU(int TEU) {
        this.TEU = TEU;
    }

    public int getColdTEU() {
        return coldTEU;
    }

    public void setColdTEU(int coldTEU) {
        this.coldTEU = coldTEU;
    }

    public int getColdWeight() {
        return coldWeight;
    }

    public void setColdWeight(int coldWeight) {
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
