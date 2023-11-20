package selflearn.thread.day21_thread3._02producerandconsumeer.ex3_synchronized;

/**
 * @author kiro
 * @description:
 * @data 13:55 6/11/2023
 **/
/*
测试 同一把锁，synchronized 的嵌套
 */
public class Demo {

    final static Object OBJECT = new Object();
    public static void main(String[] args) {
        synchronized (OBJECT){
            System.out.println("第一层锁");
            // 里面不能有 通过无限循环条件判断 wait的，要不可能会死循环
            synchronized (OBJECT){
                System.out.println("第二层锁");
            }

        }
    }
}
