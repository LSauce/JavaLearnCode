package cn.kiroe.day22_reflect.homework.reflectex.work3;

import cn.kiroe.day02.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 20:19 7/11/2023
 **/

/*

要求：

（1）定义一个学生类Student，其中包含姓名(String)、年龄(int)、成绩(int)的属性。
（2）编写带参与无参构造方法。
（3）重写父类的toString()方法用于输出学生的信息。
（4）编写测试类TestStudent，从键盘录入学生的信息格式为(姓名:年龄:成绩)一次性录入使用“:”分隔，举例(张三:20:90)。
（5）使用String类的split方法按照“:”进行分隔。
（6）调用Constructor的newInstance()方法并用分隔后的信息初始化学生对象。
（7）调用重写父类的toString()方法将学生信息进入输出显示。
 */
public class Work3 {
    public static void main(String[] args) {
        TestStudent.testStudentByReflect();
    }
}
// （4）编写测试类TestStudent，
class TestStudent{
    public static void testStudentByReflect(){

        // 从键盘录入学生的信息格式为(姓名:年龄:成绩)一次性录入使用“:”分隔，举例(张三:20:90)。
        try (Scanner scanner =new Scanner(System.in)){
            System.out.println("录入学生的信息格式为(姓名:年龄:成绩)一次性录入使用“:”分隔，举例(张三:20:90)");
            String input = scanner.nextLine();
            // 获取 学习
            // （5）使用String类的split方法按照“:”进行分隔。
            String[] info = input.split(":");
            // （6）调用Constructor的newInstance()方法并用分隔后的信息初始化学生对象。
            // 获取Student类对象
            Class studentClass =Class.forName("cn.kiroe.day22_reflect.homework.reflectex.work3.Student");
            Constructor declaredConstructor = studentClass.getDeclaredConstructor(String.class, int.class, int.class);
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));

            // （7）调用重写父类的toString()方法将学生信息进入输出显示。
            System.out.println("o.toString() = " + o);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}

class Student{
    // （1）定义一个学生类Student，其中包含姓名(String)、年龄(int)、成绩(int)的属性。
    String name;
    int age;
    int score;
    // （2）编写带参与无参构造方法。


    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}



