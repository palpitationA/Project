package com.softeem.config;

import com.softeem.util.DESUtil;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/13 21:04
 */
//public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
public class EncryptPropertyPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

    //需要解密的字段有哪些
    private String[] encryptProp = {"jdbc.username", "jdbc.password"};


    @Override
    protected void loadProperties(Properties props) throws IOException {
        super.loadProperties(props);
        for (String key : props.stringPropertyNames()) {
            if (isEncrypt(key)) {
                //如果是,就解密后再加载
                System.out.println("**************");
                String decryptValue = DESUtil.getDecryptString(props.getProperty(key));
                props.setProperty(key,decryptValue);
            }
        }
    }

    /**
     * 旧版本用这个方法加载配置
     *
     * @param propertyName  key
//     * @param propertyValue value
     */
//    @Override
//    protected String convertProperty(String propertyName, String propertyValue) {
//        //判断字段是否在加密字段中
//        if (isEncrypt(propertyName)) {
//            //如果是,就解密后再加载
//            String decryptValue = DESUtil.getDecryptString(propertyValue);
//            return decryptValue;
//        }
//        return propertyValue;
//    }
    private boolean isEncrypt(String propertyName) {
        for (String encryptProperty : encryptProp) {
            if (encryptProperty.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
