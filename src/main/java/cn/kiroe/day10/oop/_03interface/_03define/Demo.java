package cn.kiroe.day10.oop._03interface._03define;

/**
 * @author kiro
 * @description:
 * @data 16:08 24/10/2023
 **/
/*

**接口的特点我们主要研究以下方面**

1. 接口的声明特点
   1. 接口能不能创建对象? 不能
   2. 接口能不能用final修饰? 不能
2. 接口的实现类的书写格式
    对接口的实现命名为 XXXImpl; XXX 为接口名字
   ** 把实现类放在一个 叫impl的包里面，某些程序员会在接口的所在位置,定义一个全新的包,叫"impl" **
3. 成员特点
   1. 能否定义属性(成员变量, 静态成员变量, 全局常量)?
      接口中定义的成员默认为 public final static --> 静态全局常量
   2. 能否定义方法/行为?
4. 构造器 没有构造器
5. 代码块 没有代码块

结论： 可以定义全局常量 以及抽象方法
 */
public class Demo {

    public static void main(String[] args) {
        IA iA = ()-> System.out.println("test");//'IA' is abstract; cannot be instantiated
        iA.print();
    }
}

interface IA{
    void print();
}

class IAImpl implements IA{

    @Override
    public void print() {

    }
}


interface IB{
    int a = 1;
    static int b = 1; // Modifier 'static' is redundant for interface fields
    public static int c = 1;
    public final static  int d = 20; // 成员为静态全局常量
    // public final static 可以省略掉


    public abstract void m1(); // Interface abstract methods cannot have body
    // public abstract  默认有，可以省略掉， 默认为 抽象方法
    void m2();


    // 不能有代码块
    /*{

    }*/

    /*static {

    }*/


}