package _02dsdb.day02_collection.homework.collectionwork;

/*
// 1.存储一组学生。包括 姓名 年龄，总分，入学日期
// 2.找出总分最高的学生？
// 3.找出总分最低的学生
// 4.求平均分
// 5.删除低于平均分的学生
// 6.找出2年内入学的学生。
// 7.需要删除叫张三的学生
// 8.删除年龄小于18的学生
 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Work {

    private static List<Student> list = new LinkedList<Student>();

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static void initStudentList() throws ParseException {
        list.add(new Student("张三", 12, 90, simpleDateFormat.parse("2023-11-1")));
        list.add(new Student("zs1", 22, 80, simpleDateFormat.parse("2021-11-1")));
        list.add(new Student("zs2", 32, 70, simpleDateFormat.parse("2022-11-1")));
        list.add(new Student("zs3", 14, 60, simpleDateFormat.parse("2023-11-1")));
        list.add(new Student("zs4", 13, 50, simpleDateFormat.parse("2021-11-1")));
        list.add(new Student("zs5", 13, 40, simpleDateFormat.parse("2022-11-1")));
        list.add(new Student("zs6", 12, 10, simpleDateFormat.parse("2023-11-1")));
        list.add(new Student("zs7", 15, 58, simpleDateFormat.parse("2021-11-1")));
        list.add(new Student("zs8", 12, 67, simpleDateFormat.parse("2022-11-1")));
        list.add(new Student("zs9", 17, 87, simpleDateFormat.parse("2023-11-1")));
    }

    public static void main(String[] args) throws ParseException {
        // 1.存储一组学生。包括 姓名 年龄，总分，入学日期
        initStudentList();
        // 2.找出总分最高的学生？
        System.out.println("list.get(1) = " + list.get(1));
        Student maxScoreStudent = getMaxScoreStudent();
        System.out.println("分数最大的学生是：" + maxScoreStudent);
        // 3.找出总分最低的学生
        System.out.println("分数最小的学生是：" + getMinScoreStudent());
        // 4.求平均分
        double average = getAverageScore();
        System.out.println("平均分为:" + average);
        // 5.删除低于平均分的学生
        boolean isDeleted = delLower(average);
        System.out.println("删除低于平均分的 list = " + list);
        // 6.找出2年内入学的学生。
        List<Student> find = findStudentLargerTheDate(simpleDateFormat.parse("2021-1-1"));
        System.out.println("找出2年内入学的学生。 find = " + find);
        // 7.需要删除叫张三的学生
        boolean isDeletedByName = removeByName("张三");
        System.out.println("需要删除叫张三的学生 : isDeletedTheStudent = " + list);
        // 8.删除年龄小于18的学生
        boolean isDeletedByAge = del(new Student("", 18, average,
                null), (o1, o2) -> {
                    if(o1.age != o2.age){
                        return o1.age - o2.age;
                    }else {
                        return (int) (o1.score - o2.score);
                    }

                });

        System.out.println("删除年龄小于18的学生: "+ list);


    }

    private static boolean del(Student benchmark, Comparator<Student> comparator) {
        if (comparator == null) {
            return false;
        }

        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (comparator.compare(benchmark, student) > 0) {
                students.add(student);

                // 不能直接remove,因为remove会整体移动数组,
                // modCount 记录迭代器创建时该列表的结构被修改的次数。如果在迭代的过程中 modCount更改，将抛出异常
                // 可使用 迭代器只带的 remove方法进行 删除

            }
        }
        list.removeAll(students);
        return true;
    }

    private static boolean removeByName(String name) {
        if (name == null) {
            return false;
        }
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (name.equals(student.name)) {
                students.add(student);
            }
        }
        list.removeAll(students);
        return true;
    }

    private static List<Student> findStudentLargerTheDate(Date parse) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.enrollmentTime.compareTo(parse) > 0) {
                students.add(student);
            }
        }
        return students;
    }

    private static boolean delLower(double average) {
        if (list.size() == 0) {
            return false;
        }

        // 储存小于 平均分的
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.score < average) {
                students.add(student);
            }
        }
        list.remove(students);
        return true;
    }

    private static double getAverageScore() {
        double sum = 0;
        for (Student student : list) {
            sum += student.score;
        }
        return sum / list.size();
    }

    private static Student getMaxScoreStudent() {
        Student maxScoreStudent = null;
        double score = 0;
        for (Student student : list) {
            if (student.score > score) {
                score = student.score;
                maxScoreStudent = student;
            }
        }
        return maxScoreStudent;
    }

    private static Student getMinScoreStudent() {
        Student minScoreStudent = null;
        double score = Double.MAX_VALUE;
        for (Student student : list) {
            if (student.score < score) {
                score = student.score;
                minScoreStudent = student;
            }
        }
        return minScoreStudent;
    }
}

// 学生。包括 姓名 年龄，总分，入学日期
class Student {

    String name;
    int age;
    double score;
    Date enrollmentTime;

    public Student(String name, int age, double score, Date enrollmentTime) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.enrollmentTime = enrollmentTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", enrollmentTime=" + enrollmentTime +
                '}';
    }
}



