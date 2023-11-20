package cn.kiroe.day09.homework.supertest;

/**
 * @author kiro
 * @description:
 * @data 19:54 23/10/2023
 **/
/*
使用alt + insert快捷键可以快速生成各种类中结构。子类继承父类后，在子类中按alt + insert快捷键快速创建构造方法时，
第一步会让你选择父类构造器（也就是super(参数)）随后才是选择子类自身的成员变量，生成子类构造器。

当选择使用父类无参构造器，这时super()是隐藏的，即子类对象隐式初始化。

当选择使用子类有参构造器时，这时super(参数)必须写在子类构造器第一行，这是子类对象的显式初始化。

题目:

给出三个层级的继承关系
顶层父类Grandfather，Father继承Grandfather，Son继承Father
三个类的成员变量分别是（变量的类型是int）：
Grandfather类，有两个成员变量：gA,a
Father类，有两个成员变量：fA,a
Son类，有两个成员变量：sA,a

成员方法（方法体写一个能够区分的输出语句就行）：
Grandfather：testGrand,test
Father：testFather,test
Son：testSon,test

使用快捷键在Son中生成不同的构造方法，调用不同的父类构造器（需要先生成父类相应的构造器）
随后使用多种方式创建Son对象，测试对象名访问成员的机制，理解属性隐藏和方法覆盖。

该题目单纯练习语法和测试代码，不用思考过多。
 */
public class SuperTest {

    public static void main(String[] args) {

        final int a;
        // 对于 成员变量的访问，范围看左边，运行看左边
        Grandfather gfSon = new Son(111,888);
        System.out.println(gfSon.a);// 为gf的值
        Grandfather gfF = new Father(222,333);
        System.out.println("gfF.a = " + gfF.a);// 为 gf的值
        // 成员方法 ,范围看左边,运行看右边
        Grandfather gfSon2 = new Son();
        gfSon2.test();
        Grandfather gfF2 = new Father();
        gfF2.test();
    }
}
/*
给出三个层级的继承关系
顶层父类Grandfather，Father继承Grandfather，Son继承Father
三个类的成员变量分别是（变量的类型是int）：
Grandfather类，有两个成员变量：gA,a
Father类，有两个成员变量：fA,a
Son类，有两个成员变量：sA,a
 */
class Grandfather{
    int gA;
    int a = 1;

    void testGrand(){
        System.out.println("TestGrand");
    }
    void test(){
        System.out.println("Grandfather test()");
    }

    public Grandfather() {
    }

    public Grandfather(int gA, int a) {
        this.gA = gA;
        this.a = a;
    }
}

class Father extends Grandfather{
    int fA;
    int a=22;

    void testFather(){
        System.out.println("testFather");
    }
    void test(){
        System.out.println("Father test");
    }
    public Father(){
        System.out.println("Father的无参构造");
    }
    public Father(int fA, int a) {
        this.fA = fA;
        this.a = a;
    }
}

class Son extends Father{
    int sA;
    int a=33;

    void testSon(){
        System.out.println("testSon");
    }

    void test(){
        System.out.println("Son test");
    }

    public Son() {
    }

    public Son(int sA, int a1) {
        this.sA = sA;
        this.a = a1;
    }
}


