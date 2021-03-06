package com.save.dto;


import com.common.util.page.SearchPage;

import java.util.Date;

/**
 * Created by Ren on 2018-01-30.
 * Description: 去程信息VO
 */

public class GoInfoVO extends SearchPage {
    private String id; //信息ID
    private String fromStation; //发站
    private String trainNumber; //车号
    private String departDate; //发车日期
    private String exitportStation; //出境口岸站
    private String overseasStation;  //境外到站
    private String overseasCountry; //境外到站所属国
    private String overseasCity;  //境外到站所属城市
    private String trainType; //车次类型 1：中欧 2：中亚
    private String orgID; //所属单位id
    private String userID; //添加人id
    private String createTime; //录入时间
    private String updateTime; //更新时间
    private String trainQty; //列数
    private String carriageQty; //车数
    private String HeavyQtyTwenty; //20尺重箱数
    private String EmptyQtyTwenty; //20尺空箱数
    private String HeavyQtyForty; //40尺重箱数
    private String EmptyQtyForty; //40尺空箱数
    private String HeavyQtyFortyfive; //45尺重箱数
    private String EmptyQtyFortyfive; //45尺空箱数
    private String teu; //折合TEU
    private String coldTEU; //其中冷藏箱TEU
    private String coldWeight; //冷藏箱重量
    private String remark; //备注
    private String status; //是否删除 1：暂存  2：提交 3：删除
    private String totalLoad;//整车数

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getExitportStation() {
        return exitportStation;
    }

    public void setExitportStation(String exitportStation) {
        this.exitportStation = exitportStation;
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

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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

    public String getHeavyQtyTwenty() {
        return HeavyQtyTwenty;
    }

    public void setHeavyQtyTwenty(String heavyQtyTwenty) {
        HeavyQtyTwenty = heavyQtyTwenty;
    }

    public String getEmptyQtyTwenty() {
        return EmptyQtyTwenty;
    }

    public void setEmptyQtyTwenty(String emptyQtyTwenty) {
        EmptyQtyTwenty = emptyQtyTwenty;
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

    public String getTeu() {
        return teu;
    }

    public void setTeu(String teu) {
        this.teu = teu;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
    }
}
