package cn.kiroe.day17_io.homework.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 14:05 1/11/2023
 **/
/*
定义一个String[] words数组，数组中每个字符串的格式为“词性:单词”

String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};

要求:

根据单词性质动词verb全部存入verb.txt文件中,该文件中最终显示：
verb:eat
verb:drink
verb:sleep
verb:play


根据单词性质名词noun全部存入noun.txt文件中,该文件中最终显示：
noun:rice
noun:meat
noun:hand
noun:hair

提示：如果做字符串拼接，推荐使用可变字符串来进行拼接。
 */
public class Test {

    public static void main(String[] args) {
        String[] words = {"verb:eat", "verb:drink", "verb:sleep", "verb:play", "noun:rice", "noun:meat", "noun:hand", "noun:hair"};
        // 分为两个  文件路径
        File file1 = new File("verb.text");
        File file2 = new File("noun.text");
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (String word : words) {
            if(word.startsWith("verb:")){
                stringBuilder1.append(word).append(System.lineSeparator());
            }else if(word.startsWith("noun:")){
                stringBuilder2.append(word).append(System.lineSeparator());
            }
        }
        // 输出流：
        try (FileOutputStream fileOutputStream1 = new FileOutputStream(file1); FileOutputStream fileOutputStream2 = new FileOutputStream(file2)) {
            //写入 verb
            fileOutputStream1.write(stringBuilder1.toString().getBytes());
            //写入 noun
            fileOutputStream2.write(stringBuilder2.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
