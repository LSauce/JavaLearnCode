package _02dsdb.day05_map._03example;

import java.util.*;

enum ScoreRank {
    // 差，良，优秀
    // [0,60), [60,80), [80,100]
    Test(0, 40, "TestR"),
    BAD(40, 60, "差"),
    NORMAL(60, 80, "良"),
    GOOD(80, 101, "优"),
    ERROR(-1,-1,"错误");
    // 左闭右开
    int min;
    int max;
    String info;
    public static ScoreRank getRank(int score){
        for (ScoreRank value : values()) {
            if(score >= value.min && score < value.max){
                return value;
            }
        }
        return ERROR;
    }



    ScoreRank(int min, int max, String info) {
        this.min = min;
        this.max = max;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ScoreRank{" +
                "min=" + min +
                ", max=" + max +
                ", info='" + info + '\'' +
                '}';
    }
}

/**
 * @author kiro
 * @description:
 * @data 14:33 14/11/2023
 **/
/*
一个班级的，语文分按照 [0,60), [60,80), [80,100]
分三个层级 差，良，优秀。
怎么统计每个层级的人数？(抽方法有什好处)
 */
public class Demo4 {
    public static void main(String[] args) {
        //ScoreRank.valueOf("");// 通过变量名 返回对应对象,无报错
        //System.out.println("ScoreRank.valueOf(\"BAD\") = " + ScoreRank.valueOf("BAD"));
        ArrayList<Student> students = new ArrayList<>();
        initStudent(students);
        // 使用 分数 分组
        Map<ScoreRank, List<Student>> map = new HashMap<>();

        for (Student student : students) {
            ScoreRank rank = ScoreRank.getRank(student.score);
            List<Student> list = map.getOrDefault(rank, new ArrayList<>());
            list.add(student);
            map.put(rank,list);
        }

        System.out.println("map = " + map);
        for (Map.Entry<ScoreRank, List<Student>> scoreRankListEntry : map.entrySet()) {
            System.out.println("scoreRankListEntry = " + scoreRankListEntry);
        }

    }

    public static void initStudent(List<Student> list){
        list.add(new Student("1",10));
        list.add(new Student("2",20));
        list.add(new Student("3",30));
        list.add(new Student("4",40));
        list.add(new Student("5",50));
        list.add(new Student("6",60));
        list.add(new Student("7",70));
        list.add(new Student("8",90));
        list.add(new Student("9",100));
        list.add(new Student("10",80));
    }
}

class Student {
    String name;

    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }
}
