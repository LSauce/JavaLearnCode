package cn.kiroe.day21_thread3.custom._07cacheline;

import sun.misc.Contended;

/**
 * @author kiro
 * @description:
 * @data 18:46 5/11/2023
 **/

/*
cpu中的 缓存行 cache line 机制的 影响
缓存行的大小为 64 byte

可使用注解 @Contended  使变量和其他变量，不是一行,只有1.8起作用
需要jvm运行时添加参数 -XX:-RestrictContended
 */
public class Demo {
    public static long COUNT = 10_000_00000L;

    private static class T{
        // 测试cpu缓冲行，每个 缓冲行64byte，所以可以使用 上下两个 56byte进行填充，使对齐
        // 防止 cpu缓存 之间的同步
        //private long p1,p2,p3,p4,p5,p6,p7; // 56个字节
        @Contended
        private long x = 0L;
        //private long p9,p11,p12,p13,p14,p15; // 56个字节
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }
    public static void main(String[] args) throws InterruptedException {
        // 统计时间
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        // 建立对象 循环 COUNT次,并给 x加1


        Thread thread = new Thread(()->{
            for (int i = 0; i < COUNT; i++) {
                arr[0].x++;
            }
        });

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < COUNT; i++) {
                arr[1].x++;
            }
        });


        thread.start();
        thread1.start();

        // 等待加入
        thread.join();
        thread1.join();
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
