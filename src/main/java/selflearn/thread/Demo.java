package selflearn.thread;

import java.util.concurrent.*;

/**
 * @author kiro
 * @description:
 * @data 20:07 9/11/2023
 **/
public class Demo {

   
}


class MyExecutorService implements Executor{

    @Override
    public void execute(Runnable command) {

    }
    // 这里 Future<T> ，是将T传给Future, T 通过 形参 中T判断
    <T> Future<T> submit(Callable<T> task){
        return null;
    }
}