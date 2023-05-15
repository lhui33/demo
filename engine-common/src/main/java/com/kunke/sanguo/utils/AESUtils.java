package com.kunke.sanguo.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * <b>类名：</b><br>
 * <br>
 *
 * @author Charles
 * @version 2019/8/30
 */
public class AESUtils {
    private AESUtils() {}
    private static final String EncryptAlg ="AES";

    private static final String Cipher_Mode="AES/CBC/PKCS5Padding";

    private static final String Encode="UTF-8";

    private static final int Secret_Key_Size=16;

    private static final String Key_Encode="UTF-8";

    /**
     * AES/ECB/PKCS7Padding 加密
     * @param content
     * @param key 密钥
     * @return aes加密后 转base64
     * @throws Exception
     */
    public static String aesPKCS7PaddingEncrypt(String content, String key) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(Cipher_Mode);
            // 指定密钥规则
            SecretKeySpec sks = new SecretKeySpec(key.getBytes(), EncryptAlg);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, sks, iv);
            byte[] data=cipher.doFinal(content.getBytes(Encode));
            return new Base64().encodeToString(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("AES加密失败：content=" +content +" key="+key);
        }
    }

    /**
     * AES/ECB/PKCS7Padding 解密
     * @param content
     * @param key 密钥
     * @return 先转base64 再解密
     * @throws Exception
     */
    public static String aesPKCS7PaddingDecrypt(String content, String key) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(Cipher_Mode);
            SecretKeySpec sks = new SecretKeySpec(key.getBytes(), EncryptAlg);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, sks, iv);
            byte[] bytes = cipher.doFinal(Base64.decodeBase64(content));
            return new String(bytes, Encode);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("AES解密失败：Aescontent = " +e.fillInStackTrace(),e);
        }
    }

    /**
     * 对密钥key进行处理：如密钥长度不够位数的则 以指定paddingChar 进行填充；
     * 此处用空格字符填充，也可以 0 填充，具体可根据实际项目需求做变更
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] getSecretKey(String key) throws Exception{
        final byte paddingChar=' ';

        byte[] realKey = new byte[Secret_Key_Size];
        byte[] byteKey = key.getBytes(Key_Encode);
        for (int i =0;i<realKey.length;i++){
            if (i<byteKey.length){
                realKey[i] = byteKey[i];
            }else {
                realKey[i] = paddingChar;
            }
        }

        return realKey;
    }

    public static void main(String[] args) throws Exception {
        // rN7SjUXXQWEWQfRf908L3zDzJR3qexpTV7ScNpFW2QY=
        String key="charles.shang.pd";
        String content="system.RoleManage,1";

        String encryptRes=aesPKCS7PaddingEncrypt(content,key);
        System.out.println(String.format("加密结果：%s ",encryptRes));

        String decryptRes=aesPKCS7PaddingDecrypt("JUBRDN3h+WJIaniacGaAiN8susvyonGGkygyBzMyImk=",key);
        System.out.println(String.format("解密结果：%s ",decryptRes));
    }

}
