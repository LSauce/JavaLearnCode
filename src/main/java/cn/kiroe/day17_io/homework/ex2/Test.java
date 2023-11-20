package cn.kiroe.day17_io.homework.ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 14:00 1/11/2023
 **/
/*
键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
再键盘录入一行字符串
使用字节输出流将这行字符串信息,写入到相应路径名的文件中
要求:

可以允许进行多次键盘录入,允许持续的将字符串信息追加到目标文件中
可以约定一个"end"字符串的键盘录入,作为结束向文件写入信息的标志


要求必须做异常处理,使用try-with-resource结构
 */
public class Test {

    public static void main(String[] args) {
        // 键盘录入一个文件路径名(可以是相对路径,也可以是绝对路径)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个路径:");
        String path = sc.nextLine();
        System.out.println("请输入文件内容可多行，输入 end 结束");


        try (FileOutputStream out = new FileOutputStream(path,true)) {
            while (true) {
                String content = sc.nextLine();
                if (content.equals("end")) {
                    break;
                }
                out.write(content.getBytes());
                out.write(System.lineSeparator().getBytes());

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("输入完成");

    }
}
