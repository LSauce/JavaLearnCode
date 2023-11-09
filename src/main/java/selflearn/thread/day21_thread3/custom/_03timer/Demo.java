package selflearn.thread.day21_thread3.custom._03timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kiro
 * @description:
 * @data 14:56 4/11/2023
 **/
public class Demo {
    public static void main(String[] args) throws ParseException, InterruptedException {
        // 创建定时器
        Timer timer = new Timer();
        // 调度
        // schedule(TimerTask task, Date time)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2022-10-21 11:48:00";
        Date date = sdf.parse(time);
        // timer.schedule(new MyTask(), date);

        //schedule(TimerTask task, long delay, long period)
        timer.schedule(new MyTask(),5000,3000); // 为默认线程

        //schedule(TimerTask task, Date firstTime, long period)
        //timer.schedule(new MyTask(), date, 3000);

        //scheduleAtFixedRate(TimerTask task, long delay, long period)
        // 取消定时器
        //TimeUnit.SECONDS.sleep(15);
        //timer.cancel(); // 这里取消了计时器
    }
}
// 定义一个定时任务
// 继承TimerTask
// 重写run
class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("炸弹爆炸了Boom!");
    }
}
