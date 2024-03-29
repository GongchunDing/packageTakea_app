package com.xiaoding.finalproject;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
    public static String getMD5(String c_password) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 调用update方法计算MD5函数(参数：将密码串转换为操作系统的字节编码)
            md.update(c_password.getBytes());
            // digest()最后返回md5的hash值，返回值为8位的字符串，但此方法要先调用update
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值,数值从1开始
            // BigInteger会把0省略掉，需补全至32位，重写一个方法将16位数转换为32位数
            String md5 = new BigInteger(1, md.digest()).toString(16);
            return md5;
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误：" + e.getMessage(), e);
        }
    }
}
