package cn.kiroe.test._01reflex._01introdoce;

/**
 * @author kiro
 * @description:
 * @data 15:42 19/10/2023
 **/

/*

// 获取运行时类信息的一种手段
// 反射的起点是字节码文件对象
 */
public class Demo {
    /*
    ## 获取字节码文件对象的几种方式

    - 对象.getClass()
    - 类名.class
    - Class.forName(String className)  全限定名
    - ClassLoader里的loadClass(String className)
     */

    public static void main(String[] args) {
        Student s1 = new Student("张三",10);
        //获取字节码文件对象：
        Class c = s1.getClass();
        
    }
}

class Student{
    private String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
