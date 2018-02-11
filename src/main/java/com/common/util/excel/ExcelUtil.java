package com.common.util.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.awt.*;

/**
 * Created by LiNan on 2018-02-09.
 * Description:
 */
public class ExcelUtil {

    /**
     * 添加标题及日期
     * @param excel
     * @param titleName
     * @param StartDate
     * @param EndDate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static HSSFWorkbook createExcelWithTitle(String[][] excel, String titleName, String StartDate, String EndDate ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // sheet创建一个工作页
        HSSFSheet sheet = wb.createSheet(titleName);
        sheet.setDefaultColumnWidth((short) 12);
        HSSFCellStyle style = wb.createCellStyle();//设置边框及对齐方式
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //title （完善可加入时间，考虑到会有单笔单笔订单，目前未加入）
        HSSFRow rowtitle = sheet.createRow(0);
        HSSFCell celltitle = rowtitle.createCell(0);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short)15);
        titleFont.setBoldweight((short) Font.BOLD);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        celltitle.setCellValue(titleName);
        celltitle.setCellStyle(titleStyle);


        int length = excel[0].length;
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,length-1));
        for (short i = 0; i < excel.length; i++) {
            // HSSFRow,对应一行
            HSSFRow row = sheet.createRow(i+1);
            for (short j = 0; j < excel[i].length; j++) {
                // HSSFCell对应一格
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(excel[i][j]);
                cell.setCellStyle(style);
            }
        }
        //完善可加入总额，考虑到不一定有意义，未加入
        return wb;
    }

    /**
     * GO_EXCEL
     * @param excel
     * @param titleName
     * @param StartDate
     * @param EndDate
     * @return
     */
    public static HSSFWorkbook createExcelGO(String[][] excel, String titleName, String StartDate, String EndDate ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // sheet创建一个工作页
        HSSFSheet sheet = wb.createSheet(titleName);
        sheet.setDefaultColumnWidth((short) 10);

        //content Style
        HSSFCellStyle contentStyle = wb.createCellStyle();
        contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        contentStyle.setWrapText(true);//自动换行
        HSSFFont contentFont = wb.createFont();//字体
        contentFont.setFontName("宋体");
        contentFont.setFontHeightInPoints((short)10);
        contentFont.setBoldweight((short) Font.BOLD);
        contentStyle.setFont(contentFont);

        //title Style
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();//字体
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short)20);
        titleFont.setBoldweight((short) Font.BOLD);
        titleStyle.setFont(titleFont);

        //title
        HSSFRow titleRow = sheet.createRow(0);
        HSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellStyle(titleStyle);
        titleCell.setCellValue(titleName);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,20));//起始行,结束行,起始列,结束列


        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(1,3,0,0));
        sheet.addMergedRegion(new CellRangeAddress(1,3,1,1));
        sheet.addMergedRegion(new CellRangeAddress(1,3,2,2));
        sheet.addMergedRegion(new CellRangeAddress(1,3,3,3));
        sheet.addMergedRegion(new CellRangeAddress(1,3,4,4));
        sheet.addMergedRegion(new CellRangeAddress(1,3,5,5));
        sheet.addMergedRegion(new CellRangeAddress(1,3,6,6));
        sheet.addMergedRegion(new CellRangeAddress(1,3,7,7));
        sheet.addMergedRegion(new CellRangeAddress(1,3,8,8));
        sheet.addMergedRegion(new CellRangeAddress(1,3,9,9));
        sheet.addMergedRegion(new CellRangeAddress(1,1,10,16));
        sheet.addMergedRegion(new CellRangeAddress(1,1,17,18));
        sheet.addMergedRegion(new CellRangeAddress(1,3,19,19));
        sheet.addMergedRegion(new CellRangeAddress(1,3,20,20));
        sheet.addMergedRegion(new CellRangeAddress(2,2,10,11));
        sheet.addMergedRegion(new CellRangeAddress(2,2,12,13));
        sheet.addMergedRegion(new CellRangeAddress(2,2,14,15));
        sheet.addMergedRegion(new CellRangeAddress(2,3,16,16));
        sheet.addMergedRegion(new CellRangeAddress(2,3,17,17));
        sheet.addMergedRegion(new CellRangeAddress(2,3,18,18));

        //赋值（一行一行）first line
        HSSFRow firstRow = sheet.createRow(1);
        String[] firstTitles = {"序号","发站","发车车次","发车日期","出境口岸站","境外到站","境外到站所属国家","境外到站所属城市","列数","车数","箱数"};
        for (int i = 0;i <=20; i++){
            HSSFCell firstRowCell = firstRow.createCell(i);
            if (i<firstTitles.length){
                firstRowCell.setCellStyle(contentStyle);
                firstRowCell.setCellValue(firstTitles[i]);
            }else{
                firstRowCell.setCellStyle(contentStyle);
            }
        }
        HSSFCell firstRowCell18 = firstRow.createCell(17);
        firstRowCell18.setCellStyle(contentStyle);
        firstRowCell18.setCellValue("其中冷藏箱");
        HSSFCell firstRowCell19 = firstRow.createCell(19);
        firstRowCell19.setCellStyle(contentStyle);
        firstRowCell19.setCellValue("整车");
        HSSFCell firstRowCell20 = firstRow.createCell(20);
        firstRowCell20.setCellStyle(contentStyle);
        firstRowCell20.setCellValue("备注");

        //赋值（一行一行）second line
        HSSFRow secondRow = sheet.createRow(2);
        for (int i = 0;i <=20; i++){
            HSSFCell secondRowCell = secondRow.createCell(i);
            secondRowCell.setCellStyle(contentStyle);
        }
        HSSFCell secondRowCell10 = secondRow.createCell(10);
        secondRowCell10.setCellStyle(contentStyle);
        secondRowCell10.setCellValue("20英尺");
        HSSFCell secondRowCell12 = secondRow.createCell(12);
        secondRowCell12.setCellStyle(contentStyle);
        secondRowCell12.setCellValue("40英尺");
        HSSFCell secondRowCell14 = secondRow.createCell(14);
        secondRowCell14.setCellStyle(contentStyle);
        secondRowCell14.setCellValue("45英尺");
        HSSFCell secondRowCell16 = secondRow.createCell(16);
        secondRowCell16.setCellStyle(contentStyle);
        secondRowCell16.setCellValue("折合TEU");
        HSSFCell secondRowCell17 = secondRow.createCell(17);
        secondRowCell17.setCellStyle(contentStyle);
        secondRowCell17.setCellValue("TEU");
        HSSFCell secondRowCell18 = secondRow.createCell(18);
        secondRowCell18.setCellStyle(contentStyle);
        secondRowCell18.setCellValue("吨");

        //赋值（一行一行）third line
        HSSFRow thirdRow = sheet.createRow(3);
        for (int i = 0;i <=20; i++){
            HSSFCell thirdRowCell = thirdRow.createCell(i);
            thirdRowCell.setCellStyle(contentStyle);
        }
        HSSFCell thirdRowCell10 = thirdRow.createCell(10);
        thirdRowCell10.setCellStyle(contentStyle);
        thirdRowCell10.setCellValue("重箱");
        HSSFCell thirdRowCell11 = thirdRow.createCell(11);
        thirdRowCell11.setCellStyle(contentStyle);
        thirdRowCell11.setCellValue("空箱");
        HSSFCell thirdRowCell12 = thirdRow.createCell(12);
        thirdRowCell12.setCellStyle(contentStyle);
        thirdRowCell12.setCellValue("重箱");
        HSSFCell thirdRowCell13 = thirdRow.createCell(13);
        thirdRowCell13.setCellStyle(contentStyle);
        thirdRowCell13.setCellValue("空箱");
        HSSFCell thirdRowCell14 = thirdRow.createCell(14);
        thirdRowCell14.setCellStyle(contentStyle);
        thirdRowCell14.setCellValue("重箱");
        HSSFCell thirdRowCell15 = thirdRow.createCell(15);
        thirdRowCell15.setCellStyle(contentStyle);
        thirdRowCell15.setCellValue("空箱");

        for (int i = 0; i < excel.length; i++) {
            // HSSFRow,对应一行
            HSSFRow row = sheet.createRow(i+4);
            for (int j = 0; j < excel[i].length; j++) {
                // HSSFCell对应一格
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(excel[i][j]);
                cell.setCellStyle(contentStyle);
            }
        }
        //完善可加入总额，考虑到不一定有意义，未加入
        return wb;
    }
}
