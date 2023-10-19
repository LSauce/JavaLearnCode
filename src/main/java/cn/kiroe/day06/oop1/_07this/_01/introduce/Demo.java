package cn.kiroe.day06.oop1._07this._01.introduce;

import cn.kiroe.day04.homework.CourseCode;

import java.util.Spliterator;

/**
 * @author kiro
 * @description:
 * @data 10:18 18/10/2023
 **/
public class Demo {
    /*

    学习完对象与类后，做以下练习：

> 创建一个汽车类，有颜色（color）和速度（speed）两个属性，行为是可以跑（run）。
>
> 实现：
>
> 1. 在run成员方法中访问速度和颜色两个属性，调用该方法查看结果。
> 2. 在run成员方法的形参列表中，添加一个局部变量speed，不修改方法体，调用该方法查看结果。
>
> 思考：
>
> 1. 两次方法调用的结果一样吗？为什么？
> 2. 如果我想在2中得到1的访问结果，怎么办呢？

     */
    public static void main(String[] args) {
        Car car = new Car();
        car.setSpeed(200);
        car.run(100);
        // System.out.println(1/0);
        Class o = Vehicle.class;//获取方法区中 类的加载

        System.out.println(o);

    }
}
class Vehicle{
    public Vehicle(String name) {
        System.out.println(name);
    }
}
//创建一个汽车类，有颜色（color）和速度（speed）两个属性，行为是可以跑（run）。
class  Car extends Vehicle{
    private String color;
    private int speed;
    //static 中 没有this
    public static void  fff(){

    }

    //this 的本质是：编译器在调用某个实例方法时，实际上会把当前的实例对象的引用作为第一个参数传递给方法。
    //在形参的列表中有 隐含的 this
    public void  run(int speed){
        // 就近原则：
        //  访问同名的局部变量
        // 加this 访问 this.speed
        System.out.println("speed = " + speed);
        System.out.println("speed = " + this.speed);
    }
    //构造方法栈帧 <init>
    public Car() {
        this("222",2);//必须放第一行
        System.out.println("test");
    }

    public Car(String color, int speed) {
        //super 的本质是： invokespecial 指令。
        //invokespecial 指令的主要作用是，用于调用一些需要特殊处理的实例方法，包括实例初始化方法、私有方法和父类方法。
        super("test");
        this.color = color;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
