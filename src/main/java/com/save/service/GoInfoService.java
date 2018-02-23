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
import com.save.dto.GoInfoVO;
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

    //得到id
    public String getId(GoInfoVO goInfoVO) {
        int id = goInfoDao.createTrainId();
        String date = goInfoDao.createDate();
        int flag = goInfoVO.getTrainType();
        String idString = date + flag + id;
        System.out.println(idString);
        return idString;
    }
    //新增信息
    public ResultMsg add(GoInfoVO goInfoVO, UserSession userSession) {
        if (userSession != null) {
               //判断用户角色
            if (1 == userSession.getRoleId()) {
                return new ResultMsg(2, "该用户不允许添加信息", null);
            }
            else{
                goInfoVO.setId(getId(goInfoVO));//添加信息ID
                goInfoVO.setCreateTime(new Date());//添加创建时间
                goInfoVO.setUserID(userSession.getUserId());//添加创建用户ID
                goInfoVO.setStatus(1);//设置状态为“暂存”
                goInfoVO.setOrgID(userSession.getOrgId());//添加创建人所属单位
                goInfoDao.add(goInfoVO);
            }
            //判断数据合法性 数据合法性规则未知
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0,"添加成功",null);
    }

     //修改信息
     public ResultMsg update(GoInfoVO goInfoVO, UserSession userSession) {
         if (userSession != null) {
             //判断存储状态
             if(2 == goInfoVO.getStatus()){
                 return new ResultMsg(2,"已提交信息不允许修改",null);
             } else {
                 goInfoVO.setUpdateTime(new Date());//添加更新时间
                 goInfoDao.update(goInfoVO);
             }
         } else {
             return new ResultMsg(1, "未取得登录信息", null);
         }
         return new ResultMsg(0, "修改成功", null);
     }


   //删除信息
   public ResultMsg delete(GoInfoVO goInfoVO, UserSession userSession) {
       if (userSession != null) {
           //判断存储状态
           if (2 == goInfoVO.getStatus()) {
               return new ResultMsg(2, "已提交信息不允许删除", null);
           } else {
               goInfoVO.setStatus(3);//设置状态为删除
               goInfoDao.delete(goInfoVO);
           }
       } else {
           return new ResultMsg(1, "未取得登录信息", null);
       }
       return new ResultMsg(0, "删除成功", null);
   }

    //信息展示
    public int listCount(GoInfoVO goInfoVO,UserSession userSession) {
        return goInfoDao.listCount(goInfoVO,userSession);
    }
    public List<GoInfoVO> listGoinfo(GoInfoVO goInfoVO,UserSession userSession) {
        List<GoInfoVO> goInfoList = goInfoDao.listGoinfo(goInfoVO,userSession);
        return goInfoList;
    }

    //提交信息
    public ResultMsg submit(GoInfoVO goInfoVO, UserSession userSession) {
        if (userSession != null) {
            //判断是否删除
            if (2 == goInfoVO.getStatus()) {
                return new ResultMsg(2, "已提交信息不允许再次提交", null);
            } else {
                goInfoVO.setStatus(2);//设置存储状态为提交
                goInfoDao.submit(goInfoVO);
            }
        } else {
            return new ResultMsg(1, "未取得登录信息", null);
        }
        return new ResultMsg(0, "提交成功", null);
    }


}

