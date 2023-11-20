package cn.kiroe.day19_thread1._04contorol;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiro
 * @description:
 * @data 16:32 3/11/2023
 **/
/*
案例:

定义一个flag标记, true 是正常状态  false中断

主线程打印3个数 打印1个 休眠1秒  中断子线程

创建子线程  打印10个数 休眠1秒

打印之前判断一下是否中断 如果正常----> 打印数据

如果发生了中断-------> 不在打印, 并且把中断信息保存到log.txt文件中

格式 年月日 时分秒  哪个线程发生了中断
 */
public class SecurityStopDemo {

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ThreadSecurityStop threadSecurityStop = new ThreadSecurityStop();
        threadSecurityStop.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("main ---" + i);
            Thread.sleep(1000);
        }
        // 中断线程
        threadSecurityStop.flag = false;
    }
}

class ThreadSecurityStop extends Thread {
    public boolean flag = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (flag) {
                // 正常情况
                System.out.println(getName() + " ---" + i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // 将诊断文件 保存至 文件中 log.txt
                // 格式 年月日 时分秒  哪个线程发生了中断
                this.interrupt();
                System.out.println("准备结束");

                try (PrintWriter printWriter = new PrintWriter(new FileWriter("IOTest/log.txt"))) {

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String data = simpleDateFormat.format(new Date());
                    printWriter.println(data + getName() + "发生了线程中断");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
