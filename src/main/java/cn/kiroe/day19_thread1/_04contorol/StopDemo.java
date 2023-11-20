package cn.kiroe.day19_thread1._04contorol;

/**
 * @author kiro
 * @description:
 * @data 16:27 3/11/2023
 **/
public class StopDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadStop threadStop = new ThreadStop();
        threadStop.start();
        Thread.sleep(3000);
        threadStop.stop(); // 不推荐使用

    }
}

class ThreadStop extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() +"---"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
