package cn.kiroe.day08.homework;

import org.junit.Test;

/**
 * @author kiro
 * @description:
 * @data 19:41 20/10/2023
 **/
/*
当属性私有化，又有外界访问需求时，提供Getter/Setter方法
 创建两个类，分别用来表示长方形和正方形。
 同时定义所需的成员变量（边长），代表长方形或者正方形的边长
（私有化成员变量，并提供相应的Getter/Setter方法，获取以及改变长方形和正方形的边长。）
 然后在两个类中分别定义两个成员方法，用于求对应图形的面积和周长。
 最后，写代码测试一下创建对象，方法调用等。
注：Getter/Setter方法可以选择手写一个，其余的用快捷键自动生成。

该题是纯粹语法练习，不要浪费时间。
 */
public class PrivateEx {
    @Test
    public void privateExTest(){
        Rectangle rectangle = new Rectangle(1,2);
        System.out.println("rectangle = " + rectangle);
        System.out.println("rectangle.getArea() = " + rectangle.getArea());
        System.out.println("rectangle.getPerimeter() = " + rectangle.getPerimeter());
        Square square = new Square(5);
        System.out.println("square = " + square);
        System.out.println("square.getArea() = " + square.getArea());
        System.out.println("square.getPerimeter() = " + square.getPerimeter());

    }
}

class Rectangle {
    //成员变量（边长）
    private double width;
    private double heigh;

    public double getWidth() {
        return width;
    }

    public Rectangle() {
    }

    public Rectangle(double width, double heigh) {
        setWidth(width);
        setHeigh(heigh);
    }

    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        } else {
            System.out.println("边长需要大于等于0");
        }
    }

    public double getHeigh() {
        return heigh;
    }

    public void setHeigh(double heigh) {
        if (heigh >= 0) {
            this.heigh = heigh;
        } else {
            System.out.println("边长需要大于等于0");
        }
        this.heigh = heigh;
    }

    // 求对应图形的面积和周长。
    public double getArea() {
        return this.heigh * this.width;
    }

    // 求面积
    public double getPerimeter() {
        return (this.heigh + this.width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", heigh=" + heigh +
                '}';
    }
}

class Square extends Rectangle {


    public Square() {
    }

    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public double getSideLength() {
        return getWidth();
    }

    public void setSideLength(double sideLength) {
        if (sideLength >= 0) {
            super.setHeigh(sideLength);
            super.setWidth(sideLength);
        }
    }

    @Override
    public String toString() {
        return "Square{}"+ super.toString();
    }
}

