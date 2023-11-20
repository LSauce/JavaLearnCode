package cn.kiroe.day09._01extends._02init._03super._01basic;

/**
 * @author kiro
 * @description:
 * @data 11:16 23/10/2023
 **/

/*
子类对象的初始化
子类的类加载会触发父类的类加载，并且类加载的顺序是"先父后子"的。
父子类加载(先父后子)
父子类成员赋值(先父后子)
- 默认初始化
- 显式赋值
- 构造代码块赋值
- 构造器赋值


隐式初始化 必要条件
**隐式对象初始化的必要条件：**

1. 父类中有默认的构造方法
2. 子类的构造器中没有显式使用super调用父类的构造方法，也没有用this去调用自己的构造方法。

达成上述两个条件，则JVM在初始化子类对象时进行隐式初始化，永远先执行父类的构造方法，顺序为：

1. 最上层的父类（Object）
2. 其他父类（继承链中越处于上流越先执行）
3. 所有父类的构造方法都执行完毕，开始执行子类构造方法

显示初始化
注意事项：
所以就需要子类对象的显式初始化。
即明确在子类构造器的第一行，用super(参数)，
明确指出调用父类的某个构造方法来完成父类成员变量的赋值。
super()
 */
public class Demo {

    public static void main(String[] args) {

    }
}

class Father {
    int a;

    public Father(int a) {
        this.a = a;
    }

    public Father() {
    }
}

class Son  extends Father{
    int c;
    // There is no default constructor available in 'day09._01extends._03super._01basic.Father'
    public Son(int c){
        //this();  //不能同时出现
        super(c);
    }

    public Son() {
        super();//默认 会添加一个
    }
}
