package selflearn.thread.day21_thread3.custom._08orderly;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kiro
 * @description:
 * @data 21:15 5/11/2023
 **/
public class ThisEscape {
    private static volatile boolean running = true;
    public   int num = 8;

    Thread t;

    public ThisEscape() {
        new Thread(() -> {
            if(num == 0){
                System.out.println(0);
            }
        }).start(); // 可能结果为0
    }


    public static void main(String[] args) throws IOException {
        AtomicInteger a = new AtomicInteger(1);
        a.incrementAndGet();
        a.addAndGet(10);
        while (true) {
            new ThisEscape();
        }
    }
}
