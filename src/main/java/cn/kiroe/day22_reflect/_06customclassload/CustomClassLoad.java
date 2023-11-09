package cn.kiroe.day22_reflect._06customclassload;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 09:43 8/11/2023
 **/
public class CustomClassLoad extends ClassLoader{

    public CustomClassLoad(String path) {
        this.path = path;
    }

    private String path ;
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 想要加载 类，需要使用 defineClass() 方法
        //  protected final Class<?> defineClass(String name, byte[] b, int off, int len)
        //         throws ClassFormatError
        //     {
        //         return defineClass(name, b, off, len, null);
        //     }
        // 读取文件


        File file = new File(path);
        byte[] data = getData(file);
        Class c =  defineClass(name,data,0, (int) file.length());
        //   private native Class<?> defineClass1(String name, byte[] b, int off, int len,
        //                                          ProtectionDomain pd, String source);
        // 最终执行完 要返回Class对象
        return c;
    }



    private static byte[] getData(File file) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] data = new byte[(int) file.length()];
            // 一次性读完
            inputStream.read(data);
            return data;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
