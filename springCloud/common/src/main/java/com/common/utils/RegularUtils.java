package com.common.utils;

import java.util.regex.Pattern;

/**
 * 正则校验
 */
public class RegularUtils {

    /**
     * 校验是否为整数
     * @param str
     * @param type includingZero正整数包括0,noIncludingZero正整数不包括0,integer整数
     * @return boolean;
     */
    public static boolean checkPositiveInteger(String str,String type){
        boolean flag = false;
        if("includingZero".equals(type)){
            Pattern pattern = Pattern.compile(Regular.positiveIntegers);
            flag = pattern.matcher(str).matches();
            return flag;
        }else if("noIncludingZero".equals(type)){
            Pattern pattern = Pattern.compile(Regular.positiveInteger);
            flag = pattern.matcher(str).matches();
            return flag;
        }else if("integer".equals(type)){
            Pattern pattern = Pattern.compile(Regular.theInteger);
            flag = pattern.matcher(str).matches();
            return flag;
        }else{
            return false;
        }

    }

}
