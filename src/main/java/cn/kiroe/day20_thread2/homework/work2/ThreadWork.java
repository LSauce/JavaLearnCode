package cn.kiroe.day20_thread2.homework.work2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kiro
 * @description:
 * @data 13:58 4/11/2023
 **/
/*
用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程。
(只需要在控制台打印已下载xx这句话即可,不需要真正的下载文件)
每个线程每次执行都下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0
(用一个整数表示剩余资源量，一个线程每次执行会下载1兆(M), 下载完毕后该线程会打印剩余需要下载的资源)
参考售票的代码实现，这里需要考虑多线程的数据安全问题
注：仅模拟下载的过程，不是真的下载，也不是真的复制文件！
这道题目实际上就是多个线程共享访问一个num,然后修改num取值罢了
 */
public class ThreadWork {
    public static void main(String[] args) {
        // 创建三条线程进行下载
        // 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 提交任务
        // submit(Runnable task)
        SimulateMultithreadedDownloads simulateMultithreadedDownloads = new SimulateMultithreadedDownloads();
        pool.submit(simulateMultithreadedDownloads);
        pool.submit(simulateMultithreadedDownloads);
        pool.submit(simulateMultithreadedDownloads);


    }
}

class SimulateMultithreadedDownloads implements Runnable {


    int fileSize = 100;
    int downloadedSize = 0;

    @Override
    public void run() {
        // 每个线程每次执行都下载1兆(M)资源
        while (true) {
            if (downloadFile()) {
                break;
            }
        }
    }

    /**
     * 下载文件
     *
     * @return 下载完成返回true, 未完成返回false
     */
    private synchronized boolean downloadFile() {
        // 下载文件
        if (downloadedSize < fileSize) {
            downloadedSize += 1;
            System.out.println(Thread.currentThread().getName() + "： 文件总大小" + fileSize + "MB,已下载 : " + downloadedSize + " MB");
            return false;
        }
        return true;
    }


}

