package cn.kiroe.day07.homework.question9;

/**
 * @author kiro
 * @description:
 * @data 21:58 19/10/2023
 **/
/*
静态成员变量的赋值顺序debug模式练习：

public class Demo {
 public static void main(String[] args) {
     Person p = new Person(18);
 }
}
class Person {
 int age = 10;
 static String nationality = "美国";

 public Person(int age) {
     this.age = age;
 }


 public Person() {
 }

 public Person(String nationality) {
     Person.nationality = nationality;
 }
}
 */
public class Question9 {
}

//静态成员变量的赋值顺序debug模式练习：

class Demo {
    public static void main(String[] args) {
        Person p = new Person(18); //1.
    }
}
class Person {
    int age = 10;//4. 0--》4
    static String nationality = "美国";// 2. clinit 类加载 - 静态变量赋值

    public Person(int age) {//3. init
        this.age = age; //5 构造赋值
    }


    public Person() {
    }

    public Person(String nationality) {
        Person.nationality = nationality;
    }
}
