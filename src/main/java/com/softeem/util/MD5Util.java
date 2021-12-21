package com.softeem.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author panpan@softeem.com
 * @description MD5加密工具类
 * @since 2021/10/15 15:09
 */
public class MD5Util {

    /**
     * 16位数组
     */
    private static final char[] SALT = {
            '1', '3', '5', '7', '9', 'a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u'
    };

    public static String getMD5(String origin) {
        try {
            byte[] originBytes = origin.getBytes();
            //获取md5加密对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(originBytes);
            byte[] digest = md5.digest();
            char[] chars = new char[digest.length * 2];
//            int k = 0;
            for (int i = 0, k = 0; i < digest.length; i++) {
                byte byte0 = digest[i];
                chars[k++] = SALT[byte0 >>> 4 & 0xf];
                chars[k++] = SALT[byte0 & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456").length());
        System.out.println(getMD5("123456"));
    }
}
