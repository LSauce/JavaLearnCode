package cn.kiroe.test;

/**
 * @author kiro
 * @description:
 * @data 16:55 17/10/2023
 **/
public class Demo {

    protected static int father = 0;

    public static void main(String[] args) {
        Integer i1 = 5;
        Integer i2 = 5;
        // Integer有数值缓存 当值 -128 至 127
        System.out.println(i1 == i2);
        Object obj = true ? new Integer(1):new Double(2.0);
        System.out.println(obj);
        // 1.0  三目运算符取决于最大范围的double

        Object obj2 = true ? 1: 2.0;
        System.out.println(obj2);//1.0

        //Son1 son  = (Son1) new Father();// 当对象类为 父类时不能 强制转换为 子类
       // System.out.println("son.age = " + son.age);
        Father father = new Son1();// 当对象为 子类时 引用类型可转换为父类
        System.out.println("father = " + father.age);
    }



}
class GrandFather{
    String  gender = "我是你爷爷";
}

 class Father extends  GrandFather{
    int age = 0;
}

class Son1 extends Father{
    String name = "son1";

    static {
        try {
            System.out.println("new Son1().clone() = " + new Son1().clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getFather() throws CloneNotSupportedException {
        System.out.println("this.age = " + this.age);

        return super.clone();

    }
}


