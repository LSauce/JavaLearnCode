package cn.kiroe.days13_object._05clone._01basic;

/**
 * @author kiro
 * @description:
 * @data 17:29 27/10/2023
 **/
public class Demo2 {

    public static void main(String[] args) {
        judgeInstanceImplEmptyInter(new Demo());
        judgeInstanceImplEmptyInter(new A());
    }

    //用于判断传入的对象是否是接口的子类对象
    public static void judgeInstanceImplEmptyInter(Object o) {
        if (o instanceof EmptyInterface) {
            System.out.println("实现了空接口,可以做一些操作");
            return;
        }
        System.out.println("没有实现空接口,抛出异常");

        EmptyInterface emptyInterface =new Demo2()::test;
    }

    void  test(){

    }
}
interface EmptyInterface {
    void test2();

}
class A implements EmptyInterface {

    @Override
    public void test2() {

    }
}
