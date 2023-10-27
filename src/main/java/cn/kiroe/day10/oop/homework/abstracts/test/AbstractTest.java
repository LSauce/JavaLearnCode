package cn.kiroe.day10.oop.homework.abstracts.test;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 19:30 24/10/2023
 **/
/*
完成抽象类的基础语法练习，按照说明操作即可。
完成一个图案（Shape）的体系设计。先定义一个抽象类Shape类，然后通过继承来定义一些具体的形状类，如Rectangle和Circle。

抽象类Shape只需要给出两个抽象方法：求周长的抽象方法和求面积的抽象方法。

然后在具体的图案类型中给出计算周长和面积需要的参数作为成员变量（也就是在具体类中给出相关的成员变量，比如圆Circle类就需要半径radius作为成员变量）

最后在具体图案类型中重写抽象方法，实现求周长和求面积的方法。

完成以上类型代码后，可以测试一下。
 */
public class AbstractTest {
    @Test
    public void ShapeTest(){
        Shape rectagle = new Rectagle(10, 20);
        Shape circle  = new Circle(5);
        System.out.println("rectagle.getArea() = " + rectagle.getArea());
        System.out.println("rectagle.getPerimeter() = " + rectagle.getPerimeter());
        System.out.println("circle.getArea() = " + circle.getArea());
        System.out.println("circle.getPerimeter() = " + circle.getPerimeter());
    }
}

//完成一个图案（Shape）的体系设计。
// 先定义一个抽象类Shape类，
// 然后通过继承来定义一些具体的形状类，如Rectangle和Circle。
abstract class Shape {

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Rectagle extends Shape {

    private double width;
    private double heigh;

    public Rectagle(double width, double heigh) {
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    public double getArea() {
        return width * heigh;
    }

    @Override
    public double getPerimeter() {
        return (width + heigh) * 2;
    }
}

class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }
}