package cn.kiroe.day07.oop2._04block._02constructor;

/**
 * @author kiro
 * @description:
 * @data 16:23 19/10/2023
 **/

/*

目前赋值手段：
1. 默认赋值
2. 显示赋值
3. 构造赋值

1.第一步永远是 默认赋值

4.构造器永远是 最后异步

结论：
1. 代码 在上面的先 执行
**显式赋值和构造代码块的执行顺序，并不是固定的，而是按照代码的书写顺序去执行的

1. 这两个结构，谁写在代码书写顺序的上面，谁就先执行。
2. 后执行结构的结构，自然会覆盖先执行结构的结果。

 */
public class Demo2 {

    public static void main(String[] args) {
        //创建对象
        //System.out.println("Student.id= " + Student.id);
        new Student("233",40);
        System.out.println("Student.id = " + Student.id);
    }
}

class Student{
    //  构造代码块 , 首先会进行类加载， 对 对象进行 初始化
    {
        age = 30;
        System.out.println("test");
    }
    static {
        id= 20;
        System.out.println("fff");
    }
    static int id = 10;

    String name;
    int age = 20;
    public Student(String name, int age) {
        new Student("test");
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }
}
