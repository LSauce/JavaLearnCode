package cn.kiroe.day19_thread1._05inpltwo;

import org.junit.internal.runners.statements.RunAfters;

/**
 * @author kiro
 * @description:
 * @data 17:13 3/11/2023
 **/
/*

多线程实现方式2
1. 定义一个类实现Runnable接口
2. 重写run方法
3. 创建子类对象
4. 创建线程对象, 把实现了Runnable接口的子类对象作为参数传递
5. start方法启动线程
 */
public class Demo {
    public static void main(String[] args) {
        // 3. 创建子类对象
        // 把MyRunable 当做任务
        MyRunnable target = new MyRunnable();
        // 4. 创建对象，把实现了Runnable接口的子类对象 作为参数调用
        Thread thread = new Thread(target);

        // 启动线程
        thread.start();
    }
}

// 1. 定义一个类实现Runnable接口
class MyRunnable implements Runnable {
    // 2. 重写 run()方法
    @Override
    public void run() {
        System.out.println("子线程执行了");
    }
}

class MyRunnable2 implements Runnable {


    @Override
    public void run() {
        System.out.println("test2");
    }
}
