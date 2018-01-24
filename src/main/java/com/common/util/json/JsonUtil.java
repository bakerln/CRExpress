package com.common.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2017-12-26.
 * Description: JSON工具类
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转JSON字符串
     * @param object
     * @return
     */
    public static String toStr(Object object){
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writer().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * JSON字符串转对象
     * @param clazz
     * @param str
     * @return
     */
    public static Object toObject(String str,Class clazz){
        try {
            return objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成操作后的json串，{success:false,msg:'删除失败'}
     * @param flag
     * @param msg
     * @return
     */
    public static String createOperaStr(boolean flag,String msg){
        return "{\"success\":" + flag + ",\"msg\":\"" + msg + "\"}";
    }


    /**
     * 分页查JSON串
     * @param rows 全部条数
     * @param obj 对象
     * @return
     */
    public static String createPageJson(long rows,Object obj){
        String json = "{\"total\":\""+ rows + "\",\"root\":" + toStr(obj) + "}";
        return json;
    }


}
