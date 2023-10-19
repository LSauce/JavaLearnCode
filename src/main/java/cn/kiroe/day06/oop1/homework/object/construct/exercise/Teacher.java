package cn.kiroe.day06.oop1.homework.object.construct.exercise;

/**
 * @author kiro
 * @description:
 * @data 14:35 18/10/2023
 **/
/*
定义一个Teacher类：

包含4个成员变量 String name, int age, String gender, int teacherId

然后定义5个构造方法：

无参构造

name单参构造方法

name和teacherId双参构造方法

name，age和gender的三参构造器

name，age，gender和teacherId的四参构造器（要求用this调用已存在的三参构造器）

最后再定义一个成员方法：

print()：用于打印这个Teacher类对象的基本信息。

回答下列问题：

在上面5个构造方法的基础上，再定义一个构造方法单独给gender赋值，能够做到吗？为什么？
 - 不能， 因为已有Teacher(String name) 构造方法，
定义完上述结构后，再定义一个成员方法setGender，用于给gender赋值。要求方法的形参就是String gender，这个方法如何写呢？
 public void setGender(String gender)}{

        this.gender = gender;

  }
定义完这个类后，创建两个Teacher对象分别为t1和t2

要求t1对象的四个成员变量name, age, gender, teacherId的值分别为"张三"、18、"男"、 1

要求t2对象的四个成员变量name, age, gender, teacherId的值分别为"李四"、25、"女"、 2

注意在使用构造器时，对应位置的实参和形参要一一对应。

最后分别用两个对象调用print方法，两次调用方法输出的结果相同吗？为什么？
- 不相同
- 这两个对象中在堆中 成员变量储存的值 不同
 */
//包含4个成员变量 String name, int age, String gender, int teacherId
public class Teacher {
    private String name;
    private int age;
    private String gender;
    private int teacherId;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, int teacherId) {
        this(name);
        this.teacherId = teacherId;
    }

    public Teacher(String name, int age, int teacherId) {
        this(name, teacherId);
        this.age = age;
    }

    public Teacher(String name, int age, String gender, int teacherId) {
        this(name, age, teacherId);
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }

    //print()：用于打印这个Teacher类对象的基本信息。
    public void print() {
        System.out.println(this.toString());
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
