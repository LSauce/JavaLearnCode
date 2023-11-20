package cn.kiroe.day20_thread2._03dielock;

/**
 * @author kiro
 * @description:
 * @data 11:58 4/11/2023
 **/
/*
    解决死锁
        使加锁顺序一样
 */
public class Demo2 {
    public static void main(String[] args) {
        // 创建并启动2个线程
        new Thread(new DieLock2(true)).start();
        new Thread(new DieLock2(false)).start();
    }
}

// 定义一个锁类
class MyLock2 {
    public static final Object objA = new Object();
    public static final Object objB = new Object();
}

// 死锁类
class DieLock2 implements Runnable {
    boolean flag;

    public DieLock2(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
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
            synchronized (MyLock.objA) {
                // B线程进来 获取了B锁
                System.out.println("else A");
                synchronized (MyLock.objB) {
                    System.out.println("else B");
                }
            }
        }
    }
}


