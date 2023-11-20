package _02dsdb.day02_collection._04collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * //    ---------------------------------方便遍历方法---------------------------------
 * //    Object[] toArray(): 将collection转成一个数组，方便遍历
 * //    <T> T[] toArray(T[] a)：类似，只是传入了一个数组
 * //    Iterator<E> iterator()：返回一个迭代器
 */
public class Demo4 {

    public static void main(String[] args) {
//    ---------------------------------方便遍历方法---------------------------------
//    Object[] toArray(): 将collection转成一个数组，方便遍历
//    <T> T[] toArray(T[] a)：类似，只是传入了一个数组
//    Iterator<E> iterator()：返回一个迭代器
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(integers.toArray() instanceof Integer[]);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("zs", 1));
        students.add(new Student("zs", 1));
        students.add(new Student("zs", 1));
        students.add(new Student("zs", 1));

        // 异常
//        Student[] array = students.toArray(new Integer[10]);
        Student[] array = students.toArray(new Student[10]);
        Object[] array2 = array;
        System.out.println("array2.length = " + array2.length);

        System.out.println("array = " + Arrays.toString(array));
        // System.out.println("toArray的情况,当传入的数组长度 打印");

        Object[] array1 = students.toArray();
        System.out.println("array1.getClass() = " + array1.getClass());

//        Student[] ss = (Student[]) array1;
//        System.out.println("ss = " + ss);
//        System.out.println(true);
        

    }
}
