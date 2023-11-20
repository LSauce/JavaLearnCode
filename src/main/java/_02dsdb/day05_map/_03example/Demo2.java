package _02dsdb.day05_map._03example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 11:13 14/11/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        // 班级里有一些学生，我想根据省份进行分组，应该怎么做？
        HashMap<String, List<Student>> map = new HashMap<>();
        for (Student generateStudent : generateStudents()) {
            List<Student> orDefault = map.getOrDefault(generateStudent.getProvince(), new ArrayList<>());
            orDefault.add(generateStudent);
            map.put(generateStudent.getProvince(),orDefault);
        }
        System.out.println(map);


    }

    private static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();

        List<String> provinceList = Arrays.asList("hubei", "hunan", "guangdong");

        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setName("student" + i);
            student.setAge(15);
            // 从省份的list中，获取出一个省份，设置到学生上
            String province = provinceList.get(i % 3);
            student.setProvince(province);

            students.add(student);
        }

        return students;
    }

    static class Student {
        String name;
        int age;
        String province;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getProvince() {
            return province;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", province='" + province + '\'' +
                    '}';
        }
    }
}


