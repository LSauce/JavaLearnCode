package _02dsdb.day01_generic._02normal;

/**
 * @author kiro
 * @description:
 * @data 15:02 9/11/2023
 **/
public class Truck extends AutoCar{
    public Truck(String name, double price) {
        super(name, price);
    }

    @Override
    public void run() {
        System.out.println("我是卡车，slow slow slow ");
    }
}
