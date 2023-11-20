package cn.kiroe.day14_wrapper._05interview;

/**
 * @author kiro
 * @description:
 * @data 10:33 28/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        Object obj = true ? new Integer(1):new Double(2.0);
        System.out.println(obj);
        // 1.0  三目运算符取决于最大范围的double

        Object obj1;
        if(true)
            obj1 = new Integer(1);
        else
            obj1 = new Double(2.0);
        System.out.println(obj1);
        // 1 跟上面那个不一样,这是if语句
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);
        // false
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);
        // false 对象地址不一样
    }
}
