package cn.kiroe.day08._03encapsulate._01introduce;

/**
 * @author kiro
 * @description:
 * @data 15:00 20/10/2023
 **/

/*
1. 把属性 私有化 --》 不能直接访问
2. 提供访问路口--> get()方法
3. 提供修改路口 --》 set()方法
 */
public class Demo {
    public static void main(String[] args) {
        Student student = new Student("zs", 202, 100);

        System.out.println("student = " + student);
        System.out.println("student.getAge() = " + student.getAge());

        String name = "fffff";
        String name2 = name;
        name2 = name2 + 2; // 当拼接字符会 重新 新建对象
        System.out.println(name);
    }
}

class Student{
    private String name;
    private int age = -1;
    private int score;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.setAge(age);
        this.score = score;
    }
    public int getAge(){
        return this.age;
    }
    //this： 是在 方法前有 隐式传参
    public void setAge(int age){

        if( age > 0 && age<100){
            this.age = age;
        }else {
            System.out.println("年龄不合法");
        }
    }

    public Student getThis(){
        return this;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    // 代码逻辑
    // 整理思路 - 书写大概路程
    // 编写代码 - 并调整细节和思路正确性
    // 构建计算机 思维
    //
}
