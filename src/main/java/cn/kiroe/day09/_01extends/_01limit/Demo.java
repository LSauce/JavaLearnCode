package cn.kiroe.day09._01extends._01limit;

/**
 * @author kiro
 * @description:
 * @data 10:02 23/10/2023
 **/
/*
1. 父类中的 private 修饰的成员
2. 父类中的 静态成员
3. 父类中的 构造方法
 */
public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        son.a = 10;
        System.out.println("son.a = " + son.a);
        // 访问父类中私有成员
        //System.out.println("son.b = " + son.b); // 父类当中 私有的无法使用
        System.out.println("son.getB() = " + son.getB());
        // 可以通过子类名.静态成员 --》 访问父类的静态成员 ， 这不是继承只是能用
        // 静态是基于类的
        System.out.println("Son.c = " + Son.c);
    }
}

class Father{
    int a;
    private int b = 11;
    static int c = 22;
    public int getB() {
        return b;
    }

    public Father() {
    }
}

class Son extends Father{

    static int c = 33;


    public Son() {
    }
}
