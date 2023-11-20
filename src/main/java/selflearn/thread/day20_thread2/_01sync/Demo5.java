package selflearn.thread.day20_thread2._01sync;

/**
 * @author kiro
 * @description:
 * @data 11:19 4/11/2023
 **/
/*
synchronized 能稀释
代码块、方法、静态方法
出现异常的时候 会释放锁

在对象头中  mark work 有 锁信息，会记录 锁的持有者

 */
public class Demo5 {
    public static final Object OBJECT =new Object();
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        // 创建并启动一个线程
        new Thread(()->{
            System.out.println("A启动了");

            synchronized (OBJECT){
                System.out.println("A进来了");
                while (true){
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // 异常会 释放锁
                    if(count == 10){
                        System.out.println(count/0);
                        // 制造异常
                        //break;

                    }
                }
               // System.out.println("A退出了");
            }
        },"A").start();
        // sleep 保证第一个先执行 先拿到锁
        Thread.sleep(1000);
        // 创建并启动一个线程
        new Thread(()->{
            System.out.println("B启动了");
            synchronized (OBJECT){
                System.out.println("B进入了");
            }
            System.out.println("B退出了");
        },"B").start();

    }
}
