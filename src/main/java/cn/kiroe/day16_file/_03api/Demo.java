package cn.kiroe.day16_file._03api;

import java.io.File;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 16:41 31/10/2023
 **/
public class Demo {

    public static void main(String[] args) throws IOException {
        // 只负责创建文件，目录路径如果不存在，会报错而不是帮你创建
        // public boolean createNewFile()
        File file = new File("a.txt");
        file.delete();
        System.out.println(file.createNewFile());

        File file1 = new File("aa");
        file1.delete();
        System.out.println(file1.createNewFile());

        // 只负责创建目录，但只能创建单层目录，如果有多级目录不存在的话，创建失败
        // public boolean mkdir()
        File file2 = new File("name/adffd/fdfd");
        System.out.println("file2.mkdir() = " + file2.mkdir());
//
// //只负责创建目录，但可以创建多级目录，如果多级目录不存在，则帮你全部创建
//         public boolean mkdirs()
        File file3 = new File("name/a/b/c/d");
        System.out.println("file3.mkdir() = " + file3.mkdirs());




    }
}
