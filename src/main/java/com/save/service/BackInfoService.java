package com.save.service;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.common.util.date.DateUtil;
import com.common.util.json.ResultMsg;
import com.common.util.session.UserSession;
import com.save.dao.BackInfoDao;
import com.save.dao.GoInfoDao;
import com.save.dto.GoInfoVO;
import com.save.model.BackInfo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.save.dto.BackInfoVO;
import java.util.Date;
import java.util.List;

/**
 * Created by ren on 2018-02-09.
 * Description: 回程逻辑
 */
@Service
public class BackInfoService {

    @Autowired
    private BackInfoDao backInfoDao;

    @Autowired
    public GoInfoDao goInfoDao;


    //得到id
    public String backId(BackInfoVO backInfoVO) {
        int id = goInfoDao.createTrainId();
        String date = goInfoDao.createDate();
        String flag = backInfoVO.getTrainType();
        String idString = date + flag + id;
        System.out.println(idString);
        return idString;
    }

    //新增信息
    public ResultMsg add(BackInfoVO backInfoVO, UserSession userSession) {
        if(userSession != null){
          //判断角色
            if(1 == userSession.getRoleId()){
                return new ResultMsg(2,"该用户不允许添加信息",null);
            }else {
                backInfoVO.setId(backId(backInfoVO));//添加ID
                backInfoVO.setUserID(String.valueOf(userSession.getUserId()));//添加创建人ID
                backInfoVO.setStatus("1");//设置删除状态为暂存
                backInfoVO.setOrgID(String.valueOf(userSession.getOrgId()));//添加所属单位ID
                backInfoDao.add(backInfoVO);
            }
        } else{
            return new ResultMsg(1,"无法取到登录信息",null);
        }
        return new ResultMsg(0,"添加成功",null);
    }

    //修改信息
    public ResultMsg update(BackInfoVO backInfoVO, UserSession userSession) {
        if (userSession != null) {
            //判断存储状态
            if("2" .equals(backInfoVO.getStatus()) ){
                return new ResultMsg(2,"信息已经提交",null);
            } else {
                backInfoDao.update(backInfoVO);
            }
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0, "修改成功", null);
    }

    //删除信息
    public ResultMsg delete(BackInfoVO backInfoVO, UserSession userSession) {
        if (userSession != null) {
            //判断存储状态
            if ("2" .equals(backInfoVO.getStatus())) {
                return new ResultMsg(2, "信息已提交", null);
            } else {
                backInfoVO.setStatus("3");//设置状态为删除
                backInfoDao.delete(backInfoVO);
            }
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0, "删除成功", null);
    }

    //信息展示
    public int listCount(BackInfoVO backInfoVO,UserSession userSession) {
        return backInfoDao.listCount(backInfoVO,userSession);
    }
    public List<BackInfoVO> listBackinfo(BackInfoVO backInfoVO,UserSession userSession) {
        List<BackInfoVO> backInfoList = backInfoDao.listBackinfo(backInfoVO,userSession);
        return backInfoList;
    }


    //提交信息
    public ResultMsg submit(BackInfoVO backInfoVO, UserSession userSession) {
        if (userSession != null) {
            //判断是否删除
            if ("2" .equals(backInfoVO.getStatus()) ) {
                return new ResultMsg(2, "信息已提交", null);
            } else {
                backInfoVO.setStatus("2");//设置存储状态为提交
                backInfoDao.submit(backInfoVO);
            }
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0, "提交成功", null);
    }

}
