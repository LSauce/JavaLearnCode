package cn.kiroe.days12.oop._01intern._03static._01introduction;

interface IA {

}

/**
 * @author kiro
 * @description:
 * @data 14:39 26/10/2023
 **/
/*

## 静态内部类

​		有时候, 使用内部类只是为了把一个类隐藏在另外一个类的内部, 并不需要内部类有外部类对象的一个引用, 如果使用static来修饰一个成员内部类, 就不会生成那个引用, 则这个内部类就属于外部类本身, 而不是属于外部类的某个对象, 这就是所谓的静态内部类.

```java
//外部类
[访问权限修饰符] class OuterClazz{
// 静态内部类访问权限修饰符，有四个，和普通成员一样
	[访问权限修饰符] static class StaticInnerClazz{
 }
}
```



### 自身特点

依然主要从以下几个角度分析：

1. 访问权限修饰符
2. 成员特点
3. 继承和实现

#### 访问权限修饰符

**静态内部类和成员内部类一样，有四种访问权限级别：**

1. public
2. protected
3. 缺省的，默认访问权限
4. private
学习方式:
   1.定义的位置
    静态成员位置
   2.权限修饰符
        4种
   3.成员特点
        和普通类一样
   4.继承和实现
        不能继承 普通成员内部类，静态内部可以
        因为 普通成员内部类需要 依靠外界 对象
   5.访问特点
        把静态内部类当成 一个独立的 类  ，外部类和内部类 在类中互相调用 无权限现在
       内部类----->外部类
            普通成员方法： 创建外部类对象，通过对象.访问
            静态成员方法： 通过 类名. 访问
       外部类----->内部类

       内部类----->外部其他类
            和普通一样
       外部其他类--->内部类
            new外部对象后.调用构造器

 */
public class Demo {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = new Outer.Inner(); // 通过 Outer.Inner() 创建对象
    }
}

class Outer {
    static int c = 3;
    int a = 1;
    private int b = 2;

    public void innerNormalMethod() {
        Inner inner = new Inner();
        inner.innerNormalMethod();
        System.out.println("inner.a = " + inner.a);
        System.out.println("inner.c = " + inner.c);
    }

    static class Inner {
         int a = 1;
        static int b = 2;
        private int c = 20;
        {

        }

        public Inner() {

        }

        public static void innerStaticMethod() {

        }

        public void innerNormalMethod() {
            // 内部类----->外部类
            // 创建外部类对象，通过对象. 访问
            Outer outer = new Outer();
            System.out.println("outer.a = " + outer.a);
            System.out.println("outer.b = " + outer.b);
            System.out.println("Outer.c = " + Outer.c);

        }
    }

    static class Inner2 extends A implements IA {


    }

    // No enclosing instance of type 'cn.kiroe.days12.oop._01intern._03static._01introduction.Outer' is in scope
    static class Inner4 extends Inner2 {

    }

    static class Inner3 {

    }
}

class A {

}
