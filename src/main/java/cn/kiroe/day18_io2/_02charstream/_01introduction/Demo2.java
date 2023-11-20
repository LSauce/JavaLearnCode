package cn.kiroe.day18_io2._02charstream._01introduction;

/**
 * @author kiro
 * @description:
 * @data 11:31 2/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        String s = "你";// 20320
        // 你 20320
        // 01001111 01100000
        // 1110xxxx 10xxxxxx 10xxxxxx ,  储存 4,6,6,为了 获取位数
        // 11100100
        byte[] bytes = s.getBytes();

        // -28 -67 -96
        // 28 的二进制 00011100
        // -28 的补码  11100100

    }
}
