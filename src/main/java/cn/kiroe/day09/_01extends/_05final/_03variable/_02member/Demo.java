package cn.kiroe.day09._01extends._05final._03variable._02member;

/**
 * @author kiro
 * @description:
 * @data 16:37 23/10/2023
 **/

/*

final修饰成员变量表示该成员变量变成了一个常量，
它在内存中的位置，生命周期，使用方式等都不会改变。

语法：


[访问权限修饰符] final 数据类型 变量名;
final 修饰成员变量是 必须进行 初始化（不能使用默认初始）

如果直接在类中成员位置，写上述语法定义成员"常量"，肯定会报错。
这是因为默认值不能当成final修饰成员变量的取值，
必须（在创建对象过程中）
显式明确的给出一个值，而且这个值一旦给出就不可更改了。
也就是说，成员常量的赋值，有且必须有一次。目前我们给成员变量的赋值方式还有（除了默认初始化）：

1. 显式赋值
2. 构造代码块赋值
3. 构造器赋值

3种方式都可以，但只能使用一种方式


 */
public class Demo {
    public static void main(String[] args) {
        Student student = new Student(2233);
        System.out.println("student.age = " + student.age);
    }

}

class Student{
    // Variable 'name' might not have been initialized
    {
        //age = 233;
        //name = "fff";// Cannot assign a value to final variable 'name'
    }
    final String name = "zs";
    final int age; //Variable 'age' might not have been initialized

    // public Student() { // 不用使用无参构造，因为还有 成员常量没赋值
    // }

    public Student(int age) {
        this.age = age;
    }
}
