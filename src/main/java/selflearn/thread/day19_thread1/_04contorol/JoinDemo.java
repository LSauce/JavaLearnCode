package selflearn.thread.day19_thread1._04contorol;

/**
 * @author kiro
 * @description:
 * @data 15:54 3/11/2023
 **/
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程对象并启动
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主"+Thread.currentThread().getName() + " " + i);
             if(i == 5){
                 threadJoin.join(3000);
            }
            Thread.sleep(1000);
        }


    }
}


class ThreadJoin extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子"+getName() + "  " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
