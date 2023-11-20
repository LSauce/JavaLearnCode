package _02dsdb.day01_generic._02normal;

/**
 * @author kiro
 * @description:
 * @data 14:46 9/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // 存放车
        AutoCar c1 = new AutoCar("c1", 100);
        AutoCarHolder autoCarHolder = new AutoCarHolder(10);
        autoCarHolder.addCar(c1);
        autoCarHolder.addCar(c1);
        autoCarHolder.addCar(c1);
        AutoCar car = autoCarHolder.getCar(2);
        AutoCar car2 = autoCarHolder.getCar(1);
        AutoCar truck = new Truck("truck", 3);
        autoCarHolder.addCar(truck);
        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);
        System.out.println("truck = " + autoCarHolder.getCar(3) );
        // 多态
        car.run();
        truck.run();

        // 如果要使用 父类想使用 子类 对象，必须强转，如果类是其他人 提供的，无法修改

    }
}
