package selflearn.thread.day21_thread3._05timer;


import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kiro
 * @description:
 * @data 16:14 6/11/2023
 **/
public class Demo {

    public static void main(String[] args) {
        // schedule(TimerTask task, Date time)
        Timer timer = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // timer.schedule(new MyTimeTask(),new Date(System.currentTimeMillis()+4000));
        // schedule(TimerTask task, long delay, long period)

        // timer.schedule(new MyTimeTask(), 2000,1000);
        // schedule(TimerTask task, Date firstTime, long period)

        // timer.schedule(new MyTimeTask(), new Date(System.currentTimeMillis() + 2000), 1000);
        // scheduleAtFixedRate(TimerTask task, long delay, long period)
        //
        timer.scheduleAtFixedRate(new MyTimeTask(),1000, 1000);
        // schedule  VS scheduleAtFixedRate 区别
        // 追赶特性
        // schedule和scheduleAtFixedRate的区别在于，如果指定开始执行的时间在当前系统运行时间之前，
        // scheduleAtFixedRate会把已经过去的时间也作为周期执行，而schedule不会把过去的时间算上。

    }
}

// 继承TimerTask
class MyTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("闹钟响了");
    }
}

