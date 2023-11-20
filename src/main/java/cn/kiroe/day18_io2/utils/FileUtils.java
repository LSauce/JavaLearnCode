package cn.kiroe.day18_io2.utils;

import java.io.*;
import java.security.NoSuchAlgorithmException;

/**
 * @author kiro
 * @description:
 * @data 09:50 2/11/2023
 **/

public class FileUtils {
    public static void readSingal(InputStream in, OutputStream out) throws IOException {
        // 单个读取
        int readData;
        while ((readData = in.read()) != -1) {
            out.write(readData);
        }
    }

    public static void copyMulti(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            // 写入数据
            // 读多少写多少
            out.write(bytes, 0, readCount);
        }
        // 读取结束
    }
    public static void copy3(Reader in, Writer out) throws IOException {
        char[] chars = new char[1024];
        int readCount;
        while ((readCount = in.read(chars)) != -1) {
            // 写入数据
            // 读多少写多少
            out.write(chars, 0, readCount);
        }
        // 读取结束
    }
}
