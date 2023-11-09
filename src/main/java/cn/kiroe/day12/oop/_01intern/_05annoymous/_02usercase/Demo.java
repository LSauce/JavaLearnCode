package cn.kiroe.day12.oop._01intern._05annoymous._02usercase;

// lambda表达式 只能在接口中使用
@FunctionalInterface
interface ILambda {
    public int m1(int b);


}

/**
 * @author kiro
 * @description:
 * @data 17:19 26/10/2023
 **/
/*
​		匿名内部类实际上就是更简单的局部内部类（直接获取了对象），所以局部内部类的使用场景，可以直接套用过来。

匿名内部类经常使用在以下两个场景中：

1. 方法需要返回一个对象，返回值类型是引用数据类型时。

   方法需要返回一个对象时，可以在方法的局部位置写一个 基于X类或X接口的匿名内部类对象 ，然后直接作为返回值返回给外界。

2. 方法需要传入一个对象，形参数据类型是引用数据类型时。

   方法需要传入一个对象实参时，可以在调用方法的实参位置填入一个 基于X类或X接口的匿名内部类对象，就将它作为一个实参传给方法使用。


 */
public class Demo {

    public static void main(String[] args) {


        ILambda iLambda = (a) -> {
            System.out.println("Test" + a);
            return a;
        };

        iLambda.m1(2);
        new ILambda(){
            final static int att = 100;
            @Override
            public int m1(int b) {
                return 0;
            }


        };

        new Father2(2){

        };

    }
    // 返回值类型是 普通类型
    public static Father test1() {

        // 匿名内部类
        return new Father() {
            @Override
            public int m1() {
                return -1;
            }
        };

        //return new Son2();
    }

    // 返回值是抽象类型
    public static AbstractFater test(){
        return new AbstractFater(){

        };
    }

    // 返回类型是接口类型
}

class Father {
    public int m1() {
        return 1;
    }


}

class Son extends Father {
    @Override
    public int m1() {
        return 2;
    }
}

class Son2 extends Father{

}

class Father2{

    int a;

    public Father2(int a) {
        this.a = a;
    }
}
