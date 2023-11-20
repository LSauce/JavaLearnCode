package cn.kiroe.day20_thread2._01sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kiro
 * @description:
 * @data 11:30 4/11/2023
 **/
public class Demo6 {


    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){
            System.out.println(111);
        }

    }
}
