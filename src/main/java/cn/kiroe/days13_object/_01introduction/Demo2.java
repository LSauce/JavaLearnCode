package cn.kiroe.days13_object._01introduction;

/**
 * @author kiro
 * @description:
 * @data 15:29 27/10/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        Class<? extends Father> aClass = new Father().getClass();
        Class<? extends Son> aClass1 = new Son().getClass();
        System.out.println(aClass1 == aClass);
    }
    // 判断类型是否一样
    public static boolean judgeObjectType(Object o1,Object o2){
        return o1.getClass() == o2.getClass();
    }
}

class Father{

}

class Son extends Father{

}
