package cn.kiroe.day10.oop.homework.polymorphic.test;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 19:13 24/10/2023
 **/
/*
请根据题目，作出合理设计，定义如下类：
 父类Person
     属性：String name，int age
     行为：eat();

 子类SouthPerson
     属性：String name，int age，double salary
     行为：eat()，swim()
 ​
 子类NorthPerson
     属性：String name，int age，double height
     行为：eat()，drink()
 ​
 写代码实现，eat()方法的多态效果
     1，人都要吃饭
     2，南方人喜欢吃米饭
     3，北方人喜欢吃面食
 ​
 最后，在测试类中，编写测试代码，要求进行如下测试：
     1，编写测试方法，
         要求该方法允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
         方法调用的结果一致吗？
     2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
         如果不能，应该怎么写代码让它能够正常调用？
     3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
         如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
 */
public class PolymorphicTest {
    /*
     1，编写测试方法，
         要求该方法允许传入SouthPerson对象和NorthPerson对象，并在方法体中调用它们的eat()方法
         方法调用的结果一致吗？
          - 方法重新了 不一致
     2，用父类引用指向子类对象的方式创建SouthPerson对象，能否直接访问salary属性和swim()方法？
         如果不能，应该怎么写代码让它能够正常调用？
         - 不能，可使用强制转型，再调用
     3，用父类引用指向子类对象的方式创建NorthPerson对象，能否（直接或写代码）访问salary属性和swim()方法？
         如果不能，将该对象引用强转为SouthPerson引用，能否成功？为什么？
          不能，NorthPerson无法转为 SouthPerson，因为并没有继承关系，会发生 类型转换异常
     */
    @Test
    public void PersonTest(){
        Person southPerson= new SouthPerson("南方人1",20,2000);
        southPerson.eat();
        Person northPerson = new NorthPerson("北方人1",18);
        northPerson.eat();
        System.out.println("((SouthPerson)southPerson).salary = " + ((SouthPerson) southPerson).salary);
        ((SouthPerson)southPerson).swim();
        ((NorthPerson)northPerson).drink();

        //((SouthPerson)northPerson).swim();// NorthPerson cannot be cast to SouthPerson

    }

}

// 父类Person
//     属性：String name，int age
//     行为：eat();
class Person{
    String name;
    int age;
    public void eat(){
        System.out.println("人都要吃饭");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
//
// 子类SouthPerson
//     属性：String name，int age，double salary
//     行为：eat()，swim()
class SouthPerson extends Person{
    double salary;

    public SouthPerson(String name, int age) {
        super(name, age);
    }

    public SouthPerson(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void eat(){
        System.out.println("南方人喜欢吃米饭");
    }

    public void swim(){
        System.out.println("南方人游泳");
    }
}
// ​
// 子类NorthPerson
//     属性：String name，int age，double height
//     行为：eat()，drink()
class NorthPerson extends Person{
    double height;

    public NorthPerson(String name, int age) {
        super(name, age);
    }

    public NorthPerson(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    @Override
    public void eat(){
        System.out.println("北方人喜欢吃面食");
    }

    public void drink(){
        System.out.println("北方人喝酒");
    }

}