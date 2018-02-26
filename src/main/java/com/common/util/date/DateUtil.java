package com.common.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LiNan on 2018-02-26.
 * Description:
 */
public class DateUtil {
    private static final String defaultDateFormat = "yyyy-MM-dd";//默认日期格式

    /**
     * 日期转字符串
     *
     * @param date 日期
     * @param formatStr 日期格式字符串
     * @return 字符串
     */
    public static String dateToString(Date date, String formatStr) {
        String strTime = "";
        try {
            DateFormat df = new SimpleDateFormat(formatStr);
            strTime = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strTime;
    }

    /**
     * 判断日期是null或空
     *
     * @param date
     * @return
     */
    public static boolean isDateNotNullOrEmpty(Date date) {
        String str = DateUtil.dateToString(date, defaultDateFormat+" HH:mm:ss");
        if (str != null && !str.equals(""))
            return true;
        else
            return false;
    }

    /**
     * 字符串转换到时间格式
     *
     * @param dateStr
     *            需要转换的字符串
     * @param formatStr
     *            需要格式的目标字符串 举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException
     *             转换异常
     */
    public static Date stringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 取得系统日期
     *
     * @return
     */
    public static String getSystemDate() {
        String strDate = "";
        DateFormat df = new SimpleDateFormat(defaultDateFormat);
        strDate = df.format(new Date());
        return strDate;
    }

    /**
     * 时间转换
     * @param date
     * @return
     */
    public static String dateFormat(String date) {
        if (date.length() == 8) {//时间转换yyyymmdd --> yyyy-mm-dd
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        } else if (date.length() == 19) {//时间转换yyyy-mm-dd hh24:mi:ss --> yyyy-mm-dd
            return date.substring(0, 4) + "-" + date.substring(5, 7) + "-" + date.substring(8, 10);
        } else {
            return date;
        }
    }

}
