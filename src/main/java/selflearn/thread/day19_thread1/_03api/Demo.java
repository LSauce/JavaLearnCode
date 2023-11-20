package selflearn.thread.day19_thread1._03api;

/**
 * @author kiro
 * @description:
 * @data 15:00 3/11/2023
 **/
public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 获取线程名称
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();

        Thread thread1 = new MyThread("A");
        Thread thread2 = new MyThread("B");
        // thread1.setName("吴彦祖");
        // thread2.setName("彭于晏");
        thread1.start();
        thread2.start();




    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 获取线程名称
            System.out.println(Thread.currentThread().getName());
            System.out.println("this.getName() = " + this.getName());
        }
    }

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
}
