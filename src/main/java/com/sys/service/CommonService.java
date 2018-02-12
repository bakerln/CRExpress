package com.sys.service;

import com.sys.dao.CommonDao;
import com.sys.model.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiNan on 2018-02-11.
 * Description:
 */
@Service
public class CommonService {

    @Autowired
    private CommonDao commonDao;

    public List<Org> OrgList() {
        return commonDao.OrgList();
    }

    public Org getOrg(String orgId) {
        return commonDao.getOrg(orgId);
    }
}
