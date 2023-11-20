package cn.kiroe.day16_file._03api;

import java.io.File;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 16:50 31/10/2023
 **/
public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 重新命名此抽象路径名表示的文件
        // public boolean renameTo(File dest)
        File file = new File("aaa");

        System.out.println("file.createNewFile() = " + file.createNewFile());
        System.out.println("file.renameTo(new File(\"bbb\")) = " + file.renameTo(new File("bbb")));

    }
}
