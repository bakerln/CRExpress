package com.export.service;

import com.common.util.String.StringUtil;
import com.common.util.excel.ExcelUtil;
import com.export.dao.ExportDao;
import com.export.dto.SearchFormVO;
import com.export.model.FormBack;
import com.export.model.FormGo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by LiNan on 2018-01-30.
 * Description:
 */
@Service
public class ExportService {

    @Autowired
    private ExportDao exportDao;


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
            if (list.size()<=6000) {
                data = new String[list.size() + 1][21];
                data[0][0] = "序号";
                data[0][1] = "发站";
                data[0][2] = "发车车次";
                data[0][3] = "发车日期";
                data[0][4] = "出境口岸站";
                data[0][5] = "境外到站";
                data[0][6] = "境外到站所属国家";
                data[0][7] = "境外到站所属城市";
                data[0][8] = "列数";
                data[0][9] = "车数";
                data[0][10] = "重箱";
                data[0][11] = "空箱";
                data[0][12] = "重箱";
                data[0][13] = "空箱";
                data[0][14] = "重箱";
                data[0][15] = "空箱";
                data[0][16] = "折合TEU";
                data[0][17] = "TEU";
                data[0][18] = "吨";
                data[0][19] = "整车";
                data[0][20] = "备注";
                for (int i = 0; i < list.size(); i++) {
                    FormGo formGoData = list.get(i);
                    data[i + 1][0] = String.valueOf(i + 1);
                    data[i + 1][1] = StringUtil.getSafeStr(formGoData.getFromStation());
                    data[i + 1][2] = StringUtil.getSafeStr(formGoData.getTrainNumber());
                    data[i + 1][3] = StringUtil.getSafeStr(formGoData.getDepartDate());
                    data[i + 1][4] = StringUtil.getSafeStr(formGoData.getExitportStation());
                    data[i + 1][5] = StringUtil.getSafeStr(formGoData.getOverseasStation());
                    data[i + 1][6] = StringUtil.getSafeStr(formGoData.getOverseasCountry());
                    data[i + 1][7] = StringUtil.getSafeStr(formGoData.getOverseasCity());
                    data[i + 1][8] = StringUtil.getSafeStr(formGoData.getTrainQty());
                    data[i + 1][9] = StringUtil.getSafeStr(formGoData.getCarriageQty());
                    data[i + 1][10] = StringUtil.getSafeStr(formGoData.getHeavyQtyTwenty());
                    data[i + 1][11] = StringUtil.getSafeStr(formGoData.getEmptyQtyTwenty());
                    data[i + 1][12] = StringUtil.getSafeStr(formGoData.getHeavyQtyForty());
                    data[i + 1][13] = StringUtil.getSafeStr(formGoData.getEmptyQtyForty());
                    data[i + 1][14] = StringUtil.getSafeStr(formGoData.getHeavyQtyFortyfive());
                    data[i + 1][15] = StringUtil.getSafeStr(formGoData.getEmptyQtyFortyfive());
                    data[i + 1][16] = StringUtil.getSafeStr(formGoData.getTEU());
                    data[i + 1][17] = StringUtil.getSafeStr(formGoData.getColdTEU());
                    data[i + 1][18] = StringUtil.getSafeStr(formGoData.getColdWeight());
                    data[i + 1][19] = StringUtil.getSafeStr(formGoData.getTotalLoad());
                    data[i + 1][20] = StringUtil.getSafeStr(formGoData.getRemark());
                }
            }
            if (list.size()>6000) {
                data = new String[2][21];
                data[0][0] = "序号";
                data[0][1] = "发站";
                data[0][2] = "发车车次";
                data[0][3] = "发车日期";
                data[0][4] = "出境口岸站";
                data[0][5] = "境外到站";
                data[0][6] = "境外到站所属国家";
                data[0][7] = "境外到站所属城市";
                data[0][8] = "列数";
                data[0][9] = "车数";
                data[0][10] = "重箱";
                data[0][11] = "空箱";
                data[0][12] = "重箱";
                data[0][13] = "空箱";
                data[0][14] = "重箱";
                data[0][15] = "空箱";
                data[0][16] = "折合TEU";
                data[0][17] = "TEU";
                data[0][18] = "吨";
                data[0][19] = "整车";
                data[0][20] = "备注";
                data[1][1] = "数据总数大于6000行无法导出，请缩小查询范围！";
            }
            String report_name = "";
            String titleName = "";
            if (1 == searchFormVO.getTrainType()){
                //TODO 路局信息
               report_name += "中欧班列去程运量统计表" + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
               titleName += "中欧班列去程运量统计表";
            } else {
                report_name += "中亚班列去程运量统计表" + searchFormVO.getDepartDateBegin() + '-' + searchFormVO.getDepartDateEnd();
                titleName += "中亚班列去程运量统计表";
            }
            HSSFWorkbook wb;
            wb = ExcelUtil.createExcelGO(data,titleName,searchFormVO.getDepartDateBegin(),searchFormVO.getDepartDateEnd());
            OutputStream os = null;
            try {
                response.setContentType("application/msexcel");
                response.reset();
                response.setHeader("Access-Control-Allow-Origin", "http://10.1.167.188:8090");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("content-disposition", "attachment; filename=" + new String(report_name.getBytes("gb2312"), "ISO-8859-1") + ".xls");
                System.setProperty("org.apache.poi.util.POILogger", "org.apache.poi.util.POILogger");
                os = response.getOutputStream();
                wb.write(os);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    os.close();
                    response.flushBuffer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else if ("formBack".equals(searchFormVO.getFormType())){
            List<FormBack> list = exportDao.outBack(searchFormVO);
        }


    }
}
