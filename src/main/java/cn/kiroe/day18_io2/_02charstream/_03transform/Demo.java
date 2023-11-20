package cn.kiroe.day18_io2._02charstream._03transform;

import sun.misc.IOUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 14:41 2/11/2023
 **/
/*
使用转换流 写数据
 */
public class Demo {

    public static void main(String[] args) {
        try {
           byte[] bytes = IOUtils.readAllBytes(new BufferedInputStream(new FileInputStream("IOTest/a.txt")));

            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("IOTest/a.txt",true)))) {

            // 3个和字符相关的
            // write(int i)
            writer.write(97);
            // write(char[] c)
            writer.write("abcdfadsfad你好fadsf".toCharArray());
            // write(char[] c,int off, int len)
            writer.write("发生大法师代发多发点".toCharArray(),2,6);


            // 两个和字符串相关的
            writer.write("你好发的发生多发点");
            writer.write("飞洒地方",1,2);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
