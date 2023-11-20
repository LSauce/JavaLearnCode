package cn.kiroe.day16_file._03api;

import java.io.File;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 17:19 31/10/2023
 **/
public class Demo6 {

    public static void main(String[] args) {
        // 返回一个字符串数组，这些字符串包括，此抽象的路径名表示的目录中的所有文件和文件夹的名字
        // 如果File对象表示的是一个文件，则返回null
        // 只能获取当前目录的下一层，并不是获取所有层级
        // 如果是一个空目录，返回一个长度为0的数组，而不是null  []
        //     public String[] list()
        File file = new File("src");
        System.out.println("Arrays.toString(file.list()) = " + Arrays.toString(file.list()));

        // 对文件 使用 返回null
        // 返回指定File目录下的文件和文件夹的绝对路径形式的File对象数组
        // 如果File对象表示的是一个文件，则返回null
        // 只能获取当前目录的下一层，并不是获取所有层级
        // 如果是一个空目录，返回一个长度为0的数组，而不是null
        //     public File[] listFiles()
        System.out.println("Arrays.toString(file.listFiles()) = " + Arrays.toString(file.listFiles()));
    }


}
