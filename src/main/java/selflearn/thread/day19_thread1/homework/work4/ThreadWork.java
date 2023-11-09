package selflearn.thread.day19_thread1.homework.work4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author kiro
 * @description:
 * @data 20:23 3/11/2023
 **/
/*
(选做,可最后做)

利用多线程实现破解密码
首先从0-9这10个数中, 生成一个长度是3的随机数字，把这个数字当作密码
创建一个破解线程，使用穷举法，匹配这个密码,直到匹配到正确的,匹配过程中尝试过的数字需要存入一个数组
创建一个日志线程，将该日志线程设置为守护线程。将尝试过的数字写入文件，并将密码的最终结果也写入文件中。
注意: 当Java进程中的所有线程都是守护线程时，JVM退出。
而日志线程打印破解过程日志，必然需要等待破解线程执行完毕后才能够完整打印这个过程。
所以日志线程打印破解过程，需要在破解线程执行完毕后再启动执行。
思考一下，如何保证这一点呢？
// 使用 .join() 方法

 */
public class ThreadWork {
    public static void main(String[] args) throws InterruptedException {
        String randomPassword = createThreeDigitRandomPassword();
        System.out.println("密码:" + randomPassword);
        // 创建一个破解线程，使用穷举法，匹配这个密码,直到匹配到正确的
        // ,匹配过程中尝试过的数字需要存入一个数组
        List<String> logs = new ArrayList<>();

        // 创建破解线程
        Thread unlockThread = new Thread(() -> {
            // 使用穷举法
            for (int i = 0; i < 1000; i++) {
                String s = String.format("%03d", i);
                logs.add(s);
                if (s.equals(randomPassword)) {
                    System.out.println("破解的密码为:" + s);
                    break;
                }
            }
        });
        unlockThread.start();
        unlockThread.join();
        // 数据的读取
        Thread logThread = new Thread(() -> {
            try (PrintWriter writer = new PrintWriter("IOTest/unlock.log")) {
                writer.println("破解过的密码");
                StringBuilder sb = new StringBuilder();
                for (String log : logs) {
                    sb.append(log).append(System.lineSeparator());
                }
                writer.println(sb);
                System.out.println(Thread.currentThread().getName()+":写入完成");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        logThread.setDaemon(true);
        logThread.start();
        logThread.join();


    }

    // 首先从0-9这10个数中, 生成一个长度是3的随机数字，把这个数字当作密码
    private static String createThreeDigitRandomPassword() {
        String pool = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            sb.append(pool.charAt(random.nextInt(pool.length())));
        }

        return sb.toString();
    }
}


