package cn.kiroe.day16_exception._02handle._02trycatch;

/**
 * @author kiro
 * @description:
 * @data 11:08 31/10/2023
 **/
/*

#### 单分支

语法


方式一:
try{
   // 可能出现异常的代码
}catch(异常类型 对象名){
   // 对异常的处理操作
}
方式二:
try{
   // 可能出现异常的代码
}catch(异常类型1 | 异常类型2 | 异常类型3 | 对象名){
   // 对异常的处理操作
}



 */
public class Demo {

    public static void main(String[] args) {
        try {

            System.out.println("start");
            System.out.println(10 / 0);
            System.out.println("end");

        } catch (NullPointerException e) {
            // catch 中的语句想要执行 必须类型匹配才能进来
            System.out.println("捕获到了 异常信息");
        }

        System.out.println("main end");
    }
}
