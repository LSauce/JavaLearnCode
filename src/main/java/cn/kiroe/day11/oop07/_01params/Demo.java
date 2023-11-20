package cn.kiroe.day11.oop07._01params;

/**
 * @author kiro
 * @description:
 * @data 11:54 25/10/2023
 **/
/*

### 方法传值

方法的形参在方法调用传入实参时，不一定要求数据类型完全一致。

- **基本类型：**对于基本数据类型的方法形参，存在自动类型提升。
- **引用类型：** 对于引用数据类型的方法传参，存在自动向上转型。
  1. 形参如果写一个普通类：调用方法时需要传入的是该类的对象或者该类的子类对象
  2. 形参如果写一个抽象类：调用方法时需要传入的是该抽象类的子类对象
  3. 形参如果写一个接口：调用方法时需要传入的是该接口的子类对象
 */
public class Demo {

    public static void main(String[] args) {

        int a = 1;
        m1(a);//基本数据类型
        //自动类型的转换
        byte ab = 1;
        m1(ab);

        //引用数据类型
        m2(new Father());

        m2(new Son()); //自动类型转换
        // 抽象类为参数类型，
        AbstractA aa ;
        // 没有对应的无法使用
        m3(aa =new AbstractA(){
            public  void test1(){
                System.out.println(22);
            }
        });


        m3(new A());




    }
    public static void m2(Father father){

    }
    public static void m1(int a){

    }

    public static void m3(AbstractA a){

    }

    public static void m4(IA a){ // 写不出 急躁怎么办。。。

    }
}

class Father{

}
class Son extends Father{

}

abstract class AbstractA{

}

class A extends AbstractA implements IA{

}

interface IA{

}

