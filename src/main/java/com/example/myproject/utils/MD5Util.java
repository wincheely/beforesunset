package com.example.myproject.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5Util {
    public static String EncoderByMd5(String str) {
        String encodeResult = "";
        //确定计算方法
        MessageDigest md5= null;
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            md5 = MessageDigest.getInstance("MD5");
            encodeResult = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //加密后的字符串
        return encodeResult;
    }

    /**判断用户密码是否正确
     *newpasswd 用户输入的密码
     *oldpasswd 正确密码*/
    public static boolean checkpassword(String newpasswd,String oldpasswd) {
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}
