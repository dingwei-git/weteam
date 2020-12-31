package com.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CheckUtils {

    /**
     * 校验必传参数
     * @param map
     * @param str
     * @return Map
     */
    public static Map<String,String> checkEmpty(Map<String,String> map,String... str){
        if(map==null){
            Map<String,String> maps = new HashMap<>();
            maps = new HashMap<>();
            maps.put("checkResult","false");
            maps.put("msg","报文为空");
            return maps;
        }
        for(String checkStr:str){
            if(StringUtils.isEmpty(map.get(checkStr))){
                map.put("checkResult","false");
                map.put("msg",checkStr+"字段为空");
            }
        }
        return map;
    }

    /**
     * 校验必传参数
     * @param jsonObject
     * @param str
     * @return Map
     */
    public static Map<String,String> checkEmpty(JSONObject jsonObject,String... str){
        Map<String,String> map = null;
        if(jsonObject!=null){
            map = JSONObject.parseObject(jsonObject.toString(),Map.class);
        }else {
            map = new HashMap<>();
            map.put("checkResult","false");
            map.put("msg","报文为空");
            return map;
        }
        for(String checkStr:str){
            if(StringUtils.isEmpty(map.get(checkStr))){
                map.put("checkResult","false");
                map.put("msg",checkStr+"字段为空");
            }
        }
        return map;
    }

}
