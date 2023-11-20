package cn.kiroe.day15_string._03api;

import javax.xml.transform.Source;
import java.util.Locale;

/**
 * @author kiro
 * @description:
 * @data 15:23 30/10/2023
 **/

/*

课堂练习：
	1:给出一句英文句子： "i want a bing dun dun"
	2:每个单词的首字母都转换为大写并输出
	3.使用split方法

 */
public class Ex6 {


    public static void main(String[] args) {
        String sourceString = "i want a bing dun dun";

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : sourceString.split(" ")) {
            stringBuilder.append(s.substring(0, 1).toUpperCase())
                    .append(s.substring(1))
                    .append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("stringBuilder = " + stringBuilder);



        // String 类的比较功能




    }

}
