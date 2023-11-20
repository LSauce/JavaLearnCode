package cn.kiroe.day09._01extends._04override._03override;

/**
 * @author kiro
 * @description:
 * @data 15:09 23/10/2023
 **/
/*

@Override 注解 --> 用于检测 子类当中某个方法 是否是  重写父类方法
 */
/*
1. 子类中重写的方法，访问权限等级，必须至少保持一致，==可以更为宽松==，但一定不能更严格。

2. 子类中重写的方法，返回值类型必须和原先父类方法的返回值类型，保持兼容(引用数据类型,不涉及基本数据类型)。

   注：何为兼容呢？这里留给大家思考~

3. 子类中重写的方法，方法名必须严格保持一致，不能做任何修改。

4. 子类中重写的方法，形参列表必须保持严格一致，不能做任何修改。

5. 方法体的代码，无所谓，可以保持一致，也可以修改。

静态方法在使用现象上，很像是被重写了，但实际上静态方法不能被重写，而是直接是一个新的静态成员。
（使用`@Override`注解标记会报错）
*/
public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        son.m3();

    }
}


class Father{

    public void m1(){
        System.out.println("father m1");
    }

    public void m3(){
        System.out.println("Father m3");
    }

    void m4(){
        System.out.println("Father m4");
    }

    int m5(){
        System.out.println("Father m5");
        return 10;
    }

    public Fruit m6(){
        System.out.println("father fruit");
        return new Apple();
    }

    public void m7(int a){
        System.out.println("father m7");
    }

}

class Son extends Father{
    /*
    在实际开发中，我们要求大家，在任何时候，**只要是在做方法的重写，就一定要加上注解**`@Override`，好处是：
    1. 能够检测语法，如果因为没加注解，导致将本不是方法重写的方法，误以为是方法重写，将会带来错误。
    2. 提升代码可读性，加了该注解的方法一定是重写自父类的方法。

     */
    @Override //  表示Son中 m1方法  重写 父类Father 的m1
    public void m1(){
        System.out.println("son m1");
    }

    //@Override //Method does not override method from its superclass
    public void m2() {

    }

    // 快捷键
    // 1.输入方法名
    // 2.代码生成
   /* @Override
    public void m3() {
        System.out.println("son m3");
    }*/

    @Override
    public void m3() {
        super.m3();
    }

    @Override //attempting to assign weaker access privileges ('private'); was 'packageLocal'
    public void m4() {
        super.m4();
    }

    @Override//attempting to use incompatible return type
    int m5() {
        byte b = 10;
        return b;
    }
    // 可以发生自动类型转换
    // 强制类型转换 是 引用类型的转换，变量并没有变化
    @Override // 返回值类型 兼容的类型即可，不涉及 基本数据类型 ！！！， 能自动类型转换 向上转
    public Apple m6() {
        Apple apple = new Apple();
        return apple;
    }

    @Override
    public void m7(int a) {
        super.m7(a);
        // 父子类的形参列表必须一样
    }
}

class Fruit{

}

class Apple extends Fruit{

}
