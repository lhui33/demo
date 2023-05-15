package com.kunke.sanguo.utils;

import org.apache.commons.lang.StringUtils;

/**
 * <b>类名：</b><br>
 * <br>
 *
 * @author Charles
 * @version 2019/8/30
 */
public class TokenUtils {
    private TokenUtils() {}
    // key 必须是8的倍数
    private static final String key = "charles.shang.pd";

    public static String[] getTokenInfo(String accessToken) {
        String[] tokenInfo = null;
        String tokenStr = "";
        try {
            tokenStr = AESUtils.aesPKCS7PaddingDecrypt(accessToken.trim(), key);
            if (StringUtils.isBlank(tokenStr)) {
                return null;
            }
            tokenInfo = tokenStr.split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tokenInfo;
    }
}
