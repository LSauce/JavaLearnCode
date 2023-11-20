package cn.kiroe.day16_file.homework.ex5;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 19:57 31/10/2023
 **/
/*
需求:递归删除目录与文件
在非系统盘下找一个位置新建一个文件夹,然后在文件夹中放入一些文件,然后继续新建二级目录...三级目录..
要求递归删除这个目录
注意:
     1.不要在C盘/系统盘里进行操作
     2.执行delete删除之前,一定要谨慎查看路径名,避免误删
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        // 新建文件夹,准备删除
        File file = new File("a/b/c/d/e/f/g/h/i");
        file.mkdirs();
        System.out.println("file.getPath() = " + file.getPath());
        // 创建随机文件
        System.out.println("createDirsAndRandomFile(new File(\"a\")) = " + createDirsAndRandomFile(new File("a")));


        // 删除目录
        deleteAllDir(new File("a"));

    }

    /**
     * 删除该目录
     *
     * @param dir
     */
    private static boolean deleteAllDir(File dir) {
        if (dir == null || dir.isFile()) {
            return false;
        }
        //没有目录就创建
        if( !dir.exists()){
            dir.mkdir();
        }
        // 递归删除
        // 获取所有文件
        Arrays.stream(Objects.requireNonNull(dir.listFiles())).forEach((d) -> {
            if (d.isFile()) {
                d.delete();
            } else {
                    deleteAllDir(d);

            }
        });
        dir.delete();
        return true;
    }

    /**
     * 创建，文件夹并随机生成文件在目录中
     *
     * @param dir
     * @return
     */
    public static boolean createDirsAndRandomFile(File dir) throws IOException {
        if (dir == null || dir.isFile()) {
            return false;
        }
        // 使用栈在所有 子目录下 生成文件
        Stack<File> stack = new Stack<>();
        stack.push(dir);
        while (!stack.empty()) {
            // 获取当前子目录
            File dirI = stack.pop();
            File[] dirs = dirI.listFiles(File::isDirectory);
            Arrays.stream(dirs).forEach(stack::push);// 添加进 子目录
            // 生成随机文件
            createRandomFileInDir(dirI);
        }
        return true;
    }

    public static boolean createRandomFileInDir(File dir) throws IOException {
        if (dir == null || dir.isFile()) {
            return false;
        }
        // 没有目录创建目录
        if(!dir.exists()){
            dir.mkdirs();
        }

        Random random = new Random();
        // 生成文件数量随机
        int number = random.nextInt(10);
        for (int i = 0; i < number; i++) {
            File randomFile = new File(dir.getPath() + "/" + dir.getName() + i + ".random");
            randomFile.createNewFile();
        }
        return true;
    }

}
