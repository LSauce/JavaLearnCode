package cn.kiroe.day08._04extends._01introduce;

/**
 * @author kiro
 * @description:
 * @data 15:53 20/10/2023
 **/
/*
分别定义一个表示人和学生的类：

1. 人类：有姓名属性，以及吃饭这个行为
2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学两种行为
3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
 */


//          1. 人类：有姓名属性，以及吃饭这个行为
//        2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学两种行为
//        3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
class Person {
    String name;

    public void eat() {
        System.out.println("吃饭");
    }
}
class Teacher {
    String name;
    int id;

    public void teach() {

    }

    public void eat() {

    }
}

//        3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
class Student {
    String name;
    String id;

    public void eat() {

    }

    public void study() {

    }

}




