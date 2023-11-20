package cn.kiroe.day17_io.homework.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 13:54 1/11/2023
 **/
/*

键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
再键盘录入一行字符串
使用字节输出流将这行字符串信息,写入到相应路径名的文件中
(一次键盘录入,写入一次即可)
要求必须用传统try...catch..finally处理异常释放资源,不能直接throws
 */
public class Test {
    public static void main(String[] args) {
        // 键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个路径:");
        String path = sc.nextLine();
        System.out.println("请输入文件内容");
        String content = sc.nextLine();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("写入完成");
    }
}
