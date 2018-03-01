package com.export.service;

import com.common.util.String.StringUtil;
import com.common.util.date.DateUtil;
import com.common.util.excel.ExcelUtil;
import com.common.util.web.WebUtil;
import com.export.dao.ExportDao;
import com.export.dto.SearchFormVO;
import com.export.model.FormBack;
import com.export.model.FormGo;
import com.sys.dao.CommonDao;
import com.sys.model.Org;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-01-30.
 * Description:
 */
@Service
public class ExportService {

    @Autowired
    private ExportDao exportDao;

    @Autowired
    private CommonDao commonDao;


    //查询总数
    public int listCount(SearchFormVO searchFormVO) {
        if ("formGo".equals(searchFormVO.getFormType())){
            return exportDao.listCountGo(searchFormVO);
        } else if ("formBack".equals(searchFormVO.getFormType())){
            return exportDao.listCountBack(searchFormVO);
        } else{
            return 1;
        }
    }

    //获得列表
    public List listForm(SearchFormVO searchFormVO) {
        if ("formGo".equals(searchFormVO.getFormType())){
            //TODO 时间格式调整
            return exportDao.listFormGo(searchFormVO);
        } else if ("formBack".equals(searchFormVO.getFormType())){
            return exportDao.listFormBack(searchFormVO);
        } else{
            return null;
        }
    }

