package _02dsdb.day04_list_queue.homework.listwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 视图层 主页面
 */
enum MenuOption {
    DEL_MENU(1, "删除学生选项"), SHOW_MENU(2, "显示学生选项"), EXIT(3, "退出选项");
    final int value;
    final String info;

    MenuOption(int value, String info) {
        this.value = value;
        this.info = info;
    }
}

/**
 * @author kiro
 * @description:
 * @data 19:52 13/11/2023
 **/
/*
题目一：学生名单管理

假设你是一位老师，需要管理你班级的学生名单。
请编写一个程序，使用ArrayList来实现学生名单的管理，
包括添加学生、删除学生和显示学生名单。要求如下：

创建一个空的ArrayList对象来存储学生名单。
提示用户输入学生的姓名，并将其添加到学生名单中。
提供一个选项，允许用户从学生名单中删除某个学生。
提供一个选项，允许用户显示当前的学生名单。
提供一个选项，允许用户退出程序。
提示：使用Scanner类来接收用户输入。
 */
public class ArrayListWork4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 使用简单MVC

        // 提供一个选项，允许用户从学生名单中删除某个学生。
        // 提供一个选项，允许用户显示当前的学生名单。
        // 提供一个选项，允许用户退出程序。
        StudentManagementView.mainMenu();
    }


}

class StudentManagementView {
    // 提供一个选项，允许用户退出程序。
    public static void mainMenu() throws CloneNotSupportedException {
        StudentDao dao = new StudentDao();

        while (true) {
            int i = StudentManagementComponents.mainMenu();
            if (i == MenuOption.DEL_MENU.value) {
                int id = StudentManagementComponents.delStudentMenu(dao.getStudentInfo());
                Student student = dao.deleteStudentById(id);
                if (student == null) {
                    System.out.println("删除失败");
                } else {
                    System.out.println("删除成功 " + student);
                }
            } else if (i == MenuOption.SHOW_MENU.value) {
                StudentManagementComponents.showStudentInfo(dao.getStudentInfo());
            } else if (i == MenuOption.EXIT.value) {
                System.out.println("程序退出中");
                break;
            } else {
                System.out.println("请输入1-3");
            }

        }

    }
}

/**
 * 视图层 组件，用于交互
 */
class StudentManagementComponents {

    public static void header() {
        String header = "\n---学生管理系统---";
        System.out.println(header);
    }

    public static int mainMenu() {
        header();
        String menuString =
                "\n 1. 删除学生" +
                        "\n 2. 显示当前学生" +
                        "\n 3. 退出";
        System.out.println(menuString);
        System.out.println("请输入操作");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next();
        return Integer.parseInt(i);
    }

    // 提供一个选项，允许用户从学生名单中删除某个学生。
    public static int delStudentMenu(Student[] studentArray) {
        header();
        String menuString =
                "---学生删除---";
        showStudentInfo(studentArray);
        System.out.println(menuString);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除学生的 id");
        int input = Integer.parseInt(scanner.next());
        return input;
    }

    // 提供一个选项，允许用户显示当前的学生名单。
    public static void showStudentInfo(Student[] studentArray) {
        String head = "---学生显示页面---";
        System.out.println(head);
        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }
    }

}


// 操控数据层
class StudentDao {
    private List<Student> studentList = StudentDataSource.data;

    // 提供一个选项，允许用户从学生名单中删除某个学生。
    public Student deleteStudentById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.remove(i);
            }
        }
        return null;
    }

    // 提供一个选项，允许用户显示当前的学生名单。
    public Student[] getStudentInfo() throws CloneNotSupportedException {
        // 深拷贝；
        Student[] students = new Student[studentList.size()];
        for (int i = 0; i < students.length; i++) {
            // 浅拷贝
            students[i] = (Student) studentList.get(i).clone();
        }
        return students;
    }

    static class StudentDataSource {
        private static List<Student> data = new ArrayList<Student>();

        static {
            initData();
        }

        static void initData() {
            data.add(new Student("zs", 12));
            data.add(new Student("zs1", 13));
            data.add(new Student("zs2", 14));
            data.add(new Student("zs3", 15));
            data.add(new Student("zs4", 16));
            data.add(new Student("zs5", 17));
            data.add(new Student("zs6", 18));
        }


    }


}


class Student implements Cloneable {
    private static int initId = 10001;
    private int id;
    private String name;
    private int age;

    private Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = initId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Student(this.getId(), this.name, this.age);
    }
}



