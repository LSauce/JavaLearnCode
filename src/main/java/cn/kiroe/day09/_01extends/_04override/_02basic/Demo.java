package cn.kiroe.day09._01extends._04override._02basic;

/**
 * @author kiro
 * @description:
 * @data 14:56 23/10/2023
 **/
/*

测试:
    1.访问范围
    2.访问结果
结论： 编译看左，运行看右
    1.访问范围(编译的角度)
        - 取决于 引用的 数据类型
    2.访问的结果(运行的角度)
        - 取决于 对象的数据类型

 */
public class Demo {
    public static void main(String[] args) {
        //父类 指向 父类
        // 范围--> 父
        // 结果 父
        Father father = new Father();
        father.fatherMethod();
        father.func();
        //子类 指向 子类
        // 范围 子 + 父
        // 结果 子
        Son son = new Son();
        son.fatherMethod();
        son.sonMethod();
        son.func();  // 子结果
        // 父类 指向 子类
        // 范围 父
        // 结果 子
        Father fs=  new Son();
        fs.fatherMethod();
        fs.func();// 为子类的
        System.out.println("fs.a = " + fs.a);
    }
}

class Father{
    int a =10;
    public void func(){
        System.out.println("father func");
    }

    public void fatherMethod(){
        System.out.println("fatherMethod");
    }
}

class Son extends Father{
    int a = 20;
    @Override
    public void func(){
        System.out.println("son func");
    }

    public void sonMethod(){
        System.out.println("SonMethod");
    }

}
