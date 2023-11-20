package cn.kiroe.day18_io2._03otherstream._02print;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author kiro
 * @description:
 * @data 16:19 2/11/2023
 **/
/*

核心思想: 把不同的数据类型--->String

案例:

定义一个类Printer

定义成员变量OutputStream

定义5个方法

写int的方法  void printInt(int a)

写int并且换行的方法 void printIntLn(int a)

写double的方法  void printDouble(double a)

写double并且换行的方法 void printDoubleLn(double a)

写一个close方法  void  close()
 */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
定义一个类Printer
定义成员变量OutputStream
定义5个方法
写int的方法  void printInt(int a)
写int并且换行的方法 void printIntLn(int a)
写double的方法  void printDouble(double a)
写double并且换行的方法 void printDoubleLn(double a)
写一个close方法  void  close()
 */

class Printer{
    private OutputStream out;
    void printInt(int a) throws IOException {
        out.write(String.valueOf(a).getBytes());
    }
    void printIntLn(int a) throws IOException {
        out.write(String.valueOf(a).getBytes());
        out.write(System.lineSeparator().getBytes());


    }

    void printDouble(double a) throws IOException {
        out.write(String.valueOf(a).getBytes());

    }

    void printDoubleLn(double a) throws IOException {
        out.write(System.lineSeparator().getBytes());

    }

    void  close() throws IOException {
        out.close();
    }
}
