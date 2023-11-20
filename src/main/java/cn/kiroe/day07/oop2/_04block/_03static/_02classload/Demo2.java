package cn.kiroe.day07.oop2._04block._03static._02classload;

/**
 * @author kiro
 * @description:
 * @data 17:37 19/10/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("tt", new Subject());
        // "string" -->  0xffff
    }
}

class Teacher{
    String name;
    // 科目：
    Subject subject;

    public Teacher(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }
}

class Subject{
    String subjectName = "Math";
}
