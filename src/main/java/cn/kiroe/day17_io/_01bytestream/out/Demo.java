package cn.kiroe.day17_io._01bytestream.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 10:08 1/11/2023
 **/

/*
写数据的基本步骤
1. 创建输出对象
2. write 方法写数据
3. close 释放资源
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        //writeSingle();

        // 1. 创建输出对象
        File file = new File("a.txt");
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        // 2. write 方法写数据
        String s = "abcdefg";
        byte[] bytes = s.getBytes();
        // write(int b) 写d单个字节
        // outputStream.write(97);
        // write(byte[] b) 写字节数组
        //outputStream.write(bytes);
        // write(byte[] b, int off, int len) 写字节数组部分
        outputStream.write(bytes,2,5);
        // 3. close 释放资源
        outputStream.close();
    }

    private static void writeSingle() throws IOException {
        // 1. 创建输出对象
        File file = new File("a.txt");
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        // 2. write 方法写数据
        byte[] bytes = new byte[]{'a','1','2','3','o'};
        // write(int b) 写d单个字节
        outputStream.write(97);
        // write(byte[] b) 写字节数组
        // outputStream.write(bytes);
        // write(byte[] b, int off, int len) 写字节数组部分
        // outputStream.write(bytes,2,5);
        // 3. close 释放资源
        outputStream.close();
    }
}
