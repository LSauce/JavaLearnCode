package cn.kiroe.day22_reflect._05add;

import cn.kiroe.day22_reflect._04api.bean.Person;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 17:54 7/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("java.io.OutputStream");
        // 全类名，简单那名
        System.out.println("c.getName() = " + c.getName());
        System.out.println("c.getSimpleName() = " + c.getSimpleName());
        // 获取父类，获取
        System.out.println("c.getSuperclass() = " + c.getSuperclass());
        // 获取接口
        System.out.println("c.getInterfaces() = " + Arrays.toString(c.getInterfaces()));

        System.out.println("c.getClassLoader() = " + c.getClassLoader()); // 为根加载器
        System.out.println("Person.class.getClassLoader() = " + Person.class.getClassLoader());

    }
}
