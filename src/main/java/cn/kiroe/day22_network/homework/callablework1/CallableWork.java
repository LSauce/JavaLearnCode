package cn.kiroe.day22_network.homework.callablework1;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 19:32 6/11/2023
 **/
/*
多线程实现方式三:

基于Callable接口的方式，启动三个线程来将一个文件同时复制到三个目标文件。
这个Callable任务的返回值是该线程执行文件复制的时间
（可以返回一句话来表示该线程执行文件复制花费了多长时间），
然后在main线程中接收这个返回值，
将三个线程接收到的这句话打印到一个"time.txt"文件中。
 */
public class CallableWork {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        File source = new File("IOTest/Timer.log");
        File target1 = new File("IOTest/Timer1.log");
        File target2 = new File("IOTest/Timer2.log");
        File target3 = new File("IOTest/Timer3.log");

        Future<Long> future1 = service.submit(new coypFileTask(source, target1));
        Future<Long> future2 = service.submit(new coypFileTask(source, target2));
        Future<Long> future3 = service.submit(new coypFileTask(source, target3));
        File replyFile =new File("IOTest/reply.log");

        // 将回复的写入
        FileUtil.writeStringAppend(replyFile, String.valueOf(future1.get()));
        FileUtil.writeStringAppend(replyFile, String.valueOf(future2.get()));
        FileUtil.writeStringAppend(replyFile, String.valueOf(future3.get()));
        // 关闭 线程池
        service.shutdown();

    }
}


class coypFileTask implements Callable<Long> {

    private File sourceFile;
    private File targetFile;

    public coypFileTask(File sourceFile, File targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    @Override
    public Long call()  {
        // 复制文件
        Long startTime = System.currentTimeMillis();
        FileUtil.copyFile(sourceFile, targetFile);
        Long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}

class FileUtil {
    public static Boolean copyFile(File source, File target) {
        if (source == null || target == null || source.isDirectory()) {
            return false;
        }

        try (BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(target.toPath()));
             BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(source.toPath()))) {
            // 边读边写
            byte[] bytes = new byte[1024];
            int readLen;
            while ((readLen = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public static Boolean writeStringAppend(File target,String s){
        if (target == null || s == null){
            return false;
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target,true))){
            writer.println(s);
            writer.flush();
        } catch (IOException e) {
           e.printStackTrace();
           return false;
        }
        return true;
    }
}