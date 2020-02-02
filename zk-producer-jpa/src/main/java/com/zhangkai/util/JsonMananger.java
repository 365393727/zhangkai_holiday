package com.zhangkai.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.List;
import java.util.Map;


/**
 * Author: ZhangDaKe
 * Date: 2017/4/21 - 13:40
 * Describe:
 * Version: 1.0
 */
public final class JsonMananger {

    static {
        //如果为false 转成json的时候例如 TITLE 会变成 tITLE
        //true的话不会更改
        TypeUtils.compatibleWithJavaBean = true;
    }

    private static final String tag = JsonMananger.class.getSimpleName();

    private JsonMananger() {
        throw new IllegalStateException("this class can`t be created by constructor");
    }

    //将json转换成对象
    public static <T> T jsonToBean(String json, Class<T> cls) throws Exception {
        T t = null;
        try {
            t = JSON.parseObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    //将json转换成list对象
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        List<T> listT = null;
        try {
            listT = JSON.parseArray(json, cls);
        } catch (JSONException exception) {

        }
        return listT;
    }

    //将对象转换成json
    public static String beanToJson(Object obj) {
        String result = JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
        return result;
    }

    //将map转换成json
    public static String mapToJson(Map obj) {
        String result = JSON.toJSONString(obj);
        return result;
    }

    public static <T> T getReponseResult(String resultStr, Class<T> cls) {
        T t = null;
        try {
            t = JsonMananger.jsonToBean(resultStr, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    //将json转化成map集合
    public static Map<String, Object> JsonStrToMap(String jsonStr) {
        Map<String, Object> map = JSON.parseObject(
                jsonStr, new TypeReference<Map<String, Object>>() {
                });
        return map;
    }

}
