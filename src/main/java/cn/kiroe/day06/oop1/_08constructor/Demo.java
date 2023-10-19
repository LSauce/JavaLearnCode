package cn.kiroe.day06.oop1._08constructor;

/**
 * @author kiro
 * @description:
 * @data 11:44 18/10/2023
 **/
public class Demo {

    /*

    构造器执行顺序
    1. 首先 进行默认赋值
    2. 显示赋值
    3. 构造器赋值
    构造器负责永远是最后的
     */

    public static void main(String[] args) {
        Student student = new Student("tes",1);

    }



}

class Student{
    // 调用 构造方法后 再显示赋值
    private String name ="23";
    private int age = 22;

    public Student(String name, int age) {
        this();
        //先显示赋值 ，后面在构造器赋值
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
