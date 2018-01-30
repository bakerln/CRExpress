package com.save.service;

import com.common.util.json.ResultMsg;
import com.common.util.session.UserSession;
import com.save.dao.GoInfoDao;
import com.save.model.GoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
            int goInfoID = goInfoDao.createGOInfoId();
            goInfo.setId(goInfoID);//添加信息ID
            goInfo.setCreatTime(new Date());//添加创建时间
            goInfo.setUserID(userSession.getUserId());//添加创建用户ID

            goInfoDao.add(goInfo);
            return null;


    }


}

