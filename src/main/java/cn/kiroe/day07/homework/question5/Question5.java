package cn.kiroe.day07.homework.question5;

/**
 * @author kiro
 * @description:
 * @data 21:17 19/10/2023
 **/
public class Question5 {

}

/**
 * 问题1: 思考注释1下面的代码能否放开?会不会报错?
 * - 能放开，因为 该类并没有 被实例化new
 * 问题2: 思考控制台输出的顺序,提供必要的文字说明解释代码为何如此执行。
 * - 注释中
 * 问题3: Homework building和Homework constructor会不会输出,为什么?
 * - 不会 ，未被初始化
 */

/*

Student building  5
Student constructor 6.1
main 6.2
20 6.3
Student building 8.1
Student constructor 9.1
Person building 11
Person constructor 13
刘备
 */
class Homework {
    static Student s = new Student(); //1. main()启动前 加载类，进行静态变量显式赋值
    {
        System.out.println("Homework building"); //未被实例化 不执行
        s = null;
    }
    public static void main(String[] args) {
        System.out.println("main");//6.2
        // 注释1
        // 能放开，因为 该类并没有 被实例化new
        System.out.println(s.age);//6.3 打印 20
        Person p = new Person("刘备");//7.准备加载 Person
        System.out.println(p.name);
    }

    public Homework() {
        System.out.println("Homework constructor");
    }
}
class Person{
    {//10. 构造代码块
        name = "赵云";
        System.out.println("Person building");//11. 打印
    }
    String name = "曹操";//12
    static Student s = new Student();// 8 clinit

    public Person() {
    }

    public Person(String name) {//9. init
        System.out.println("Person constructor");//13
        this.name = name;
    }
}

class Student{
    int age = 10;//3. 0-->10 成员变量显示赋值
    {//4. 执行构造代码块
        System.out.println("Student building");//5. 8.1
        age = 20;//6.
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(){//2. 进行clinit加载类-->init
        System.out.println("Student constructor");//6.1 //9.1
    }
}
