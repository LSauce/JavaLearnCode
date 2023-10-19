package cn.kiroe;

public class Test {
    public static void main(String[] args) {
       int  a = Integer.parseInt("1024");

        int b = Integer.valueOf("1024").intValue();
    }


}

class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car(). run();
    }
    //并没有覆写 父类
    private final void run()
    {
        System. out. println ("Car");
    }
}
class Vehicle
{
    //private 对子类不可用
    private final void run()
    {
        System. out. println("Vehicle");
    }
}
