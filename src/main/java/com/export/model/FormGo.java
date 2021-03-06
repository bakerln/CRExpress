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
    private String departDate; //发车日期
    private String exitportStation; //出境口岸站
    private String overseasStation;  //境外到站
    private String overseasCountry; //境外到站所属国
    private String overseasCity;  //境外到站所属城市
    private int trainQty; //列数
    private int carriageQty; //车数
    private int heavyQtyTwenty; //20尺重箱数
    private int emptyQtyTwenty; //20尺空箱数
    private int heavyQtyForty; //40尺重箱数
    private int emptyQtyForty; //40尺空箱数
    private int heavyQtyFortyfive; //45尺重箱数
    private int emptyQtyFortyfive; //45尺空箱数
    private int teu; //折合TEU
    private int coldTEU; //其中冷藏箱TEU
    private int coldWeight; //冷藏箱重量
    private String remark; //备注
    private int totalLoad;//整车

    private String id; //信息ID
    private int trainType; //车次类型 1：中欧 2：中亚 0:未指定
    private int orgId; //所属路局id
    private int userId; //添加人id
    private String createTime; //录入时间
    private String updateTime; //更新时间
    private int status;//状态  1：暂存 2：提交 3：删除

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
        return heavyQtyTwenty;
    }

    public void setHeavyQtyTwenty(int heavyQtyTwenty) {
        this.heavyQtyTwenty = heavyQtyTwenty;
    }

    public int getEmptyQtyTwenty() {
        return emptyQtyTwenty;
    }

    public void setEmptyQtyTwenty(int emptyQtyTwenty) {
        this.emptyQtyTwenty = emptyQtyTwenty;
    }

    public int getHeavyQtyForty() {
        return heavyQtyForty;
    }

    public void setHeavyQtyForty(int heavyQtyForty) {
        this.heavyQtyForty = heavyQtyForty;
    }

    public int getEmptyQtyForty() {
        return emptyQtyForty;
    }

    public void setEmptyQtyForty(int emptyQtyForty) {
        this.emptyQtyForty = emptyQtyForty;
    }

    public int getHeavyQtyFortyfive() {
        return heavyQtyFortyfive;
    }

    public void setHeavyQtyFortyfive(int heavyQtyFortyfive) {
        this.heavyQtyFortyfive = heavyQtyFortyfive;
    }

    public int getEmptyQtyFortyfive() {
        return emptyQtyFortyfive;
    }

    public void setEmptyQtyFortyfive(int emptyQtyFortyfive) {
        this.emptyQtyFortyfive = emptyQtyFortyfive;
    }

    public int getTeu() {
        return teu;
    }

    public void setTeu(int teu) {
        this.teu = teu;
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

    public int getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(int totalLoad) {
        this.totalLoad = totalLoad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


