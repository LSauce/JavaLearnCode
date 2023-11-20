package cn.kiroe.day18_io2.homework.ex5_01;

import java.io.*;

import static java.lang.Character.getType;
import static java.lang.Character.isAlphabetic;

/**
 * @author kiro
 * @description:
 * @data 22:08 2/11/2023
 **/
/*
准备一个文本文件，其中包含英文 ,数字, 中文字符。

设计一个方法

public static void encodeFile(File encodingFile, File encodedFile);

在这个方法中把encodingFile的文本内容进行加密，然后保存到encodedFile文件中。

加密算法：

数字： 如果是非9的数字，在原来的基础上加1，比如5变成6, 3变成4。如果这个数字就是9，那么变成数字0
字母字符：如果是非z字符，向右移动一个，比如d变成e，G变成H。如果是z，z->a，Z-A。
注：字母字符加密的过程不能改变大小写
非数字和字母的字符则保持不变即可，比如汉字和标点符号等都只需要保持不变即可。
 */
public class Work {


    public static void main(String[] args) {
        File file = new File("IOTest/ex5_1.txt");
        File file1 = new File("IOTest/ex5_2.txt");
        encodeFile2(file, file1);

        System.out.println("isAlphabetic('你') = " + Character.isAlphabetic(0));
        System.out.println("Character.isLetter('我') = " + Character.isLetter('我'));
    }

    public static void encodeFile(File encodingFile, File encodedFile) {
        // 使用 周期，循环遍历  a-1 --> // 只处理边界, 0,a,A,

        try (PrintStream writer = new PrintStream(encodedFile);
             BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(encodingFile))) {
            // 读取并 解密
            int readCount;
            byte[] bytes = new byte[1024];

            while ((readCount = inputStream.read(bytes)) != -1) {

                // 转换
                for (int i = 0; i < readCount; i++) {
                    if (bytes[i] == 'z' || bytes[i] == 'Z') {
                        bytes[i] = (byte) (bytes[i] - 25);
                    } else if (bytes[i] == '9') {
                        bytes[i] = '0';
                    } else if (Character.isLetterOrDigit(bytes[i])) {
                        bytes[i] += 1;
                    }
                }
                // 写入
                writer.write(bytes, 0, readCount);
            }
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void encodeFile2(File encodingFile, File encodedFile) {
        // 使用 周期，循环遍历  a-1 --> // 只处理边界, 0,a,A,

        try (PrintWriter writer = new PrintWriter(encodedFile);
             BufferedReader inputStream = new BufferedReader(new FileReader(encodingFile))) {
            // 读取并 解密
            int readCount;
            char[] chars = new char[1024];

            while ((readCount = inputStream.read(chars)) != -1) {
                // 转换
                for (int i = 0; i < readCount; i++) {
                    if (chars[i] == 'z' || chars[i] == 'Z') {
                        chars[i] = (char) (chars[i] - 25);
                    } else if (chars[i] == '9') {
                        chars[i] = '0';
                    } else if (Character.isAlphabetic(chars[i]) || Character.isDigit(chars[i])) {
                        chars[i] += 1;
                    }
                }
                // 写入
                writer.write(chars, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // public static boolean isLetter(char c) {
    //
    //     // return  (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    //     return (   //    10 | 100 | 1000 | 10000 | 100000 = 11110 >> getType
    //             (
    //                     (
    //                             (1 << 1 |
    //                                     (1 << 2 )|
    //                                     (1 << 3 )|
    //                                     (1 << 4 )|
    //                                     (1 << 5)
    //                     ) >> getType(c)
    //             )
    //                     & 1
    //     ) != 0
    // }
}
