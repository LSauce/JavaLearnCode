package cn.kiroe.day08._02access._01usecase;

/**
 * @author kiro
 * @description:
 * @data 11:26 20/10/2023
 **/
public class LimitObjectNumberTest {

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println("Student.getInstance("+i+ ") = " + Student.getInstance("" + i));
        }
    }
}

//限定 只能最多创建 10个对象
class Student{

    private String name;
    private  int id;

    private static int count = 0;
    {
        count++;
    }
    public Student(String name) {
        this.name = name;
    }

    public static Student getInstance(String name){
        if (Student.count<10){
            return new Student(name);
        }

        return null;
    }

}