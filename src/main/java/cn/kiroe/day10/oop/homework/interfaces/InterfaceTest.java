package cn.kiroe.day10.oop.homework.interfaces;

import org.junit.Test;
//     注：虽然行为一致，但实现会不同。
//额外进行技能的学习：学生需要增强实践动手能力，老师需要增强语言能力。
interface IEnhanceCapacity {
    void enhanceCapacity();
}

/**
 * @author kiro
 * @description:
 * @data 19:48 24/10/2023
 **/

/*
接口与抽象类基础语法练习
从实际角度出发，接口和抽象类的差异是十分明显的。可以参考完成以下案例：

 学生和老师都有共同的属性: name、gender、age
 共同的行为：eat() sleep()
     注：虽然行为一致，但实现会不同。
 现在为了提升自身素质，大家都需要额外进行技能的学习：学生需要增强实践动手能力，老师需要增强语言能力。
 请定义抽象类和接口，描述以上体系。
 ​
 然后用以下方式进行测试：
     1，用不同的父类指向不同的子类对象，理解方法调用时“编译时看左边”
     2，用这些引用调用方法，理解方法调用时“运行时看右边”
 */
public class InterfaceTest {
    @Test
    public void interfaceTest() {
        Person student = new Studnet("张三", "未知", 100);
        Person teacher = new Teacher("李四", "中性", 100);
        student.eat();
        teacher.eat();
    }
}

//学生和老师都有共同的属性: name、gender、age
abstract class Person {
    private String name;
    private String gender;
    private int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public abstract void eat();

    public abstract void sleep();
}

// 共同的行为：eat() sleep()
class Studnet extends Person implements IEnhanceCapacity {

    public Studnet(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void eat() {
        System.out.println("学生吃食堂");
    }

    @Override
    public void sleep() {
        System.out.println("学生睡宿舍");
    }

    @Override
    public void enhanceCapacity() {
        System.out.println("增强实践动手能力");
    }
}

class Teacher extends Person implements IEnhanceCapacity {
    public Teacher(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void enhanceCapacity() {
        System.out.println("增强语言能力");
    }

    @Override
    public void eat() {
        System.out.println("老师吃工作餐");
    }

    @Override
    public void sleep() {
        System.out.println("老师回家睡");
    }
}


