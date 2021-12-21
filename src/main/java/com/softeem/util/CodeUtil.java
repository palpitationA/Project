package com.softeem.util;

import javax.servlet.http.HttpServletRequest;
import com.google.code.kaptcha.Constants;

import java.util.Locale;

/**
 * @author panpan@softeem.com
 * @description 验证码的工具类
 * @since 2021/10/15 20:37
 */
public class CodeUtil {

    public static boolean checkVerifyCode(String verifyCodeActual, HttpServletRequest request){
        String verifyCodeExpected = ((String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY)).toUpperCase();
        if (verifyCodeActual == null) {
            return false;
        }
//为了防止用户输入正确的验证码,但却因为大小写的原因失败,所以统一转换成大写字母
        verifyCodeActual = verifyCodeActual.toUpperCase();
        return verifyCodeExpected.equals(verifyCodeActual);
    }
}
