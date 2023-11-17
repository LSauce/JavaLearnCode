package _02dsdb.day06_map.homework;

import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 14:26 15/11/2023
 **/
/*
// 一组学生数据，学生信息里有以下信息。
// (id, name, age, teacher_id)

// 一组班主任数据，有以下信息
// (id, name, age)

// 我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
// 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
// 提供两份数据：
// List<Teacher> teachers = new ArrayList<>();
// List<Student> students = new ArrayList<>();

class Grade{
Teacher teacher;
List<Student> students;
}
 */

public class Work2 {
    /// 我们这样认为：一个老师对应n个学生，一个学生只对应一个老师。
    // // 现在需求方需要一个数据，需要返回 班主任的信息，然后和对应班级同学的信息。
    // // 提供两份数据：
    // // List<Teacher> teachers = new ArrayList<>();
    // // List<Student> students = new ArrayList<>();
    public static void initInfo(List<Teacher> teachers, List<Student> students) {
        teachers.add(new Teacher(1, "t1", 12));
        teachers.add(new Teacher(2, "t2", 13));
        teachers.add(new Teacher(3, "t3", 14));
        students.add( new Student(1, "s1", 1));
        students.add( new Student(2, "s2", 1));
        students.add( new Student(3, "s3", 1));
        students.add( new Student(4, "s4", 2));
        students.add( new Student(5, "s5", 2));
        students.add( new Student(6, "s6", 2));
        students.add( new Student(7, "s7", 2));
        students.add( new Student(8, "s8", 2));
        students.add( new Student(9, "s9", 3));
        students.add( new Student(10, "s10", 3));
        students.add( new Student(11, "s11", 3));
        students.add( new Student(12, "s12", 3));
        for (int i = 13; i < 20; i++) {
            students.add(new Student(i,"s"+i,i%3+1));
        }
    }

    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        initInfo(teachers, students);
        // 获得分组
        Map<Integer,Teacher> teacherMap = new HashMap<>(teachers.size());
        for (Teacher teacher : teachers) {
            teacherMap.put(teacher.id,teacher);
        }
        Map<Integer,List<Student>> grouped = groupStudentByTeacherId(students);
        // 获取分类列表
        ArrayList<Grade> grades = new ArrayList<>();
        for (Map.Entry<Integer, List<Student>> entry : grouped.entrySet()) {
            Integer teacherId = entry.getKey();
            List<Student> studentList = entry.getValue();
            grades.add(new Grade(teacherMap.get(teacherId),studentList));
        }
        System.out.println("grades.size() = " + grades.size());
        System.out.println("grades = " + grades);
    }



    private static Map<Integer, List<Student>> groupStudentByTeacherId(List<Student> students) {
        if(students == null){
            return null;
        }
        HashMap<Integer, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            List<Student> list = map.getOrDefault(student.teacherId, new ArrayList<>());
            list.add(student);
            map.put(student.teacherId,list);
        }

        return map;
    }
}

class Grade {
    Teacher teacher;
    List<Student> students;

    public Grade(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}

// // 一组班主任数据，有以下信息
// // (id, name, age)
class Teacher {
    int id;
    String name;
    int age;

    public Teacher(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

// // (id, name, age, teacher_id)
class Student {
    int id;
    String name;
    int teacherId;

    public Student(int id, String name, int teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
