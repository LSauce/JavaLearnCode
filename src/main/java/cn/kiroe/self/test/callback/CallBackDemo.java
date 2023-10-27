package cn.kiroe.self.test.callback;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;

@FunctionalInterface
interface CallBack {
    void run();
}

/**
 * @author kiro
 * @description:
 * @data 21:21 24/10/2023
 **/
/*

回调是什么，
即在 函数结束后，执行传入的 函数，属于函数式编程
回调测试

获得当前 线程 对象
Thread.currentThread()
 */
public class CallBackDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new CallBackTest().testCallBack(() ->
                    System.out.println("回调方法执行" + Thread.currentThread().getName()));
        }
    }
}

class CallBackTest {
    public void testCallBack(CallBack callBack) {
        //新建线程 返回不同 回调

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程开始");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            callBack.run();
            System.out.println(Thread.currentThread().getName() + "线程结束");

        });

        thread.start();


    }

}
