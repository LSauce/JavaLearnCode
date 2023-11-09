package cn.kiroe.day18_io2._02charstream._02encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 11:48 2/11/2023
 **/
/*
java 中的编解码
 */
public class Demo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";
        // 编码
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        // [-28, -67, -96, -27, -91, -67]
        // 解码,利用构造器
        System.out.println(new String(bytes));

        // byte[] getBytes(String charsetName)
        // 使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        byte[] bytes2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
        // [-60, -29, -70, -61]


        // 解码过程
        // 计算机看懂的----> 人看懂的
        // String(byte[] bytes)
        // 通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
        //String s1 = new String(bytes);
        //System.out.println(s1);

        // String(byte[] bytes, String charsetName)
        // 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
        String s2 = new String(bytes2, "utf-8");
        System.out.println(s2);


    }
}
