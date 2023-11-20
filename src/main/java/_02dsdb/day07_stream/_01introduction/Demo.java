package _02dsdb.day07_stream._01introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kiro
 * @description:
 * @data 10:59 16/11/2023
 **/
public class Demo {
    public static void main(String[] args) {
        // 我们要对这个学生列表进行处理:  <span style="color:red">得到来自北京同学, 并且高度最高的三个同学</span>
        List<Student> studentList = new StudentList().studentList;
        // 流的代码 写起来简便
        List<Student> beijingStudentList = studentList.stream()
                .filter((s) -> s.getAddress().equals(Student.Address.BJ) )
                .sorted((s1, s2) -> s2.getHeight() - s1.getHeight())
                .limit(3).collect(Collectors.toList());
        System.out.println("collect = " + beijingStudentList);


    }
}
/*
准备数据
 */

