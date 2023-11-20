package cn.kiroe.day18_io2.homework.ex3;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 * @author kiro
 * @description:
 * @data 20:13 2/11/2023
 **/
/*
(选做)指定一个目录，先递归查找指定目录
(包括其下级子目录)中所有的".java"文件并且，
把所有这些找到的java文件，
复制(是复制不是移动)到一个指定的目录下。

也就是先递归查找文件，再复制文件。

注：文件复制可以用字节流，也可以用字符流，实现功能即可。
 */
public class Work {

    public static void main(String[] args) {
        File sourceFile = new File("src");// 中的Java文件
        File targetFile = new File("IOTest/src_copy");// 复制文件

        // 获取文件并操作
        // 设置栈
        Stack<File> files =new Stack<>();
        files.push(sourceFile);
        while (!files.isEmpty()){
            File tFile = files.pop();
            // 如果为目录添加
            if (tFile.isFile() && tFile.getName().endsWith(".java")){
                // 复制文件
                copyFile(tFile,new File(targetFile.getPath()+"/"+tFile.getPath()));
            }else {
                // 先建立文件夹
                File dir = new File(targetFile.getPath()+"/"+tFile.getPath());
                dir.mkdirs();
                // 加入文件迭代
                files.addAll(Arrays.asList(Objects.requireNonNull(tFile.listFiles())));
            }
        }

    }

    public static boolean copyFile(File source, File target) {
        if (source == null || target == null || !source.exists()) {
            return false;
        }
        // 使用迭代寻找文件
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(target));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source))) {

            // 读取文件
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


}