    //导出数据
    public void out(HttpServletRequest request, HttpServletResponse response, SearchFormVO searchFormVO) {
        if ("formGo".equals(searchFormVO.getFormType())){
            List<FormGo> list = exportDao.listFormGo(searchFormVO);
            String[][] data = null;
            if (list.size()<=5000) {
                data = new String[list.size()][21];
                for (int i = 0; i < list.size(); i++) {
                    FormGo formGoData = list.get(i);
                    data[i][0] = String.valueOf(i + 1);
                    data[i][1] = StringUtil.getSafeStr(formGoData.getFromStation());
                    data[i][2] = StringUtil.getSafeStr(formGoData.getTrainNumber());
                    data[i][3] = DateUtil.dateFormat(StringUtil.getSafeStr(formGoData.getDepartDate()));
                    data[i][4] = StringUtil.getSafeStr(formGoData.getExitportStation());
                    data[i][5] = StringUtil.getSafeStr(formGoData.getOverseasStation());
                    data[i][6] = StringUtil.getSafeStr(formGoData.getOverseasCountry());
                    data[i][7] = StringUtil.getSafeStr(formGoData.getOverseasCity());
                    data[i][8] = StringUtil.getSafeStr(formGoData.getTrainQty());
                    data[i][9] = StringUtil.getSafeStr(formGoData.getCarriageQty());
                    data[i][10] = StringUtil.getSafeStr(formGoData.getHeavyQtyTwenty());
                    data[i][11] = StringUtil.getSafeStr(formGoData.getEmptyQtyTwenty());
                    data[i][12] = StringUtil.getSafeStr(formGoData.getHeavyQtyForty());
                    data[i][13] = StringUtil.getSafeStr(formGoData.getEmptyQtyForty());
                    data[i][14] = StringUtil.getSafeStr(formGoData.getHeavyQtyFortyfive());
                    data[i][15] = StringUtil.getSafeStr(formGoData.getEmptyQtyFortyfive());
                    data[i][16] = StringUtil.getSafeStr(formGoData.getTEU());
                    data[i][17] = StringUtil.getSafeStr(formGoData.getColdTEU());
                    data[i][18] = StringUtil.getSafeStr(formGoData.getColdWeight());
                    if("1".equals(searchFormVO.getTrainType())){
                        data[i][19] = "";
                    }else{
                        data[i][19] = StringUtil.getSafeStr(formGoData.getTotalLoad());
                    }
                    data[i][20] = StringUtil.getSafeStr(formGoData.getRemark());
                }
            }
            if (list.size()>5000) {
                data = new String[1][21];
                data[0][0] = "数据总数大于5000行无法导出，请缩小查询范围！";
            }
            String report_name = "";
            String titleName = "";
            String orgString = "";

            //判断路局
            //空为查询全部
            if (!StringUtil.isNullOrEmpty(searchFormVO.getOrgID())){
                Org org = commonDao.getOrg(searchFormVO.getOrgID());
                orgString = org.getOrgStr();
            }
            if (("1").equals(searchFormVO.getTrainType())){
               report_name += orgString + "中欧班列去程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
               titleName += orgString + "中欧班列去程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
            } else {
                report_name += orgString + "中亚班列去程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
                titleName += orgString + "中亚班列去程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
            }
            HSSFWorkbook wb = ExcelUtil.createExcelGO(data,titleName,searchFormVO.getDepartDateBegin(),searchFormVO.getDepartDateEnd());
            WebUtil.outExcel(response,wb,report_name);
        } else if ("formBack".equals(searchFormVO.getFormType())){
            List<FormBack> list = exportDao.listFormBack(searchFormVO);
            String[][] data = null;
            if (list.size()<=5000) {
                data = new String[list.size()][21];
                for (int i = 0; i < list.size(); i++) {
                    FormBack formBackData = list.get(i);
                    data[i][0] = String.valueOf(i + 1);
                    data[i][1] = StringUtil.getSafeStr(formBackData.getPortStation());
                    data[i][2] = StringUtil.getSafeStr(formBackData.getTrainNumber());
                    data[i][3] = DateUtil.dateFormat(StringUtil.getSafeStr(formBackData.getDepartDate()));
                    data[i][4] = StringUtil.getSafeStr(formBackData.getDomesticStation());
                    data[i][5] = StringUtil.getSafeStr(formBackData.getOverseasStation());
                    data[i][6] = StringUtil.getSafeStr(formBackData.getOverseasCountry());
                    data[i][7] = StringUtil.getSafeStr(formBackData.getOverseasCity());
                    data[i][8] = StringUtil.getSafeStr(formBackData.getTrainQty());
                    data[i][9] = StringUtil.getSafeStr(formBackData.getCarriageQty());
                    data[i][10] = StringUtil.getSafeStr(formBackData.getHeavyQtyTwenty());
                    data[i][11] = StringUtil.getSafeStr(formBackData.getEmptyQtyTwenty());
                    data[i][12] = StringUtil.getSafeStr(formBackData.getHeavyQtyForty());
                    data[i][13] = StringUtil.getSafeStr(formBackData.getEmptyQtyForty());
                    data[i][14] = StringUtil.getSafeStr(formBackData.getHeavyQtyFortyfive());
                    data[i][15] = StringUtil.getSafeStr(formBackData.getEmptyQtyFortyfive());
                    data[i][16] = StringUtil.getSafeStr(formBackData.getTEU());
                    data[i][17] = StringUtil.getSafeStr(formBackData.getColdTEU());
                    data[i][18] = StringUtil.getSafeStr(formBackData.getColdWeight());
                    if("1".equals(searchFormVO.getTrainType())){
                        data[i][19] = "";
                    }else{
                        data[i][19] = StringUtil.getSafeStr(formBackData.getTotalLoad());
                    }
                    data[i][20] = StringUtil.getSafeStr(formBackData.getRemark());
                }
            }
            if (list.size()>5000) {
                data = new String[1][21];
                data[0][0] = "数据总数大于5000行无法导出，请缩小查询范围！";
            }
            String report_name = "";
            String titleName = "";
            String orgString = "";

            //判断路局
            if (!StringUtil.isNullOrEmpty(searchFormVO.getOrgID())){
                Org org = commonDao.getOrg(searchFormVO.getOrgID());
                orgString = org.getOrgStr();
            }
            if (("1").equals(searchFormVO.getTrainType())){
                report_name += orgString + "中欧班列回程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
                titleName += orgString + "中欧班列回程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
            } else {
                report_name += orgString + "中亚班列回程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
                titleName += orgString + "中亚班列回程运量统计表 " + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
            }
            HSSFWorkbook wb = ExcelUtil.createExcelBack(data,titleName,searchFormVO.getDepartDateBegin(),searchFormVO.getDepartDateEnd());
            WebUtil.outExcel(response,wb,report_name);
        }


    }
}
