package cn.kiroe.day16_file._04ex;

import java.io.File;
import java.util.Arrays;
import java.util.Dictionary;

/**
 * @author kiro
 * @description:
 * @data 17:42 31/10/2023
 **/

/*

## 文件过滤器

- 自定义获取功能是在高级获取功能的基础上，加了一个过滤器，所以高级功能的特点它都有

- FileFilter是一个接口，它只有下面一个方法

  - ```Java
    //测试指定抽象路径名是否应该包含在某个路径名列表中
    boolean accept(File pathname)
    ```

  - 这个方法相当于把高级功能中listFiles()获取的File数组中File对象遍历一遍，然后逐个判断

  - 符合条件的留下，不符合条件的干掉（丢弃）-

- 常用匿名内部类来做实现

练习:
输出某个目录(单级)下的所有java文件,使用过滤器.

3种方式实现
匿名对象
匿名内部类
lambda表达式
 */
public class EX3 {

    public static void main(String[] args) {

        // 确定 目的目录
        File dir = new File("src/main/java/cn/kiroe/day16_file/_04ex");

        // 使用 listFiles(FileFilter filefilter)
        // 使用接口实现类
        File[] files = dir.listFiles(file -> file.getName().endsWith(".java"));
        System.out.println("Arrays.toString(files) = " + Arrays.toString(files));

    }


}
