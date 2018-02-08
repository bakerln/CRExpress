package com.save.model;

import com.common.util.page.SearchPage;

import java.util.Date;

public class GoInfo extends SearchPage{
    private int id; //信息ID
    private String fromStation; //发站
    private String trainNumber; //车号
    private Date fromDate; //发车日期
    private String exitPortStation; //出境口岸站
    private String overseasStation;  //境外到站
    private String overseasCountry; //境外到站所属国
    private String overseasCity;  //境外到站所属城市
    private int trainState; //车次类型 1：中欧 2：中亚
    private int orgID; //所属单位id
    private int userID; //添加人id
    private Date createTime; //录入时间
    private Date updateTime; //更新时间
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
    private int isDelete; //是否删除 1：可用  2：删除
    private int saveType;// 存储状态 1：暂存 2：提交


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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getSaveType() {
        return saveType;
    }

    public void setSaveType(int saveType) {
        this.saveType = saveType;
    }
}






