package cn.kiroe.day07.oop2._02static._03.method;

/**
 * @author kiro
 * @description:
 * @data 14:52 19/10/2023
 **/
/*
1. 成员的所属
   - 静态成员 属于类，也成为类变量
   - 非静态成员： 属于对象
2. 在内存中的位置
   - 静态： 在类对应的Class对象中 ，堆中
   - 非静态： 在堆中实例对象上
3. 在内存中出现的时间
    - 静态成员： 随着类的加载 而加载(优先)
    - 非静态： 和对象一致
4. 调用方式
    - 静态： 建议通过 类名.对象调用    ,通过 对象. 调用不推荐
    - 非静态： 对象名. 调用

 */
/*
注意事项：
  1. 一个类中，静态方法无法直接调用非静态的方法和属性，也不能使用this，super关键字（super后面会讲）,静态的方法只能访问静态的
  2. 经典错误：Non-static field/method xxx cannot be referenced from a static context
  3. 原因：静态方法调用的时候，完全有可能没有对象，没有对象普通成员就无法访问。
  4. 普通成员方法当中，既可以访问静态成员的, 也可以访问非静态成员。普通成员方法访问任意的
  5. 访问静态成员变量的时候，使用类名.变量名的形式访问，以示区别，增加代码可读性
 */

// 类加载时机：
// 1. new直接创建该类的对象。(**首次**)
//2. 启动该类中的main方法。
//3. 访问该类的静态成员（方法和变量) (**首次**)

public class Demo2 {
    int a =1;

    public static void main(String[] args) {
        Demo2.staticMethod();
    }
    //在普通方法中 可访问静态的 和非静态的
    public void normalMethod(){
        System.out.println(this.a);
        this.normalMethod2(this );

    }
    public void normalMethod2(Demo2 this_){
        this_ = this;
        //访问静态成员


    }
    // 静态方法中 只能 直接访问静态成员，需要new对象才能访问普通成员
    public static void staticMethod(){
//        System.out.println(a);  //无法访问 非静态常量
        // normaMethod()
        // 静态方法和成员，属于类的--> 随着类的加载而加载，
        // 可能不存在对象， 非静态的东西属于对象
        // 只能创建对象访问
        Demo2 demo2 = new Demo2();
        System.out.println("demo2.a = " + demo2.a);
        demo2.normalMethod();



    }
}
