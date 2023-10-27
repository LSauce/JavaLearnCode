package cn.kiroe.test._01reflex._01introdoce.test2;

import cn.kiroe.test.Demo;

/**
 * @author kiro
 * @description:
 * @data 09:51 23/10/2023
 **/
public class SonOther extends Demo {
    public static void main(String[] args) {
        SonOther son = new SonOther();
        SonOther.father = 2;
        System.out.println("son.father = " + son.father);
    }
}
