package cn.kiroe.day20_thread2._04volatile;

/**
 * @author kiro
 * @description:
 * @data 15:46 4/11/2023
 **/
/*
验证 voltile 关键字的作用
 特点：  只能修饰变量，在读和写时，会刷新 所有线程 的 工作内存 和 jvm的主内存
 */
public class Demo {
    public static void main(String[] args) {
        //volatilAtomicTest();
        // Thread.activeCount() 测试
        // System.out.println("Thread.activeCount() = " + Thread.activeCount());
        // System.out.println("Thread.getAllStackTraces() = ");
    }

    private static void volatilAtomicTest() {
        //  新建线程100个 线程对number进行 ++操作
        VolatileRunnable volatileRunnable = new VolatileRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(volatileRunnable).start();
        }
        //主线程等 所有线程 完成后 输出 最后的结果
        while (Thread.activeCount() > 2){
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        // 打印结果
        System.out.println(volatileRunnable.number);
    }
}


class VolatileRunnable implements Runnable {

    //定义volatile 修饰的变量
    public volatile int number = 0;

    // 定义加一方法
    public void  increase(){
        number++;
    }


    @Override
    public void run() {
        increase();
    }
}
