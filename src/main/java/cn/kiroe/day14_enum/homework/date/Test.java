package cn.kiroe.day14_enum.homework.date;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * @author kiro
 * @description:
 * @data 14:02 28/10/2023
 **/
/*
制作一个工具类，算一下你来到这个世界多少天了？

注：参考文档中的Date类，自己学习一下。写完后，
如果不确定自己写得正确与否，可以百度一下“计算出生多少天”。这样的网站很多，可以帮助你验证你的代码。
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bornday = simpleDateFormat.parse("2001-08-17");
        String livedTime = CalcBornDays.calcBornDays(bornday);
        System.out.println("出生时间为： "+simpleDateFormat.format(bornday)+ "，共活了："+ livedTime);
    }


}
class CalcBornDays{

    public static String  calcBornDays(Date bornday){

        // 计算一共来了多少天
        long livingMillis =  System.currentTimeMillis() - bornday.getTime();
        int livedDay = (int)(livingMillis /1000/60/60/24);
        // 计算小时和分钟
        int hours = (int) (livingMillis - livedDay*1000*60*60*24)/1000/60/60;
        int minutes = (int) ( livingMillis%(1000*60*60) )/1000/60;
        return livedDay+"天 "+hours+"小时 "+minutes+ "分钟";

    }
}
