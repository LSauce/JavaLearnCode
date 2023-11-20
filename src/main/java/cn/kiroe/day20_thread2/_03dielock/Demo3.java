package cn.kiroe.day20_thread2._03dielock;

/**
 * @author kiro
 * @description:
 * @data 11:58 4/11/2023
 **/
/*
    解决死锁
        使加锁顺序一样
        再加一把锁， 把非原子操作，变成原子操作
 */
public class Demo3 {
    public static void main(String[] args) {
        // 创建并启动2个线程
        new Thread(new DieLock3(true)).start();
        new Thread(new DieLock3(false)).start();
    }
}

// 定义一个锁类
class MyLock3 {
    public static final Object objA = new Object();
    public static final Object objB = new Object();
    public static final Object objC = new Object();
}

// 死锁类
class DieLock3 implements Runnable {
    boolean flag;

    public DieLock3(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // synchronized

        runBody();

    }

    private void runBody() {
        synchronized (MyLock3.objC) {
            // 同步代码块嵌套
            if (flag) {
                synchronized (MyLock.objA) {
                    // 假设A线程先执行 A线程获取A锁
                    System.out.println("if A");
                    synchronized (MyLock.objB) {
                        System.out.println("if B");
                    }
                }
            } else {
                synchronized (MyLock.objB) {
                    // B线程进来 获取了B锁
                    System.out.println("else A");
                    synchronized (MyLock.objA) {
                        System.out.println("else B");
                    }
                }
            }
        }
    }

    private void runBody2() {
        // 在if中单独加锁
        // 同步代码块嵌套
        if (flag) {
            synchronized (MyLock.objA) {
                // 假设A线程先执行 A线程获取A锁
                System.out.println("if A");
                synchronized (MyLock.objB) {
                    System.out.println("if B");
                }
            }
        } else {
            synchronized (MyLock.objB) {
                // B线程进来 获取了B锁
                System.out.println("else A");
                synchronized (MyLock.objA) {
                    System.out.println("else B");
                }
            }
        }
    }
}


