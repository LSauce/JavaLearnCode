package _02dsdb.day01_generic._02normal;

/**
 * @author kiro
 * @description:
 * @data 14:47 9/11/2023
 **/

/*
**背景条件**

- 汽车类
- 汽车的车库(主要用于存放车)。还提供一个方法获取汽车
 */
public class AutoCar {

    String name;
    double price;

    public AutoCar(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void run(){
        System.out.println("run run run run ");
    }

    @Override
    public String toString() {
        return "AutoCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
