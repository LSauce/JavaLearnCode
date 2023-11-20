package cn.kiroe.day17_io._01bytestream.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author kiro
 * @description:
 * @data 10:31 1/11/2023
 **/

/*
异常处理
    1. 传统 try-catch-finally
        注意两点：
            a. 输出流，输入流声明写在try外面
            b. close 之前 做null的校验
    2. try-with-resources
 */
public class Demo5 {
    public static void main(String[] args) {
        // 创建输出流对象
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("b.txt", true);
            out.write("test".getBytes());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // close 资源的释放
            try {
                // 防止报错，无对象，空指针异常
                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

