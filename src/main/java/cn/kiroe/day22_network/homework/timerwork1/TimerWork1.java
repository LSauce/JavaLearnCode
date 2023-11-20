package cn.kiroe.day22_network.homework.timerwork1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author kiro
 * @description:
 * @data 19:22 6/11/2023
 **/

/*
写1个定时任务,3s的延迟后,每隔5s向文件中写入一行当前时间
 */
public class TimerWork1 {

    public static void main(String[] args) throws InterruptedException {
        // 设置任务
        File file = new File("IOTest/Timer.log");
        TimerTask task = new WriteDateTimerTask(file);
        Timer timer = new Timer();
        timer.schedule(task,1,3000);
        TimeUnit.SECONDS.sleep(12);
        timer.cancel();
    }
}

class WriteDateTimerTask extends TimerTask {
    private static String pattern = "yyyy-MM-dd hh:ss:mm";
    private static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    private File file;

    public WriteDateTimerTask(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        // 写时间至 文件中
        try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))) {
            String nowTime = sdf.format(new Date());
            writer.println(nowTime);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
