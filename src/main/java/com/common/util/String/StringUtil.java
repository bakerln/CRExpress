package com.common.util.String;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * Created by LiNan on 2017-12-26.
 * Description:
 */
public class StringUtil {
    private static final char[] codeSequenceRandom = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    /**
     * 判断字符串是null或空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        else
            return false;
    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    public static boolean checkAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else
            return false;
    }

    /**
     * 格式化金钱
     *
     * @param val
     * @return
     */
    public static String formatAmount(double val) {
        NumberFormat nf = new DecimalFormat("#,###.##");
        String str = nf.format(val);
        return str;
    }

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String szClientIP = request.getHeader("x-forwarded-for");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("WL-Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getRemoteAddr();
        return szClientIP;
    }

    /**
     * 生成字符串随机数
     * @param count
     * @return
     */
    public static String createRandomCode(int count) {
        String serialNum = "";
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String strRand = String.valueOf(codeSequenceRandom[random.nextInt(codeSequenceRandom.length)]);
            serialNum += strRand;
        }
        return serialNum;
    }
}