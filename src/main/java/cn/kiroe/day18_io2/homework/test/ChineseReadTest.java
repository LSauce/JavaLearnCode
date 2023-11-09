package cn.kiroe.day18_io2.homework.test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author kiro
 * @description:
 * @data 22:42 2/11/2023
 **/
public class ChineseReadTest {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("IOTest/a.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                char ch = (char) c;
                    System.out.println(ch);

            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isChineseCharacter(char ch) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
        return block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || block == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
    }
}


