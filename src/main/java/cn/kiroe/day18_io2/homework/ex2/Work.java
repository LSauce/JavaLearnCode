package cn.kiroe.day18_io2.homework.ex2;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kiro
 * @description:
 * @data 19:54 2/11/2023
 **/
/*
在一个磁盘的文件里保存26个英文小写字母（乱序）
      比如: rsztuvijxypbmnocklwaefghdq
      将他们读入内存中进行字典排序(abcd...)
      把排好顺序的字母序列再重新追加写到磁盘的该文件中。(注意要先换一行再追加)
要求:
   用字符流和字节流两种方式来实现这个需求
 */
public class Work {

    public static void main(String[] args) {
        File file = new File("IOTest/ex2.txt");
        // 字符流
        // readWriter(file);
        byteStream(file);
    }

    private static void byteStream(File file) {
        try (FileOutputStream out = new FileOutputStream(file, true);
             BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {

            // 将他们读入内存中进行字典排序(abcd...)
            int readCount = 0;
            List<Byte> list = new ArrayList<>();
            byte[] bytes = new byte[1024];
            while ((readCount = input.read(bytes)) != -1) {
                for (int i = 0; i < readCount; i++) {
                    if (Character.isLetter(bytes[i]))
                        list.add(bytes[i]);
                }
            }
            //       把排好顺序的字母序列再重新追加写到磁盘的该文件中。(注意要先换一行再追加)
            list.sort((o1, o2) -> o1 - o2);
            byte[] bytes1 = new byte[list.size()];
            for (int i = 0; i < bytes1.length; i++) {
                bytes1[i] = list.get(i);
            }
            out.write(System.lineSeparator().getBytes());
            out.write(bytes1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readWriter(File file) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
             InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {

            // 将他们读入内存中进行字典排序(abcd...)
            int readCount = 0;
            List<Character> list = new ArrayList<>();
            char[] chars = new char[1024];
            while ((readCount = reader.read(chars)) != -1) {
                for (int i = 0; i < readCount; i++) {
                    if (Character.isLetter(chars[i]))
                        list.add(chars[i]);
                }
            }
            //       把排好顺序的字母序列再重新追加写到磁盘的该文件中。(注意要先换一行再追加)
            list.sort((o1, o2) -> o1 - o2);
            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);
            printWriter.println();
            printWriter.print(sb);
            printWriter.println();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
