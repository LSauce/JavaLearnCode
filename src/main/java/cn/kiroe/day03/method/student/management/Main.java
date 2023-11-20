package cn.kiroe.day03.method.student.management;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /*
    通过键盘录入对应数字序号来实现选择功能。
    该菜单在实现某个功能后会重复出现，除非用户输入6来退出该系统。
    实现输出6来退出系统的功能。
     */
    public static void main(String[] args) {

        ArrayListD<Student> list = new ArrayListD<>();
        StudentManagement sm = new StudentManagement(list);
        StudentManagementMenu smm = StudentManagementMenu.getInstance();
        smm.operMenu(sm);
    }
}

class StudentManagementMenu {

    private static volatile StudentManagementMenu instance;



    //单例类： 加锁 懒汉模式
    public static StudentManagementMenu getInstance() {
        if (instance == null) {
            synchronized (StudentManagementMenu.class) {
                if (instance == null) {
                    instance = new StudentManagementMenu();
                }
            }
        }
        return instance;
    }

    public void showMenu() {
        System.out.println("---------王道Java学生管理系统---------");
        System.out.println("         1.学生列表");
        System.out.println("         2.增加学生");
        System.out.println("         3.删除学生");
        System.out.println("         4.修改学生");
        System.out.println("         5.查询学生");
        System.out.println("         6.退出学生");
    }

    public void operMenu(StudentManagement sm) {

        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            this.showMenu();

            System.out.print("请选择功能(1-6)：");
            int select = in.nextInt();

            switch (select) {
                case 1:
                    System.out.println("1.学生列表");
                    System.out.println(sm);
                    break;
                case 2:
                    System.out.println("2.增加学生");
                    System.out.println("请输入学生 姓名 年龄(张三 3)：");
                    String name = in.next();
                    int age = in.nextInt();
                    sm.add(name, age);
                    System.out.println(sm);
                    break;
                case 3:
                    System.out.println("3.删除学生");
                    System.out.println(sm);
                    System.out.println("请输入学生学号");
                    String id = in.next();
                    sm.remove(id);
                    System.out.println(sm);
                    break;
                case 4:
                    System.out.println("4.修改学生");
                    System.out.println("请输入修改学生学号");
                    String id2 = in.next();
                    System.out.println("请输入修改后的 姓名 年龄");
                    String name2 = in.next();
                    int age2 = in.nextInt();
                    sm.changeValue(id2, name2, age2);
                    System.out.println(sm);
                    break;
                case 5:
                    System.out.println("5.查询学生");
                    System.out.println("请输入学生学号");
                    String id3 = in.next();
                    System.out.println(sm.find(id3));
                    break;
                case 6:
                    System.out.println("确认退出吗（1/2）:");
                    int input = in.nextInt();
                    if (input == 1) {
                        System.out.println("感谢使用本系统！");
                        flag = false;
                        in.close();
                    } else {
                        System.out.println("回到菜单");
                    }
                    break;
                default:
                    System.out.println("请输入1-6");
            }

        }
    }


}

class StudentManagement {
    private ArrayListD<Student> list;

    public StudentManagement(ArrayListD<Student> list) {
        //获取数据源
        this.list = list;
    }

    // 增
    public boolean add(String name, int age) {
        String id = this.list.size() + "";
        Student student = new Student(id, name, age);
        return list.add(student);
    }

    // 删
    public boolean remove(String id) {
        return list.remove(new Student(id));
    }

    // 改
    public int changeValue(String id, String name, int age) {
        return list.changeValue(new Student(id), new Student(id, name, age));
    }

    // 查 ,只能通过id查
    public Student find(String id) {
        return list.get(list.indexOf(new Student(id)));
    }

    // 输出 所有数据
    @Override
    public String toString() {
        return this.list.toString();
    }
}


class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

/**
 * 简陋ArrayList
 * 通过new数值来新增长度
 */
class ArrayListD<E> {

    private Object[] arr;

    public ArrayListD(int size) {
        this.arr = new Object[size];
    }

    public ArrayListD(E[] arr) {
        this.arr = arr;

    }

    public ArrayListD() {
        this(0);
    }

    // 增
    public boolean add(E e) {
        Object[] arrT = new Object[arr.length + 1];

        for (int i = 0; i < this.arr.length; i++) {
            arrT[i] = this.arr[i];
        }
        arrT[arrT.length - 1] = e;
        this.arr = arrT;
        return true;
    }

    // 删
    public boolean remove(E e) {
        int index = indexOf(e);
        if (index >= 0) {
            this.arr[index] = null;
            return true;
        }
        return false;
    }

    // 改 ,修改第一个查到的
    public int changeValue(E e, E value) {
        int index = indexOf(e);
        if (index >= 0) {
            arr[index] = value;
            return index;
        }
        return -1;
    }

    // 查
    public int indexOf(E e) {
        int index = -1;
        if (arr != null && e != null) {
            for (int i = 0; i < this.arr.length; i++) {
                if (e.equals(arr[i])) {
                    return i;
                }
            }
        }

        return index;
    }

    public E get(int index) {
        if (index >= 0 && index < arr.length) {
            return (E) this.arr[index];
        }
        return null;
    }

    public int size() {
        return arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}



