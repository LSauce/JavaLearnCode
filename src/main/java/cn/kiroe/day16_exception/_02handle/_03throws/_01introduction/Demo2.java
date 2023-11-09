package cn.kiroe.day16_exception._02handle._03throws._01introduction;

/**
 * @author kiro
 * @description:
 * @data 11:48 31/10/2023
 **/
/*
**子类重写父类方法注意:**

- 子类方法不能比父类抛出更多的编译时异常
- 父类如果抛出Exception,那么子类就可以随便抛出
- 建议子类重写的时候保持跟父类一样的异常列表
 */
public class Demo2 {
    public static void main(String[] args) {

    }
}
/*
子类重写 父类方法是，不能 比父类 抛出 更多的编译时异常
但抛出的异常 不能是 父类抛出异常的 父类，运行时异常可多抛出
 */
class Father{

    public void m1() throws CloneNotSupportedException{

    }

    public void m2() throws Exception {

    }

    // 运行时异常不影响
    public void m3() throws ArithmeticException{

    }
}
class Son extends Father{
    // Son' clashes with 'm1()' in Father
    // @Override
    // public void m1() throws Exception {
    //     super.m1();
    // }


    @Override
    public void m1() throws CloneNotSupportedException {
        super.m1();
    }

    @Override
    public void m2() throws  CloneNotSupportedException{

    }


    @Override
    public void m3() throws ArithmeticException,NullPointerException {

    }
}