package com.save.service;

import com.common.util.session.UserSession;
import com.save.dao.GoInfoDao;
import com.save.model.GoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by linan on 2018-01-04.
 * Description:
 */
@Service
public class GoInfoService {

    @Autowired
    private GoInfoDao goInfoDao;

    //新增信息
        public int add(GoInfo goInfo,UserSession userSession) {
        int goInfoID = goInfoDao.createGOInfoId();
        goInfo.setId(goInfoID);//添加信息ID
        goInfo.setCreatTime(new java.util.Date());//添加创建时间
        goInfo.setUserID(userSession.getUserId());//添加创建用户ID
        return goInfoDao.add(goInfo);

    }

    }

