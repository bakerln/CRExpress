package com.save.service;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.common.util.json.ResultMsg;
import com.common.util.session.UserSession;
import com.save.dao.GoInfoDao;
import com.save.model.GoInfo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import com.sys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by linan on 2018-01-04.
 * Description:
 */
@Service
public class GoInfoService {

    @Autowired
    private GoInfoDao goInfoDao;

    //新增信息
    public ResultMsg add(GoInfo goInfo, UserSession userSession) {
        if (userSession != null) {
               //判断用户角色
            if (1 == userSession.getRoleId()) {
                return new ResultMsg(2, "该用户不允许添加信息", null);
            }
            else {
                int goInfoID = goInfoDao.createGOInfoId();
                goInfo.setId(goInfoID);//添加信息ID
                goInfo.setCreateTime(new Date());//添加创建时间
                goInfo.setUserID(userSession.getUserId());//添加创建用户ID
                goInfo.setIsDelete(1);//设置删除状态为“可用”
                goInfo.setSaveType(1);//设置存储状态为“暂存”
                goInfo.setOrgID(userSession.getOrgId());//添加创建人所属单位
                goInfoDao.add(goInfo);
            }
            //判断数据合法性 数据合法性规则未知
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0,"添加成功",null);
    }

     //修改信息
     public ResultMsg update(GoInfo goInfo, UserSession userSession) {
         if (userSession != null) {
             //判断存储状态
             if(2 == goInfo.getSaveType()){
                 return new ResultMsg(2,"已提交信息不允许修改",null);
             } else {
                 goInfo.setUpdateTime(new Date());//添加更新时间
                 goInfoDao.update(goInfo);
             }
         } else {
             return new ResultMsg(1, "未取得登录信息", null);
         }
         return new ResultMsg(0, "修改成功", null);
     }

   //删除信息
   public ResultMsg delete(GoInfo goInfo, UserSession userSession) {
       if (userSession != null) {
           //判断存储状态
           if (2 == goInfo.getSaveType()) {
               return new ResultMsg(2, "已提交信息不允许删除", null);
           } else {
               goInfo.setIsDelete(2);//设置状态为删除
               goInfoDao.delete(goInfo);
           }
       } else {
           return new ResultMsg(1, "未取得登录信息", null);
       }
       return new ResultMsg(0, "删除成功", null);
   }

    //信息展示
    public int listCount(GoInfo goInfo,UserSession userSession) {
        return goInfoDao.listCount(goInfo,userSession);
    }

    public List<GoInfo> listGoinfo(GoInfo goInfo,UserSession userSession) {
        List<GoInfo> goInfoList = goInfoDao.listGoinfo(goInfo,userSession);
        return goInfoList;
    }

    //提交信息
    public ResultMsg submit(GoInfo goInfo, UserSession userSession) {
        if (userSession != null) {
            //判断是否删除
            if (2 == goInfo.getSaveType()) {
                return new ResultMsg(2, "已提交信息不允许再次提交", null);
            } else {
                goInfo.setSaveType(2);//设置存储状态为提交
                goInfoDao.submit(goInfo);
            }
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0, "提交成功", null);
    }

//    //得到id
//    public void getId(String[] args) {
//        int id = goInfoDao.createTrainId();
//        String date = goInfoDao.createDate();
//        String flag = "1";//中欧1、中亚2
//        String idString = date + flag + id;
//        System.out.println(idString);
//    }
}

