package cn.kiroe.day11.oop07._03link;

/**
 * @author kiro
 * @description:
 * @data 10:03 26/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        Student sd= new Student();
        Student s = sd.getStudent();
        Teacher teacher = s.getTeacher();
        teacher.show();

        new Student().getStudent().getStudent().getStudent().getStudent().getStudent()
                .getStudent().getStudent().getStudent().getTeacher().show();
    }
}

class Student{

    public Student getStudent(){
        return new Student();
    }

    public Teacher getTeacher(){
        return new Teacher();
    }
}
class Teacher{
    public void show(){
        System.out.println("秀一波~~~");
    }
}
