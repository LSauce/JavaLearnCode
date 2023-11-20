package cn.kiroe.day17_io.in;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 11:19 1/11/2023
 **/
/*

读取数据对象
1. 创建输入对象
2. read方法
3. close
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        try (FileInputStream fileInputStream = new FileInputStream("a.txt")) {
            // 2.read方法读取数据
            // read() 读取单个字节 并返回值
            // readSingle(fileInputStream);
            //readMulti(fileInputStream);
            // read(byte[] b , int off, int len)
            byte[] bytes = new byte[1024];
            int readCount = fileInputStream.read(bytes, 0, 100);
            System.out.println("new String(bytes) = " + new String(bytes,0,100));
        }

    }

    private static void readMulti(FileInputStream fileInputStream) throws IOException {
        // read(byte[] b) 批量读取，读取数据填充至数组中，返回值 表示读了多少个字节
        byte[] bytes = new byte[1024];
        int readCount = fileInputStream.read(bytes);
        System.out.println("readCount = " + readCount);
        System.out.println("Arrays.toString(bytes) = " + new String(bytes,0,readCount));
    }

    private static void readSingle(FileInputStream fileInputStream) throws IOException {
        int readData = fileInputStream.read();
        System.out.println("read1 = " + (char) readData);
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
        System.out.println("read1 = " + (char) fileInputStream.read());
    }
}
