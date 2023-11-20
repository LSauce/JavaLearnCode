package cn.kiroe.day18_io2._02charstream._05buffer;

import java.io.*;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 15:25 2/11/2023
 **/

/*

使用缓存流读取数据
 */
public class Demo2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/a.txt"))) {
            // BufferedReader 中独有的方法
            String readLineString;
            while ((readLineString = reader.readLine()) != null) {
                System.out.println("reader.readLine() = " + readLineString);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /* lable:while (true){
            lable2:while (true){
                if (true){
                    break lable;
                }
            }
        }*/
        File file = new File("IOTest/o.txt");

        // 序列化
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInput input = new ObjectInputStream(new FileInputStream(file))) {
            // 写入数据
            Student[] students = new Student[10];
            for (int i = 0; i < students.length; i++) {
                students[i] = new Student("张" + i, i);
            }
            output.writeObject(students);
            // 读取数据
            Student[] students1 = (Student[]) input.readObject();
            Arrays.stream(students1).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}


class Student implements Serializable {
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
