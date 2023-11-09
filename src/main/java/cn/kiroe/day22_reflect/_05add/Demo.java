package cn.kiroe.day22_reflect._05add;

/**
 * @author kiro
 * @description:
 * @data 17:51 7/11/2023
 **/
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("cn.kiroe.day22_reflect._05add.A");
        // 这可以通过字码文件 直接newINstance 创建一个新对象
        // 前提条件必须有无参构造器
        // 否则报 java.lang.InstantiationException
        Object o = c.newInstance();
        System.out.println("o = " + o);

    }
}

class A{
    int a;

    public A(int a) {
        this.a = a;
    }
}
