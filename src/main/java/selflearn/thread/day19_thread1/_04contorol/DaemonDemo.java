package selflearn.thread.day19_thread1._04contorol;

/**
 * @author kiro
 * @description:
 * @data 16:16 3/11/2023
 **/
public class DaemonDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");

        // 创建线程对象
        Thread thread = new ThreadDaemon();
        thread.setDaemon(true); // 在 start之前调用
        thread.start();
        Thread thread1= new ThreadDaemon();
        thread1.start();
        // 打印三个数
        for (int i = 0; i < 3; i++) {
            System.out.println("main ----"+ i);
            Thread.sleep(1000);
        }

        System.out.println("main end ");
    }
}

class ThreadDaemon extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() +"---"+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {


            }

        }
    }
}
