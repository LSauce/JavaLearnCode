package cn.kiroe.day18_io2.homework.ex6;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 21:30 2/11/2023
 **/
/*
从磁盘上读取一个文本文件（推荐找一个Java源代码文件）
分别统计出文件中英文字母、空格、数字字符的个数。在控制台打印出结果即可。

注：判断是xx字符，可以考虑用包装类型Character，也可以直接简单粗暴的用char类型来进行判断。
 */
public class Work {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("IOTest/ex6.txt"))){
            int letterCount = 0;
            int spaceCount = 0;
            int digitCount = 0;
            byte[] bytes =new byte[1024];
            int readCount = 0;
            // 读取文件

            while ((readCount = bufferedInputStream.read(bytes)) != -1){
                // 计数
                for (int i = 0; i < readCount; i++) {
                    if(Character.isDigit(bytes[i])){
                        digitCount++;
                    }else if(Character.isLetter(bytes[i])){
                        letterCount++;
                    }else if(bytes[i] == ' '){
                        spaceCount++;
                    }
                }
            }

            System.out.printf("英文字母: %d、空格: %d、数字字符: %d",letterCount,spaceCount,digitCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
