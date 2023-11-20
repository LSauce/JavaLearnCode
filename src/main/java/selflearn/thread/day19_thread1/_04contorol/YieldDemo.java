package selflearn.thread.day19_thread1._04contorol;

/**
 * @author kiro
 * @description:
 * @data 16:04 3/11/2023
 **/
public class YieldDemo {

    public static Thread selfThread = Thread.currentThread();
    public static void main(String[] args) {
        YieldThread thread1= new YieldThread();
        YieldThread thread2= new YieldThread(thread1);

       thread1.setSelfThread(thread2);

        thread1.start();
        thread2.start();

    }
}

class YieldThread extends Thread{
    public Thread otherThread;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子"+  getName() + " "+ i);
            Thread.yield(); // 无效，线程还可能直接抢占

        }
    }

    public YieldThread(Thread selfThread) {
        this.otherThread = selfThread;
    }

    public YieldThread() {
    }

    public void setSelfThread(Thread selfThread) {
        this.otherThread = selfThread;
    }
}
