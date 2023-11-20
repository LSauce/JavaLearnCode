package cn.kiroe.day16_file.homework.ex4;

/**
 * @author kiro
 * @description:
 * @data 19:51 31/10/2023
 **/
/*
异常类只是描述异常的信息，但是什么时候产生异常，怎么处理异常和异常类本身没有关系。
分别自定义编译时异常和运行时异常，在方法中抛出异常，main方法中调用该方法，并处理相应的异常。
 */
public class ExceptionTest {

    public static void main(String[] args) {
        // 当 不开心时 编译异常
        try {
            throw new MyCompilingException("不开心了");
        }catch (MyCompilingException e){
            e.printStackTrace();
        }
        // 当 开心时  运行异常
        try {
            throw new MyRuntimeException("开心了");
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
// 编译时异常 继承 Exception
class MyCompilingException extends Exception{
    public MyCompilingException(String message) {
        super(message);
    }
}
// 运行是异常 继承 RuntimeException

class MyRuntimeException extends RuntimeException{
    public MyRuntimeException(String message) {
        super(message);
    }


}
