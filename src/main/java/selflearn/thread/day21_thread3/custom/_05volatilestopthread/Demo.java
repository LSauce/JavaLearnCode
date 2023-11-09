package selflearn.thread.day21_thread3.custom._05volatilestopthread;

import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 17:14 5/11/2023
 **/
public class Demo {
    private static volatile boolean running = true;
    private static int a = 10;
    public static void main(String[] args) throws InterruptedException {
        // volatileStopThreadDemo();
        interruptedStopThreadDemo();
    }

    private static void volatileStopThreadDemo() throws InterruptedException {
        // 新建线程
        Thread t = new Thread(()->{
            long i = 0L;
            while (running){ // 只能使用 静态变量
                i++;
            }
            System.out.println("end i = "+ i);
            // System.out.println(a);
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
    }


    public static void interruptedStopThreadDemo() throws InterruptedException {
         // 创建线程
        Thread t= new Thread(()->{
           while (!Thread.interrupted()){
               // 可使用sleep wait
               // 单需要做异常处理
           }
            System.out.println("t1 end");
        });
        t.start();

        TimeUnit.SECONDS.sleep(1);

        t.interrupt();
    }


}
