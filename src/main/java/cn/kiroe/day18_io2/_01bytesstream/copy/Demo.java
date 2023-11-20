package cn.kiroe.day18_io2._01bytesstream.copy;

import cn.kiroe.day18_io2.utils.FileUtils;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 09:52 2/11/2023
 **/
public class Demo {

    public static void main(String[] args) {

        // normalCopy();
        bufferCopy();
    }

    private static void normalCopy() {
        // 使用工具类 进行文件复制
        try (FileInputStream in = new FileInputStream("a.txt"); FileOutputStream out = new FileOutputStream("copy_a.txt")) {

            FileUtils.copyMulti(in, out);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void bufferCopy() {
        // 使用工具类 进行文件复制
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("IOTest/a.txt")); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("IOTest/copy_a.txt"))) {

            FileUtils.copyMulti(in, out);
            out.flush();
        } catch (FileNotFoundException e) {
            // 编译时异常 抛出 必须处理
            throw new RuntimeException(e);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

}
