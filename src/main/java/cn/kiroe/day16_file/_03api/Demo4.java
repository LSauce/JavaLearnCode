package cn.kiroe.day16_file._03api;

import java.io.File;

/**
 * @author kiro
 * @description:
 * @data 17:11 31/10/2023
 **/
public class Demo4 {

    public static void main(String[] args) {
        // 判断File对象是否表示的是一个文件
        // public boolean isFile ()
        File file = new File("aa");
        System.out.println(file.isFile());

        // 判断File对象是否表示的是一个目录
        // public boolean isDirectory ()
        System.out.println("file.isDirectory() = " + file.isDirectory());
        // 判断，File对象表示的文件，是否物理存在
        // public boolean exists ()
        System.out.println("file.exists() = " + file.exists());
    }
}
