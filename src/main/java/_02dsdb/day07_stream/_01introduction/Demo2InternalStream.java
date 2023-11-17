package _02dsdb.day07_stream._01introduction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kiro
 * @description:
 * @data 11:31 16/11/2023
 **/
/*
## 中间操作

两个简单的中止操作：

count(): 流里面有多少元素，最终会返回Long类型。

collect(Collectors.toList())： 将流里面的元素，存储为一个List;
 */
public class Demo2InternalStream {
    public static void main(String[] args) {
        List<Student> studentList = new StudentList().studentList;
        System.out.println("studentList.stream().collect(Collectors.toList()) = " + studentList.stream().collect(Collectors.toList()));
        System.out.println("studentList.stream().count() = " + studentList.stream().count());
    }

    @Test
    public void test4() {
        List<Student> studentList = new StudentList().studentList;
        List<Student> collect = studentList.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return true;
            }
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testDistinct1() {
        List<Student> studentList = new StudentList().studentList;
        System.out.println("studentList.stream().count() = " + studentList.stream().count());
        // distinct 去重用的 LinkedHashSet，和 插入顺序一样
        System.out.println("studentList.stream().distinct() = " + studentList.stream().distinct().count());

    }

    @Test
    public void testDistinct2() {
        List<Student> studentList = new StudentList().studentList;
        List<Student> bjDistinctStudentList = studentList.stream().filter(t -> Student.Address.BJ.equals(t.getAddress())).distinct().collect(Collectors.toList());
        System.out.println("collect = " + bjDistinctStudentList);
        System.out.println("bjDistinctStudentList.size() = " + bjDistinctStudentList.size());
    }

    @Test
    public void testLimit() {
        // limit 代表最大的 返回树目
        // 如果过大于 截取
        // 如果 小于 返回 小于的长度
        List<Student> studentList = new StudentList().studentList;
        // 获取身高高于170的
        List<Student> collect = studentList.stream().filter(s -> s.getHeight() > 170).limit(3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("collect.size() = " + collect.size());

        System.out.println("=======");

        List<Student> collect1 = studentList.stream().filter(s -> s.getHeight() >= 210).limit(3).collect(Collectors.toList());
        System.out.println("collect = " + collect1);
        System.out.println("collect.size() = " + collect1.size());
    }


    @Test
    public void testSkip() {
        // ### skip(跳过)
        // skip(n)方法, 跳过前n个元素
        // // Stream<T> skip(long n);
        // // skip(n)方法, 跳过前n个元素, 返回之后的元素.  (如果整体不够n个, 返回空流)
        List<Student> studentList = new StudentList().studentList;
        // 如果是 对同一个属性，建议放在 同一个 filter中
        List<Student> collect = studentList.stream().filter(s -> s.getAge() > 22 && s.getAge() < 25).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("collect.size() = " + collect.size());// 4

        List<Student> collect2 = studentList.stream().filter(s -> s.getAge() > 22 && s.getAge() < 25).skip(2).collect(Collectors.toList());
        System.out.println("collect = " + collect2);
        System.out.println("collect.size() = " + collect2.size());// 2
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> integerPredicate = i -> i < 10;
        Predicate<Integer> integerPredicate1 = i -> i > 2;
        Predicate<Integer> rule = integerPredicate.and(integerPredicate1);
        System.out.println("rule.test(10000) = " + rule.test(8));

    }

    @Test
    public void testMap1() {
        // 获取所有学生姓名
        // map 方法用于映射每个元素到对应的结果。
        //
        // 从一个类型转换到另外一种类型。或者不变化类型
        List<Student> studentList = new StudentList().studentList;
        // 获取名字
        // 传统方式
        ArrayList<String> studentNameList = new ArrayList<>();
        for (Student student : studentList) {
            studentNameList.add(student.getName());
        }
        System.out.println("strings = " + studentNameList);
        List<String> collect = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testMap3() {
        // 获取班级名字的字母
        List<Student> studentList = new StudentList().studentList;
        List<Character> collect = studentList.stream()
                // 需要两个 泛型 输入泛型与 输出泛型
                .map(s -> s.getName().charAt(0))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testMap4() {
        // 获取非常高的学生（超过190） 返回巨人这个类
        List<Student> studentList = new StudentList().studentList;
        studentList.stream().filter(s -> s.getHeight() > 190)
                .map(s -> new SuperPerson(s.getName(), s.getHeight()))
                .forEach(System.out::println);
        // System.out.println("collect = " + collect);

        // 只需要人是什么类型的
        // 超高人，高人，普通人
        // [190, +无穷), [175, 190) , (-无穷, 175]
    }

    @Test
    public void testMap5() {
        ArrayList<String> letterList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            letterList.add((char) ('a' + i) + "");
        }
        letterList.stream().map(s -> s + s).forEach(System.out::println);
    }

    @Test
    public void testSorted() {
        // Comparable Comparator
        List<Student> studentList = new StudentList().studentList;
        Stream<Student> sortedStream = studentList.stream().sorted(
                (s1, s2) -> s1.getAge() - s2.getAge()
        );
        List<Student> collect = sortedStream.collect(Collectors.toList());
        System.out.println("collect = " + collect);


        // List<Student> collect = sortedStream.collect(Collectors.toList());

        // System.out.println("sorted = " + sorted.collect(Collectors.toList()));
    }

    @Test
    public void filterTest() {
        List<Student> studentList = new StudentList().studentList;
        Predicate<Student> predicate = (s) -> s.getAge() > 21;

        List<Student> collect = studentList.stream()
                .filter(predicate.and((s) -> s.getAge() < 23))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
    // name
    public Predicate<Student> getPredicate() {
        Predicate<Student> predicate = (s) -> s.getAge() > 21;
        return predicate;

    }
    // age
    public Predicate<Student> getPredicate2() {
        Predicate<Student> predicate = (s) -> s.getAge() > 21;
        return predicate.and(predicate);

    }

}

class SuperPerson {
    String name;
    int height;

    public SuperPerson(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "SuperPerson{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
