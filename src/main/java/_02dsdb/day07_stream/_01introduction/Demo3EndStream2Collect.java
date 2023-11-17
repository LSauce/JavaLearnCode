package _02dsdb.day07_stream._01introduction;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author kiro
 * @description:
 * @data 17:20 16/11/2023
 **/
/*
// Collectors.toList()
// Collectors.toCollection()
// Collectors.toSet()
// Collectors.toMap()
 */
public class Demo3EndStream2Collect {

    @Test
    public void testCollect1() {
        List<Student> studentList = new StudentList().studentList;
        // Collectors.toList()
        List<Student> collect = studentList.stream().filter(s1 -> Student.Address.WH.equals(s1.getAddress())).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testCollect2() {
        // 获得年龄 大于20的 同学
        List<Student> studentList = new StudentList().studentList;
        // // Collectors.toCollection()
        ArrayList<String> collect = studentList.stream().filter(s1 -> s1.getAge() > 20).map(Student::getName).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collect = " + collect);


    }

    @Test
    public void testCollect3() {
        // 身高180以上，都有了来自哪个城市
        List<Student> studentList = new StudentList().studentList;
        // Collectors.toSet()
        Set<Student.Address> collect = studentList.stream()
                .filter(s -> s.getHeight() > 180)
                .map(Student::getAddress)
                .collect(Collectors.toSet());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testCollect4() {
        // Collectors.toMap()
        // 想Map，key中是学生的名字，value是 学生的对象
        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        List<Student> studentList = new StudentList().studentList;
        for (Student student : studentList) {
            stringStudentHashMap.put(student.getName(), student);
        }
        System.out.println("stringStudentHashMap = " + stringStudentHashMap);
        //

    }

    // 想Map，key中是学生的名字，value是 学生的对象
    @Test
    public void testCollect5() {
        // Collectors.toMap()
        // 想Map，key中是学生的名字，value是 学生的对象
        List<Student> studentList = new StudentList().studentList;
        // 告诉key怎么生成，values 怎么生成
        Map<String, Student> collect = studentList.stream().collect(Collectors.toMap(Student::getName, student -> student));
        System.out.println("collect = " + collect);

    }

    @Test
    public void testCollect6(){
        // 数据重复了怎么办？
        // Collectors.toMap()
        // 想Map，key中是学生的名字，value是 学生的对象
        List<Student> studentList = new StudentList().studentList;
        // 告诉key怎么生成，values 怎么生成
        // 如果公司用流 ，用流，
// 同事用来 你再用
        Map<String, Student> collect = studentList.stream().collect(Collectors.toMap(Student::getName, student -> student, (t, t2) -> {
            // 这个是 存储值时
            System.out.println(t +"\n"+t2);

            return new Student("test",12,170, Student.Address.BJ);
        }));
        System.out.println("collect = " + collect);
    }

    @Test
    public void testToMap(){
        Integer[] integers = new Integer[]{1,2,3,4,5,6,3};
        Map<Integer, String > map = Arrays.stream(integers).collect(Collectors.toMap(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer;
            }
        }, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "s" + integer;
            }
        }, new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        }));

        System.out.println("map = " + map);
        // Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
        //                                     Function<? super T, ? extends U> valueMapper) {
        //         return toMap(keyMapper, valueMapper, throwingMerger(), HashMap::new);
        //     }


        //   Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
        //                                     Function<? super T, ? extends U> valueMapper,
        //                                     BinaryOperator<U> mergeFunction) {
        //         return toMap(keyMapper, valueMapper, mergeFunction, HashMap::new);
        //     }

    }

}
