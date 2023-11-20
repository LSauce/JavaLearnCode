package examination.iowork;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author kiro
 * @description:
 * @data 20:17 8/11/2023
 **/

/*
请按照流程实现下列功能，可以提取方法，也可以将代码都写在main方法当中。
先定义一个Student类，类中提供id、name、age等属性。提供构造器，提供toString方法重写等。

定义一个Student数组，长度为10首

接下来用控制台键盘录入给Student数组赋值，不一定要完全赋值10个对象，当输入的内容为exit时即可退出赋值；

赋值完毕后，接下来将Student数组中的null元素去掉，获取一个没有null的Student数组

然后对该Student数组中的元素进行自然排序，要求数组中的元素按照年龄从小到大排序；

最后遍历数组，将数组中学生信息写入到记事本，每个学生数据占单独一行。

注：是将该对象的toString方法结果字符串写到文件中，不是将对象写到文件中。
 */
public class Work1 {
    // 定义一个Student数组，长度为10首
    static Student[] students = new Student[10];

    public static void main(String[] args) {
        // 接下来用控制台键盘录入给Student数组赋值，不一定要完全赋值10个对象，当输入的内容为exit时即可退出赋值；
        try (Scanner scanner = new Scanner(System.in); PrintWriter writer = new PrintWriter(new FileWriter("out.txt"))) {
            String input;
            int count = 0;
            System.out.println("输入格式为：(编号=姓名=年龄)");
            while (count < 10 && !"exit".equals((input = scanner.nextLine()))) {
                String[] split = input.split("=");
                // 创建对象加入
                students[count] = new Student(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
                count++;
            }
            // 赋值完毕后，接下来将Student数组中的null元素去掉，获取一个没有null的Student数组
            List<Student> list =new ArrayList<>();
            for (Student student : students) {
                if(student != null){
                    list.add(student);
                }
            }

            list.sort((s1,s2)->{
                // 然后对该Student数组中的元素进行自然排序，要求数组中的元素按照年龄从小到大排序；
                return s1.age - s2.age;
            });

            // 写出数据
            for (Student student : list) {
                writer.println( student.id+"="+student.name+"="+student.age);
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

// 先定义一个Student类，类中提供id、name、age等属性。提供构造器，提供toString方法重写等。
class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
