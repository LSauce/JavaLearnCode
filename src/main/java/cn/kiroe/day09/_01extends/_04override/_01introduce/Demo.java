package cn.kiroe.day09._01extends._04override._01introduce;

/**
 * @author kiro
 * @description:
 * @data 14:52 23/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        Father son = new Son();
        son.invokeM1();// 方法的重写/覆盖, 调用的 为 son的方法，因为被覆盖了
    }
}

class Father{

    public void m1(){
        System.out.println("father");
    }

    public void invokeM1(){
        m1();
    }

}

class Son extends Father{
    @Override
    public void m1(){
        System.out.println("son");
    }
}
