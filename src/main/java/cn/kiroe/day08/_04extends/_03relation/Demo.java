package cn.kiroe.day08._04extends._03relation;

/**
 * @author kiro
 * @description:
 * @data 16:07 20/10/2023
 **/
/*

继承中的关系:
从属关系（relation）上来说，继承中的父子类具有 <font color=red>**"is-a"**</font> 关系。即子类 <font color=red>**"is-a"**</font> 父类。子类可以近似地看成是一个父类，子类可以当作父类来使用.

那么如何理解这句话呢？我们从以下几个角度分析。

- 从直观的逻辑角度解释：
  - Student就是Person
  - Teacher就是Person
  - Cat也是Animal
  - Dog也是Animal

- 实际代码书写角度解释：

  1. 在正常情况下，创建谁的对象，就用谁的引用接收。
  1. 但是在具有父子类关系的两个类中，存在用父类引用接收子类对象的情况。
  1. 在这种情况下，子类对象被当成了父类对象去使用了。
  1. 即子类可以看成就是一个父类，也就是"is-a"关系。

- 从数据类型的定义角度解释：

  1. 数据类型是 一组数据 + 基于数据的操作
  2. 引用数据类型是 成员变量的集合 + 成员方法的集合
  3. 子类通过继承父类，得到了父类的所有成员，从数据类型上来说，子类就覆盖了父类的成员，具有了父类的功能。
  4. 子类可以当做父类去使用，也就是子类"is-a"父类。


 <font color=red>**以上，所以说，子类"is-a"关系。**</font>

**注意:**

- 父类能当子类用吗(父类"is-a"子类关系)？
  - 显然不能，子类往往比父类功能要强大，父类不能当成子类使用
 */
public class Demo {
    //  1. 在正常情况下，创建谁的对象，就用谁的引用接收。
    Father father = new Father();
    Son son = new Son();
    //父类的引用 指向 子类对象
    Father fs = new Son(); //子类对象被当做 父类对象使用
     //java: incompatible types: cn.kiroe.day08._04extends._03relation.Father
    // cannot be converted to cn.kiroe.day08._04extends._03relation.Son
    // Son s = new Father();
    // 水果 苹果
    // 苹果 is a 水果
    // 水果 is a 苹果 X mistake
}


class Father{

}

class Son extends Father{

}