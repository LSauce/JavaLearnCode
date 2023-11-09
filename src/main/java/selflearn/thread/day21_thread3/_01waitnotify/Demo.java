package selflearn.thread.day21_thread3._01waitnotify;

/**
 * @author kiro
 * @description:
 * @data 10:00 6/11/2023
 **/

/*
 验证wait执行条件
    必须拥有锁对象

 */
public class Demo {
    static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        // Exception in thread "main" java.lang.IllegalMonitorStateException

        synchronized (o){
            System.out.println("这是wait before");
            // 在锁对象上调用wait
            o.wait();
            /*
            执行wait 会使当前 线程处于 阻塞状态
            main是当前线程，o.wait(); 运行在 哪个 线程中
             */
            System.out.println("wait after");
        }
    }

}
