package com.softeem.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author panpan@softeem.com
 * @description 对称加密工具
 * @since 2021/10/13 20:30
 */
public class DESUtil {

    private static String ALGORITHM = "DES";
    private static String KEY_SEED = "myKey";
    private static String CHARSET = "UTF-8";
    private static Key key;

    static{
        try {
            //生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            //设置SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            //设置秘钥种子
            secureRandom.setSeed(KEY_SEED.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

//加密
    public static String getEncryptString(String str) {
        try {
            //原文按照指定编码格式转换成字节数组
            byte[] bytes = str.getBytes(CHARSET);
            //获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化加密对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new BASE64Encoder().encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException("加密失败",e);
        }
    }


//解密
    public static String getDecryptString(String str) {
        try {
            //获取秘文的字节数组
            byte[] bytes = new BASE64Decoder().decodeBuffer(str);
            //获取解密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化解密对象
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal);
        } catch (Exception e) {
            throw new RuntimeException("解密失败", e);
        }
    }


    public static void main(String[] args) {
        //WnplV/ietfQ=
        System.out.println(getEncryptString("123456"));
        System.out.println(getDecryptString("WnplV/ietfQ="));
    }
}
