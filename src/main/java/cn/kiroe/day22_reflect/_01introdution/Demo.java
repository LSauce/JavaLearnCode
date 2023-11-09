package cn.kiroe.day22_reflect._01introdution;


import java.io.File;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 15:22 7/11/2023
 **/
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // 类加载器
        // 系统类加载器 ， 负责加载 自己自定义的类
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        // ext加载器， 加载 lib/ext 下jar包
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("parent = " + parent); // parent = sun.misc.Launcher$ExtClassLoader@1b6d3586
        // bootstrap加载器 无法获取根类加载器，不是java写的
        // 根加载器 加载 lib/rt 下class
        ClassLoader parent1 = parent.getParent();
        // null
        System.out.println("parent1 = " + parent1);

        // 系统类加载器 加载路径
        String s = System.getProperty("java.class.path");

        System.out.println(s.replace(":",System.lineSeparator()));

        // commons-io-2.12.0.jar 包， 需要类加载器，加载后才能使用
        // FileUtils.copyFile(new File("IOTest/client.txt"),new File("IOTest/c2.txt"));

        // 扩展类加载器，加载路径
        System.out.println("扩展类加载器");
        String extClassLoaderContent = System.getProperty("java.ext.dirs");
        System.out.println(extClassLoaderContent.replace(":",System.lineSeparator()));


    }
}
