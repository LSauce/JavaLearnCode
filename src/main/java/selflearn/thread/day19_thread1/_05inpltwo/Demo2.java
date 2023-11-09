package selflearn.thread.day19_thread1._05inpltwo;

/**
 * @author kiro
 * @description:
 * @data 17:19 3/11/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        // 匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "A");
        thread.start();

        // lambda 表达式
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"6666");
        }, "B");
        thread1.start();
    }
}
