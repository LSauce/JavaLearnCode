package cn.kiroe.day08._04extends._02basic;

/**
 * @author kiro
 * @description:
 * @data 16:00 20/10/2023
 **/

/*

1. 这个继承了一个已存在类的类，称之为子类。被继承的类称之为父类。

2. 使用继承extends(扩展)关键字后，子类就获取到了父类的所有成员（成员变量和成员方法）.严格来说，继承只考虑对象相关成员的继承，静态成员我们先暂时不考虑。

3. 子类在继承父类的同时，还可以自己定义新的成员，这叫做子类在父类的基础上进行扩展（所以子类往往比父类的功能更加强大，青出于蓝而胜于蓝。）

4. 子类不能继承父类没有的成员。
 */
public class Demo {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //可以使用父类的属性
        System.out.println("teacher.name = " + teacher.name);
        //可以使用父类的方法
        teacher.eat();
        //
        Student student = new Student();
        student.study();
        student.eat();

    }
}

class Person{
    String name;
    public void eat(){
        System.out.println("\"eat\" = " + "eat");
    }
}

class Teacher extends Person{
    String teacherID;

    public void teach(){
        System.out.println("teach ..");
    }


}

class Student extends Person{
    int sID;
    public void study(){
        System.out.println("\"study\" = " + "学习");
    }
}
