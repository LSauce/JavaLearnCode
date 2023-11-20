package cn.kiroe.day22_reflect._02cls;

/**
 * @author kiro
 * @description:
 * @data 16:11 7/11/2023
 **/
/*
类加载时机:
    1. 首次 New对象
    2. 执行 main
    3. 访问类中 静态成员
    4. 加载子类先 进行父类的 加载
    5. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
    6. 执行main方法的启动类
 */
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        // Class<?> aClass = Class.forName("day22_reflect._02cls.A");
        Class<A> c2 = A.class; // 是不完全加载

    }
}

class A{
    static {
        System.out.println("A static block");
    }
}
