package selflearn.thread.day21_thread3.custom._09hellojol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author kiro
 * @description:
 * @data 21:56 6/11/2023
 **/
public class HelloJOL {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println("ClassLayout.parseInstance(o).toPrintable() = " + ClassLayout.parseInstance(o).toPrintable());
        // System.out.println("ClassLayout.parseInstance(Object.class).toPrintable() = " + ClassLayout.parseInstance(Object.class).toPrintable());
        // monitorenter
        synchronized (o) {// 锁信息 记录在 对象中 mark word包括锁信息
            System.out.println("ClassLayout.parseInstance(o).toPrintable() = " + ClassLayout.parseInstance(o).toPrintable());
        }
        // // monitorexit
    }
}
