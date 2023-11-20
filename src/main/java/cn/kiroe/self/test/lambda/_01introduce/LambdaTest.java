package cn.kiroe.self.test.lambda._01introduce;

/**
 * @author kiro
 * @description:
 * @data 21:03 24/10/2023
 **/
/*
使用LambadaTest前提 接口 有 @FunctionalInterface 注解
 */

public class LambdaTest {

    public static void main(String[] args) {
        // 使用 Lambda，因为接口 iLambda只有一个方法，所以可使用Lambda表达式，相当于将调用
        ILambda iLambda = LambdaTest::testStaticMethod; // 必须 返回 和 形参相同
        iLambda = (a) -> LambdaTest.testStaticMethod(a);
        // 静态方法 不使用简写
        useLambda(10,(a)->LambdaTest.testStaticMethod(a));
        // 静态方法测试
        useLambda(101,LambdaTest::testStaticMethod);
        // 普通成员方法 不使用简写
        iLambda = new LambdaTest()::testMethod;
        useLambda(100,(a)->new LambdaTest().testMethod(a));
        // 使用简写
        useLambda(1001,new LambdaTest()::testMethod);
        // 构造方法引用
        iLambda = (a) -> new LambdaConstructImpl(a);
        useLambda(222,LambdaConstructImpl::new);


    }
    static void testStaticMethod(int a){
        System.out.println("静态方法"+ a);


    }
    // 测试普通方法引用的类，
    void testMethod(int a){
        System.out.println(a);
    }

    static void useLambda(int b, ILambda iLambada){
        iLambada.test(b);
    }
}

@FunctionalInterface
interface ILambda {
    void test(int a);
}

class LambdaConstructImpl{

    public LambdaConstructImpl(int i) {
        System.out.println(i+"进入构造方法中");
    }


}






