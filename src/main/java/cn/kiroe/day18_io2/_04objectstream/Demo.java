package cn.kiroe.day18_io2._04objectstream;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author kiro
 * @description:
 * @data 17:23 2/11/2023
 **/
public class Demo {
    public static void main(String[] args) {
        serialize();
        unserialize();
    }

    private static void unserialize() {
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("IOTest/object.txt")))){
            Student student = (Student) inputStream.readObject();
            System.out.println("student = " + student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serialize() {
        // 创建序列化流对象
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("IOTest/object.txt")))) {
            // 对象
            Student s1 = new Student("张1", 23,4.9);
            out.writeObject(s1);
        } catch (IOException e) {

        }
    }
}


// serialVersionUID  不匹配
class Student implements Serializable {
    private String name;
    private Integer age;

    transient private Double score;

    static final long serialVersionUID = 42L;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

     public Student(String name, Integer age, Double score) {
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


class Dog implements Serializable{

    private static final long serialVersionUID = 3697412301761151230L;
}
