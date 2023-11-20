package selflearn.thread.day21_thread3._04callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kiro
 * @description:
 * @data 15:54 6/11/2023
 **/
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用FutureTask
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new MyCallable());
        // 创建线程， 使用new Thread(Runnable runnable )
        new Thread(integerFutureTask).start();
        // 获取结果
        System.out.println("integerFutureTask.get() = " + integerFutureTask.get());

    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 10080;
    }
}
