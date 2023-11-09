package cn.kiroe.day17_io._01bytestream.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author kiro
 * @description:
 * @data 10:19 1/11/2023
 **/


public class Demo2 {

    public static void main(String[] args) throws FileNotFoundException {
        // 当创建输出流对象的 时候， 会检测一下文件是否存在
        // 如果不存在 --> 创建出来这个文件
        // 如果文件存在 --> 覆盖掉之前的内容，从头开始写
        FileOutputStream outputStream = new FileOutputStream("a.txt");

    }
}
