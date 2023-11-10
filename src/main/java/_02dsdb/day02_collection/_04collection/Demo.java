package _02dsdb.day02_collection._04collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/*
//    ---------------------------------增删改查方法---------------------------------
// 需要熟练使用，清楚特点。
//    boolean add(E e): 添加一个元素进入Collection
//    boolean addAll(Collection<? extends E> c): 添加一个Collection进目标Collection
//    boolean remove(Object o)： 删除元素， 只删除第一个出现的(如果存在多个)
//    boolean removeAll(Collection<?> c)： 删除Collection中的所有存在的元素,会全部删除，如果存在多个
//    boolean contains(Object o)： 判断是否存在指定元素
//    boolean containsAll(Collection<?> c)： 判断给定的collection中是否全部存在于目标Collection
//    boolean retainAll(Collection<?> c)： 将原有collection只保留传入的collection。

/

 */
public class Demo {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>(Arrays.asList(new String[]{"dfdsf", "1", "dfdsf", "1", "dfdsf", "1"}));
        //    ---------------------------------增删改查方法---------------------------------
// 需要熟练使用，清楚特点。
//    boolean add(E e): 添加一个元素进入Collection
        strings.add("test");
//    boolean addAll(Collection<? extends E> c): 添加一个Collection进目标Collection
        boolean b = strings.addAll(Arrays.asList(new String[]{"test3"}));
        System.out.println("strings = " + strings);
        // boolean remove(Object o)： 删除元素， 只删除第一个出现的(如果存在多个)
        // 非 null 使用equal，
        strings.remove("1");
        System.out.println("strings = " + strings);
//    boolean removeAll(Collection<?> c)： 删除Collection中的所有存在的元素,会全部删除，如果存在多个
        // 差集
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        // integers.removeAll(Arrays.asList(1,25,6,7,8));
        System.out.println("integers = " + integers);
//    boolean retainAll(Collection<?> c)： 将原有collection只保留传入的collection。
        // 交集
        integers.retainAll(Arrays.asList(1,2,3,4,5,6));
        System.out.println("integers = " + integers);
//    boolean contains(Object o)： 判断是否存在指定元素
        System.out.println("integers.contains(3) = " + integers.contains(3));
//    boolean containsAll(Collection<?> c)： 判断给定的collection中是否全部存在于目标Collection
        System.out.println("integers.contains(Arrays.asList(1,2,3,4,5,6)) = " + integers.containsAll(Arrays.asList(1,2)));


        // 集合中 怎么判断 一个元素和 另一个元素是相等的
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("zs",12));
        students.add(new Student("z2s",13));
        students.add(new Student("z2s",14));
        students.add(new Student("z2s",152));
        students.add(new Student("z3s",15));

        System.out.println("students.contains(new Student(\"z2s\",13)) = " + students.contains(new Student("z2s", 13)));

        System.out.println("students.remove(new Student(\"z2s\",14)) = " + students.remove(new Student("z2s", 14)));
        System.out.println("students = " + students);

    }


}

class Student{
    String name;
    int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
