package selflearn.thread.day21_thread3._04callable;

import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 15:59 6/11/2023
 **/
/*
创建2个线程,A线程计算1+2+3...+100的结果

B线程计算1+2+3+...200的结果
 */
public class Demo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task1 = new FutureTask<>(new CalcSumTask(100));
        FutureTask<Integer> task2 = new FutureTask<>(new CalcSumTask(200));

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(task1);
        service.submit(task2);
        System.out.println("task1.get() = " + task1.get());
        System.out.println("task2.get() = " + task2.get());
    }
}

class CalcSumTask implements Callable<Integer>{
    int endNum;

    public CalcSumTask(int endNum) {
        this.endNum = endNum;
    }

    @Override
    public Integer call() throws Exception {
        int sum =0;
        for (int i = 1; i <= endNum; i++) {
            sum += i;
        }
        return sum;
    }
}
