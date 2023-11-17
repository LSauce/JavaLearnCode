package _02dsdb.day07_stream._01introduction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author kiro
 * @description:
 * @data 11:27 16/11/2023
 **/
/*
创建流的方式
1. 调用集合类的stream方法,生成一个流(最常用/常见)
 */
public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("1"));
        Stream<String> stream = list.stream();
        System.out.println("stream = " + stream.collect(Collectors.toList()));
        // 通过 值来创建
        Stream<Integer> integerStream = Stream.of(1, 2, 34, 5);
        System.out.println("integerStream = " + integerStream.collect(Collectors.toList()));
        // 通过数组创建
        Stream stream1 = Arrays.stream(new Integer[]{1, 2, 3, 5, 6});
        System.out.println("stream1.collect(Collectors.toList()) = " + stream1.collect(Collectors.toList()));
    }

    @Test
    public void testFilter1() {
        // 对元素进行过滤。比如想要某个地区的学生，比如想要年龄大于20的学生。
        List<Student> studentList = new StudentList().studentList;
        /*List<Student> collect = studentList.stream()
                .filter(student -> Student.Address.BJ.equals(student.getAddress()))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("collect.size() = " + collect.size());
*/
        // 现在我想的
        List<Student> collect1 = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).filter(student -> student.getHeight() > 170).collect(Collectors.toList());
        //System.out.println("collect1 = " + collect1);


        // 现在我想的
        List<Student> collect2 = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())&&student.getHeight() > 170).collect(Collectors.toList());
       // System.out.println("collect1 = " + collect2);

        //一定要 加注释
        // 写流的代码 可能 注释比代码长
    }




}
