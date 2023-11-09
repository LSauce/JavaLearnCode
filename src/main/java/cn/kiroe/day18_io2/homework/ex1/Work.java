package cn.kiroe.day18_io2.homework.ex1;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 19:35 2/11/2023
 **/

/*

给定一个文本文件，这个文件中有随机的一些数字字符(你可以自己随便打一段数字)，统计这些数字有几个偶数，几个奇数

把这个结果追加写入到该文本文件的末尾。
例如：
a.txt文件：3241256364789629090126581212515
运行程序后,该文件如下:
3241256364789629090126581212515
偶数个数:16个
奇数个数:15个
注: 举的例子中,一共有31个数,直接判断这些0-9的数的奇偶性,计算个数即可
 */
public class Work {

    public static void main(String[] args) {
        // 给定一个文本文件，这个文件中有随机的一些数字字符(你可以自己随便打一段数字)，统计这些数字有几个偶数，几个奇数
        File file = new File("IOTest/ex1.txt");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
             BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // 统计这些数字有几个偶数，几个奇数
            int[] evenOddCount = new int[2];
            int readCount;
            char[] chars = new char[1024];
            while ((readCount = reader.read(chars)) != -1) {
                for (int i = 0; i < readCount; i++) {
                    char r = chars[i];
                    if (Character.isDigit(r)) {
                        evenOddCount[Integer.parseInt(String.valueOf(r)) & 1]++;
                    }
                }
            }

            // 把这个结果追加写入到该文本文件的末尾。
            writer.print("\n偶数个数:" + evenOddCount[0] + "个\n" +
                    "奇数个数:" + evenOddCount[1] + "个");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
