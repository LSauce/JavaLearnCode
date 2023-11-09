package cn.kiroe.day17_io._01bytestream.copy;

import sun.security.provider.MD5;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kiro
 * @description:
 * @data 11:49 1/11/2023
 **/
/*

1.读取文本
2.读取图片
3.读取视频
 */
public class Demo {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        File file = new File("a.txt");
        File file2 = new File("aa.txt");
        System.out.println("file.hashCode()== file2.hashCode() = " + (file.hashCode() == file2.hashCode()));
        // 文件复制
        try (FileInputStream in = new FileInputStream("aa"); FileOutputStream out = new FileOutputStream("a.txt")) {
            long start = System.currentTimeMillis();
           // readSingal(in, out);
            // 批量复制
            copyMulti(in, out);
            System.out.println("System.currentTimeMillis() - start = " + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readSingal(FileInputStream in, FileOutputStream out) throws IOException {
        // 单个读取
        int readData;
        while ((readData = in.read()) != -1) {
            out.write(readData);
        }
    }

    private static void copyMulti(FileInputStream in, FileOutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            // 写入数据
            // 读多少写多少
            out.write(bytes, 0, readCount);
        }
        // 读取结束
    }
}
