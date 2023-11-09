package cn.kiroe.day16_exception._02handle._04throw;

/**
 * @author kiro
 * @description:
 * @data 11:55 31/10/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // func1();
        try {
            func2();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    // throw + 编译异常
    // 要结合 throws 关键字一起使用
    // 交给调用者 去 处理
    private static void func2() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("抛出一个克隆异常");

    }
    private static void func1(){
        throw new RuntimeException("抛出一个异常");
    }


}
