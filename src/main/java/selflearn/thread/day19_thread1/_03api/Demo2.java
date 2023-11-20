package selflearn.thread.day19_thread1._03api;

/**
 * @author kiro
 * @description:
 * @data 15:25 3/11/2023
 **/
/*

优先级设置
 */
public class Demo2 {

    public static void main(String[] args) {
         // 创建线程对象
        Thread thread = new Thread(Demo2::threadMethod);
        Thread thread2 = new Thread(Demo2::threadMethod);
        thread.setPriority(10);
        thread2.setPriority(1);
        thread2.start();
        thread.start();
        System.out.println("thread.getPriority() = " + thread.getPriority());
    }

    private static void threadMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
