package cn.kiroe.day10.oop._03interface._2basic;

interface IA {

}

interface IC {

}

interface ID {

}

/**
 * @author kiro
 * @description:
 * @data 15:52 24/10/2023
 **/
/*

- 接口的访问权限修饰符也只有两种：

  1. public
  2. 默认缺省的

- 接口名和类名一样，遵循大驼峰式的书写规范，接口名最好起的见名知意。有些程序员喜欢在接口前加一个大写字母I来直接，表示该类型是一个接口，可以借鉴，但不强制。

- 接口中可以定义抽象方法，和抽象类中定义抽象方法没有区别。

- 接口是可以被一个类"继承"的，接口的"继承"，更准确、常见的叫法称之为接口的实现。
当然它也不再使用extends关键字，而是使用 implements 关键字。
一个普通类实现接口必须实现所有抽象方法。它的语法是：

   [访问权限修饰符] class 类名 extends 类名 implements 接口名 {}
    可以多实现，
       [访问权限修饰符] class 类名 extends 类名 implements 接口名,接口名,接口名 {}

  细节问题：如果一个类实现接口并继承别的类，要"==先继承再实现=="。关键字位置不要写反了。

- 在接口的实现中，可以称呼接口为"父接口"，接口的实现类为"子类"，它们仍然是父子关系。当然多态现象仍然能够发生。
- 接口不受多继承限制，一个类可以在继承别的类的同时实现接口，而且可以实现多个接口。
 */
public class Demo {
}

// 一个类可以实现 多个接口
class A implements IA, IC {

}

// 可继承后多实现
class AA extends A implements IA, IC, ID {

}

class Cat {

}

//    [访问权限修饰符] class 类名 extends 类名 implements 接口名 {}
// 先 extends 再 implements
class SuperCat extends Cat implements ISkill {

    @Override
    public void walk() {
        System.out.println("直立行走");
    }
}

