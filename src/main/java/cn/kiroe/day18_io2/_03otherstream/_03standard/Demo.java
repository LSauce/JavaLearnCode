package cn.kiroe.day18_io2._03otherstream._03standard;

import java.io.*;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 16:44 2/11/2023
 **/
/*

标准输出流
    System.out
        本质： PrintStream 字节打印流
        默认的输出设备，终端
    System.in
        本质：
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        // out.print("tests");
        InputStream in = System.in;

        //int readData = in.read(); // 是一个阻塞方法
        InputStreamReader inputStreamReader=  new InputStreamReader(in);
        // System.in 是个字节输入流
        //System.out.println((char) readData);

        System.out.println("FileDescriptor.in = " + FileDescriptor.out);
        PrintStream printStream = new PrintStream(new FileOutputStream(FileDescriptor.err));
        printStream.print("你好啊");




    }
}
