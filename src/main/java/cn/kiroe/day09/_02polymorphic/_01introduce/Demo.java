package cn.kiroe.day09._02polymorphic._01introduce;

/**
 * @author kiro
 * @description:
 * @data 17:25 23/10/2023
 **/
/*

从字面意义上理解，同一个事物，在不同的时刻/情况表现出不同的状态，就可以称之为多态。

在Java的多态当中，多态指的是：

1. 同一种事物：同一个引用（即父类的引用）
2. 不同的情况：指向不同的对象（不同的子类对象）
3. 不同的状态：调用同名方法会体现出不同的行为

 总结来说，
 Java中的多态指的是，同一个父类引用指向不同子类对象时，
 调用同名成员方法，根据指向实际对象的不同，得到的行为也会随之不不同。

练习:

定义一个父类Phone, 3个子类Huawei, XiaoMi, Iphone去模拟多态场景.


根据上述定义，总结一下Java中多态发生的条件：

1. 必须存在继承，多态一定发生在父子类之间。
2. 必须存在方法重写，不同的子类需要重写父类中的同名方法。
3. 必须存在父类引用指向子类对象


根据上述定义, 总结一下不能Java中多态发生的条件
1. 不能继承的类，即final修饰的类。一个final修饰的类都没有子类，多态肯定和它无缘。
2. 不能重写的方法，不能重写也没有多态。不能重写的方法有：
   1. final修饰的方法，final限制了重写
   2. static方法，不参与继承和重写。
   3. private方法，没有权限重写。
   4. 构造方法，不能继承。
3. 不写代码用父类引用指向子类对象，同样没有多态。（这一点就需要手动完成了，看程序员用不用）

##

 */
public class Demo {

    public static void main(String[] args) {
        // 父类引用
        Phone phone;
        // 不同的子类对象
        phone = new HuaWei();
        phone.aiMethod();

        phone = new XiaoMI();
        phone.aiMethod();

        phone = new Iphone();
        phone.aiMethod();
    }
}

class Phone{
    String name;
    String soc;


    public void aiMethod(){
        System.out.println("使用语音助手");
    }
}

class HuaWei extends Phone{
    @Override
    public void aiMethod() {
        System.out.println("小E");
    }
}

class XiaoMI extends  Phone{
    @Override
    public void aiMethod(){
        System.out.println("小爱同学");
    }
}
class Iphone extends Phone{
    @Override
    public void aiMethod() {
        System.out.println("\"hi siri\" = " + "hi siri");
    }
}
