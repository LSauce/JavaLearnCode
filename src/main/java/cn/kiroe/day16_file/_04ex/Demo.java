package cn.kiroe.day16_file._04ex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 17:24 31/10/2023
 **/
/*
判断某个目录(单级)下有没有a.jpg文件,有的话输出
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();

        findAllFile("src/",".java",files);
        System.out.println("files = " + files);

    }

    /**
     * 多吃查询
     *
     * @param dir    路径名
     * @param target 目标文件
     * @return
     */
    public static void findAllFile(String dir, String target, List<File> result) {
        if (dir == null || target == null) {
            return;
        }
        List<File> list = new ArrayList<>();
        // 获取文件名字
        File dirFile = new File(dir);
        if (dirFile.isFile()) {
            return;
        }
        // 获取当前目录的 文件和文件夹
        File[] files = dirFile.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(target)) {
                    result.add(file);
                    return;
                }
            } else {
                findAllFile(file.getPath(), target, result);
            }


        }

    }


    /**
     * 单层搜索
     *
     * @param dir    路径名
     * @param target 目标文件
     * @return
     */
    public static File hasTheFile(String dir, String target) {
        if (dir == null || target == null) {
            return null;
        }
        // 获取文件名字
        File dirFile = new File(dir);
        if (dirFile.isFile()) {
            return null;
        }
        File[] files = dirFile.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().equals(target)) {
                return new File("dir" + target);
            }
        }
        // 找 target文件
        return dirFile;
    }
}
