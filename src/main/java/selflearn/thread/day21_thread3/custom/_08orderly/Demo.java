package selflearn.thread.day21_thread3.custom._08orderly;

/**
 * @author kiro
 * @description:
 * @data 20:23 5/11/2023
 **/
/*
 进行有序性的 验证
 定义4个  变量
 分别按按 顺序赋值
 设计一个  只有 换序时才能发生的情况 为停止条件

 */
public class Demo {

    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    private static volatile boolean running = true;
    public static void main(String[] args) throws InterruptedException {
        long count = 0L;
        while (running){
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Thread thread = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread1.start();
            thread.start();
            thread.join();
            thread1.join();
            count++;
            System.out.println(count);
            if(x == 0 && y == 0){
                running = false;
            }
        }
        System.out.println(" 循环结束了,循环了"+ count+"次");
    }

    private static void runThread() {
        a = 0;
        b = 0;
        x = 0;
        y = 0;
        Thread thread = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread thread1 = new Thread(() -> {
            b = 1;
            y = a;
        });

        thread1.start();
        thread.start();
    }
}
