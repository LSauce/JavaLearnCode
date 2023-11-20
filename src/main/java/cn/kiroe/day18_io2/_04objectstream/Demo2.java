package cn.kiroe.day18_io2._04objectstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:11 3/11/2023
 **/
public class Demo2 {

    public static <e> void main(String[] args) {
        // 创建Teacher对象
        List<Teacher> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Teacher("张" + i, i + 20));
        }

        Path path = Paths.get("IOTest/teacher.obj");

        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path));
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            out.writeObject(new Teacher("ff",12));
            out.writeObject(list);
            Teacher teacher = (Teacher) in.readObject();
            System.out.println("teacher = " + teacher);
            List<Teacher> teachers = (List<Teacher>) in.readObject();
            System.out.println("teachers = " + teachers);
        }catch (IOException e){

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Teacher implements Serializable {

    private static final long serialVersionUID = 7185935978197112311L;
    private String name;
    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

