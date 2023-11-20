package _02dsdb.day01_generic._05generic1;

import _02dsdb.day01_generic._02normal.AutoCar;
import _02dsdb.day01_generic._02normal.Truck;

/**
 * @author kiro
 * @description:
 * @data 15:21 9/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Holder<Truck> holder = new Holder<>(new Truck("1",12));

        System.out.println("holder.getData() = " + holder.getData());
        Holder<AutoCar> car = new Holder<>(new AutoCar("2",32));
        System.out.println("car.getData() = " + car.getData());

        
    }
}
