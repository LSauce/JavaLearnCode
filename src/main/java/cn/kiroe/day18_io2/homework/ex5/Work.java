package cn.kiroe.day18_io2.homework.ex5;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 21:07 2/11/2023
 **/
/*
(选做)解密在文件加密中生成的文件(解密上一道题目加密的文件)。
设计一个方法 public static void decodeFile(File decodingFile, File decodedFile);
在这个方法中把decodingFile的内容进行解密，然后保存到decodedFile文件中。
解密算法：

数字： 如果是非0的数字，在原来的基础上减1，比如6变成5，4变成3。如果就是数字0，那就变成9。

字母字符： 如果是非a字符，向左移动一个，比如e变成d，H变成G。如果是a，a->z，A-Z。

非数字和字母的字符则保持不变即可，比如汉字和标点符号等都只需要保持不变即可。
// 这些用个byte就能存,所以直接用byte
 */
public class Work {

    public static void main(String[] args) {
        File file = new File("IOTest/ex5_1.txt");
        File file1 = new File("IOTest/ex5_2.txt");
        decodeFile(file,file1);
    }

    public static void decodeFile(File decodingFile, File decodedFile) {
        // 使用 周期，循环遍历  a-1 --> // 只处理边界, 0,a,A,

        try (PrintStream writer = new PrintStream(decodedFile);
             BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(decodingFile))) {
            // 读取并 解密
            int readCount;
            byte[] bytes = new byte[1024];

            while ((readCount = inputStream.read(bytes)) != -1) {
                
                // 转换
                for (int i = 0; i < readCount; i++) {
                    if (bytes[i] == 'a' || bytes[i] == 'A') {
                        bytes[i] = (byte) (bytes[i] + 25);
                    } else if (bytes[i] == '0') {
                        bytes[i] = '9';
                    } else if (Character.isLetter(bytes[i]) || Character.isDigit(bytes[i])) {
                        bytes[i] -= 1;
                    }
                }
                // 写入
                writer.write(bytes, 0,readCount);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
