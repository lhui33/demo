package com.kunke.sanguo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <b>功能：</b>MD5加密類<br>
 * <br>
 * 
 * @author Charles
 * @version 2015年7月26日
 *
 */
public class MD5 {
	
	/**
	 * <b>功能描述：</b>MD5加密<br>
	 * <b>修订记录：</b><br>
	 * <li>2015年7月26日&nbsp;&nbsp;|&nbsp;&nbsp;Charles&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @author Charles
	 *
	 * @param str
	 * @return
	 */
	public static String toMd5(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException(	"String to encript cannot be null or zero length");
		}

		StringBuffer hexString = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

	public static void main(String[] args) {
//		System.out.println(toMd5("123456"));
		System.out.println(System.getProperty("user.dir") + "/" + DateUtil.dateToString("yyyy-MM-dd_HH:mm:ss"));
	}
}
