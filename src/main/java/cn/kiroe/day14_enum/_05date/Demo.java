package cn.kiroe.day14_enum._05date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiro
 * @description:
 * @data 11:57 28/10/2023
 **/
public class Demo {

    public static void main(String[] args) throws ParseException {
        System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate =  simpleDateFormat.format(new Date());
        System.out.println("formatDate = " + formatDate);

        String str = "2023-10-28 12:06:28";
        Date date = simpleDateFormat.parse(str);
        System.out.println(date);
    }
}
