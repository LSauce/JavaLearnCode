package cn.kiroe.day07.oop2._04block._02constructor;

/**
 * @author kiro
 * @description:
 * @data 16:31 19/10/2023
 **/
public class Demo3 {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("zs", 20);
        Teacher teacher1 = new Teacher("zs");
        Teacher teacher2 = new Teacher();
        //构造代码块执行了这句话
        //构造代码块执行了这句话
        //构造代码块执行了这句话
        // 构造代码块在 this()时


    }
}

class Teacher{
    String name;
    int age;
    {
        System.out.println("构造代码块执行了这句话");
    }
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {
    }
}
