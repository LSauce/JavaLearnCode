package selflearn.thread.day20_thread2._04volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 17:03 4/11/2023
 **/
/*

volatile 的作用
    1. 防止 重排序
        - 内存 分配空间 分为三个步骤
            - 分配内存空间、初始化对象、将内存空间的地址赋值给对应的引用
        - 后两个步骤 可能由于 JVM重排序 导致 ，将内存空间的地址赋值给对应的引用 再 初始化对象
        - 初始化对象 过程包括，显式赋值，构造代码块赋值，构造器赋值

    2. 保持可见性
 */
public class Demo2 {

    public static void main(String[] args) {
        TestVolatile.test();
    }
}

class TestVolatile {
    private static boolean stop = false;

    public static void test() {
        // Thread-A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) { // 由于可见性问题 和 线程工作内存问题，当其他线程 更改后，无法获取
                }
                System.out.println(Thread.currentThread() + " stopped");
            }
        }.start();

        // Thread-main
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread() + " after 1 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }
}

