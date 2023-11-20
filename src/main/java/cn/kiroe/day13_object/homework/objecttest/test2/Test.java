package cn.kiroe.day13_object.homework.objecttest.test2;

/**
 * @author kiro
 * @description:
 * @data 20:20 27/10/2023
 **/
/*
# 简答题

对于Object类的getClass方法，做以下操作练习：

1.随意定义两个类A和类B，然后创建2个A对象，1个B对象，三个对象分别调用getClass方法获取返回值Class对象。然后用"=="互相比较，比较的结果是什么呢？为什么有这样的比较结果呢？

**注：要去掉泛型，不要带着泛型用"=="比较。**



**2.getClass方法可以获取某个类型的运行时类对象，而运行时类对象对于某一个类型而言是唯一的，所以getClass方法可以用于判断两个引用指向的对象是否是相同类型的对象。请写方法实现这个功能，要求：**

**是同种类型对象返回true**

**不是同种类型对象返回false**
 */


public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        B b = new B();
        System.out.println("a1.getClass() == a2.getClass() = " + (a1.getClass() == a2.getClass()));
        System.out.println("a1.getClass() == b.getClass() = " + ( a1.getClass() == (Object)b.getClass()));

        System.out.println("isSameClass(a1,a2) = " + isSameClass(a1, a2));
        System.out.println("isSameClass(a2,b) = " + isSameClass(a2, b));
    }

    //*2.getClass方法可以获取某个类型的运行时类对象，
    // 而运行时类对象对于某一个类型而言是唯一的，
    // 所以getClass方法可以用于判断两个引用指向的对象是否是相同类型的对象。
    // 请写方法实现这个功能，要求：**
    //
    //**是同种类型对象返回true**
    //
    //**不是同种类型对象返回false**
    public static boolean isSameClass(Object o1,Object o2){
        return o1.getClass() == o2.getClass();
    }
}

/*
1.随意定义两个类A和类B，然后创建2个A对象，1个B对象，
三个对象分别调用getClass方法获取返回值Class对象。
然后用"=="互相比较，比较的结果是什么呢？为什么有这样的比较结果呢？

**注：要去掉泛型，不要带着泛型用"=="比较。**
 */

class A {

}

class B {

}
