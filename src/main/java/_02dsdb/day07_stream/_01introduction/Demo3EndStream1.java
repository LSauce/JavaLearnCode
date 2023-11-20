package _02dsdb.day07_stream._01introduction;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 * @author kiro
 * @description:
 * @data 15:52 16/11/2023
 **/
public class Demo3EndStream1 {
    @Test
    public void testAnyMatch1() {
        List<Student> studentList = new StudentList().studentList;
        long count = studentList.stream().filter(s -> Student.Address.BJ.equals(s.getAddress())).count();
        if (count > 0) {
            System.out.println("有bj的");
        }

        // 一个操作中， 有一个创建流，n个中间流，1个终止流
        // 所以调用了 终止操作，没生成新流
        boolean b = studentList.stream().anyMatch(s -> Student.Address.BJ.equals(s.getAddress()));
        if (b) {
            System.out.println("有bj的");
        }

        //  判断高于190的是否存在北京的同学
        boolean b1 = studentList.stream().filter(s -> s.getHeight() > 190).anyMatch(s -> Student.Address.BJ.equals(s.getAddress()));
        System.out.println("b1 = " + b1);
    }

    @Test
    public void testAllMatch() {
        // 所有都满足 才返回true
        // 比如 有10个元素，有9个 元素满足
        // 是否都是北京的同学
        List<Student> studentList = new StudentList().studentList;
        System.out.println("studentList.stream().allMatch(s -> Student.Address.BJ.equals(s.getAddress())) = " + studentList.stream().allMatch(s -> Student.Address.BJ.equals(s.getAddress())));
        // 判断高于200的 是不是都是上海的同学
        System.out.println("studentList.stream().filter(s -> s.getHeight()>200).allMatch() = " + studentList.stream().filter(s -> s.getHeight() > 200).allMatch(s -> Student.Address.SH.equals(s.getAddress())));

    }

    @Test
    public void testNonMatch() {
        // 代码中不要去 带反义的词
        List<Student> studentList = new StudentList().studentList;
        boolean b = studentList.stream().noneMatch(s -> s.getAge() > 18);
        System.out.println("b = " + b);
    }

    @Test
    public void testFindAny() {
        // 找到任意一个
        List<Student> studentList = new StudentList().studentList;
        Optional<Student> optional = studentList.stream().filter(s -> s.getAge() > 1000).findAny();
        // 假设流中没元素了，
        // 这时候能不能返回 null,流中 元素可能包括null，
        // 返回null 不能自动 是没元素了，还是返回为 null的元素
        // System.out.println("any.get() = " + any.get());
        // isPresent 为 ture代表 有元素，为false没元素
        System.out.println("optional.isPresent() = " + optional.isPresent());
        System.out.println(optional.get());// 没有元素 直接报错
        optional.ifPresent(System.out::println);


        // TODO: 注意, Optional作为一个容器代表一个值存在或者不存在
        // TODO: Optional中存在几个方法, 可以让使用者显式的检查值存在或者不存在
        // <1>: isPresent()方法:  如果 Optional包含值返回true, 否则返回false
        // <2>: ifPresent(代码块)方法: 会将Optional包含的值, 传给指定的代码块
        // <3>: get()方法: 如果Optional包含值, 返回包含的值, 否则抛出异常
        // <4>: orElse(默认值):  如果Optional包含值, 返回包含的值, 否则返回默认值

        // Optional 类表示的含义，JDK中用于 描述是否有数据的类


    }


    @Test
    public void OptionalTest() {
        // Optional 用于 判断是是否为 空元素（null也能是个元素）
        // 在 Optional中 当你设置为空时 ，会返回Optional<?> EMPTY = new Optional<>();常量
        Optional<Integer> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);
    }

    @Test
    public void testFinaAnyMatch() {
        // 多线程的 stream
        List<Student> studentList = new StudentList().studentList;
        Optional<Student> any = studentList.parallelStream().findAny();
        Optional<Student> findFirst = studentList.parallelStream().findFirst();
        System.out.println("any = " + any);
        System.out.println("findFirst = " + findFirst);
        // 在并行下， 有多个 线程来进行处理。findAny会返回 一条数据，这个数据是 哪个线程先处理完，就拿谁的第一个
        // findFirst 只拿第一个，多线程(并行流)下会 阻塞，等待完成

    }


    @Test
    public void testForeach() {
        List<Student> studentList = new StudentList().studentList;
        studentList.stream().sorted((s1, s2) -> s2.getAge() - s1.getAge()).forEach((s1) -> {
            System.out.println(s1.getAge());
        });
    }

    @Test
    public void testReduce() {
        // Hadoop hdfs 能
        // Reduce计算
        List<Student> studentList = new StudentList().studentList;
        // studentList.stream().reduce();
        // 获得 学生中 最大的年龄
        Optional<Student> reduce = studentList.stream().reduce(new BinaryOperator<Student>() {
            // 从左至右，进行操作获取值，只保存 获得返回的值，相当于 处理完左边的了，
            // 相当于 在对数据进行处理，获取想要的结果
            @Override
            public Student apply(Student student, Student student2) {
                return student.getAge() > student2.getAge() ? student : student2;
            }
        });
        reduce.ifPresent(System.out::println);

        Optional<Integer> reduce1 = studentList.stream().map(Student::getAge).reduce(Math::max);
        System.out.println("reduce1.orElseGet(null) = " + reduce1.orElseGet(null));
    }
    @Test
    public void testReduce2(){
        List<Student> studentList = new StudentList().studentList;
        Optional<Integer> reduce = studentList.stream().map(Student::getAge).reduce(Integer::sum);
        System.out.println("reduce.orElseGet(0) = " + reduce.get());
    }

    // TODO: 规约 reduce
//  <1>一参情况: Optional<T> reduce(BinaryOperator<T> accumulator)
//  <2>二参情况: T reduce(T identity, BinaryOperator<T> accumulator);

//  1参数:
//  返回值类型为Optional, 是应对如果流中没有任何元素情况(这种情况没有初始值就无法返回结果)
//  所以1参是把结果包裹在一个Optional对象里(可以通过get方法获取),用以表明/处理结果可能不存在情况

//  2参数:
//  BinaryOperator: 将两个元素合起来产生一个新值
//  identity: 计算的初始值/起始值(用来和第一个元素计算结果)
    @Test
    public void testReduce3(){
        List<Student> studentList = new StudentList().studentList;
        int sum = -11111111;
        Integer reduce = studentList.stream().map(Student::getAge).reduce(sum, Integer::sum);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void testReduce4(){
        List<Student> studentList = new StudentList().studentList;
        Optional<Integer> reduce = studentList.stream().map(Student::getAge).reduce(Math::max);
        System.out.println("reduce.orElseGet(null) = " + reduce.orElseGet(null));
    }

}
