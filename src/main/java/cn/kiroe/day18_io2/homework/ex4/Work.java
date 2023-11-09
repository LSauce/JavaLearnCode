package cn.kiroe.day18_io2.homework.ex4;

import java.io.*;
import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 21:00 2/11/2023
 **/
/*
利用字符流去读取一个文本文件，每次读取一行，并将这行数据逆序，写入新的文本文件当中

比如a.txt:

我今晚要吃西瓜
你今晚吃什么呢?

那么输出流得到的b.txt就是:
瓜西吃要晚今我
?呢么什吃晚今你
 */
public class Work {

    public static void main(String[] args) {
        File source = new File("IOTest/ex4_1.txt");
        File target = new File("IOTest/ex4_2.txt");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target)); BufferedReader reader = new BufferedReader(new FileReader(source))) {
            // 先读取一行，并逆序
            String s1;
            while ((s1 = reader.readLine()) != null) {
                // 逆序
                char[] charArray = s1.toCharArray();
                for (int i = 0; i < charArray.length / 2; i++) {
                    charArray[i] = charArray[charArray.length - 1 - i];
                }
                writer.println(charArray);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
