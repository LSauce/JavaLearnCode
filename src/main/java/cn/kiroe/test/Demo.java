package cn.kiroe.test;

/**
 * @author kiro
 * @description:
 * @data 16:55 17/10/2023
 **/
public class Demo {

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
}


