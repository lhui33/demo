package com.kunke.sanguo.utils;

public class StringUtils {

    /***
     * 判断字符串是否为汉字
     * @param name
     * @return
     */
    public static boolean  checkChinese(String str) {
        int n = 0;
        for(int i = 0; i < str.length(); i++) {
            n = (int)str.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }

}
