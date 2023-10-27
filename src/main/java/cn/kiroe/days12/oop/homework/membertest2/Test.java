package cn.kiroe.days12.oop.homework.membertest2;

/**
 * @author kiro
 * @description:
 * @data 20:36 26/10/2023
 **/

/*

成员内部类题目：

定义一个外围类Car,在外围类中定义一个成员内部类Engine(发动机)。

Car类包含私有成员变量brand，price，model等。
然后提供构造器给成员变量赋值，以及一个成员方法startEngine()
，该方法创建一个Engine对象并调用其run()方法表示启动发动机。

成员内部类Engine当中提供一个run成员方法，要打印汽车的信息，并提示发动机已启动。

最后在一个测试类当中，创建Car对象，测试代码
 */
public class Test {

    public static void main(String[] args) {
        new Car("雅迪",2000,"电车").startEngine();
    }
}

class Car{
    //私有成员变量brand，price，model等。
    private String brand;
    private double price;
    private String model;

    public Car(String brand, double price, String model) {
        this.brand = brand;
        this.price = price;
        this.model = model;
    }

    public class Engine{
        public boolean run(){

            System.out.println("Car.this = " + Car.this);
            System.out.println("汽车已启动");
            return true;
        }
    }

    public boolean startEngine(){
        System.out.println("启动车中");
        new Engine().run();
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}
