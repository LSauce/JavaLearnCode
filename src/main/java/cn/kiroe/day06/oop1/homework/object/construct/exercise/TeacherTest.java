package cn.kiroe.day06.oop1.homework.object.construct.exercise;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 15:05 18/10/2023
 **/
public class TeacherTest {
    /*
    * 要求t1对象的四个成员变量name, age, gender, teacherId的值分别为"张三"、18、"男"、 1

要求t2对象的四个成员变量name, age, gender, teacherId的值分别为"李四"、25、"女"、 2
    * */
    @Test
    public void teacherTest(){
        Teacher t1 = new Teacher("张三",18,"男",1);
        Teacher t2 = new Teacher("李四", 25, "女", 2);

        t1.print();
        t2.print();
    }
}
