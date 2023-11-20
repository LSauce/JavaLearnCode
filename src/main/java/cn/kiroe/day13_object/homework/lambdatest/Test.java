package cn.kiroe.day13_object.homework.lambdatest;

//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int method(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}

/**
 * @author kiro
 * @description:
 * @data 19:51 27/10/2023
 **/
public class Test {

    public static void main(String[] args) {
        //无返回值无参数的功能接口
        INoReturnNoParam ip1 = new Test()::test;
        ip1.test();
        //无返回值有一个参数的功能接口
        INoReturnOneParam ip2 = a -> System.out.println(a);
        ip2.test(233);
        //无返回值两个参数的功能接口
        INoReturnTwoParam ip3 = (a,b)-> System.out.println(a+b);
        ip3.test(2,3);
        //有返回值无参数的功能接口
        IHasReturnNoParam ip4 = ()->2;
        System.out.println("ip4.test() = " + ip4.test());
        //有返回值一个参数的功能接口
        IHasReturnOneParam ip5 = a->a*3;
        System.out.println("ip5.method(23) = " + ip5.method(2));
        //有返回值两个参数的功能接口
        IHasReturnTwoParam ip6 = (a,b)-> a*b;
        System.out.println("ip6.test(a.b) = " + ip6.test(1,3));

    }

    public void test() {
        System.out.println("ip1");
    }
}
