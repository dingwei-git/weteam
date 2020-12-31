package com.common.utils;

import java.util.regex.Pattern;

/**
 * 正则校验
 */
public class RegularUtils {

    private static String positiveInteger = "^[1-9]\\d*$";

    /**
     * 校验是否为正整数(不包括0)
     * @param str
     * @return
     */
    public static boolean checkPositiveInteger(String str){
        Pattern pattern = Pattern.compile(positiveInteger);
        boolean flag = pattern.matcher(str).matches();
        return flag;
    }

}
