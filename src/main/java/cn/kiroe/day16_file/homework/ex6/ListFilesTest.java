package cn.kiroe.day16_file.homework.ex6;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;

/**
 * @author kiro
 * @description:
 * @data 20:33 31/10/2023
 **/

/*

带过滤器的listFiles方法练习

自己做一个目录，里面放些一下文件，文件夹 用带过滤器的listFiles方法进行File对象的筛选

条件一：仅留下文件夹名包括a的文件夹

条件二：仅留下.txt结尾的文本文件

条件三：仅留下以a开头的文件

要求:使用Lambda表达式

无需考虑多级目录,仅考虑一级目录即可！
 */
public class ListFilesTest {

    public static void main(String[] args) throws IOException {
        // 新建文件夹,准备删除
        File file = new File("a/b/c/d/e/f/g/h/i");
        file.mkdirs();
        System.out.println("file.getPath() = " + file.getPath());
        // 生成随机文件
        File dir = new File("a");
        createDirsAndRandomFile(dir);
        // 按照条件删除
       // deleteAllDir(new File("a"));

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
        /*
        条件一：仅留下文件夹名包括a的文件夹
        条件二：仅留下.txt结尾的文本文件
        条件三：仅留下以a开头的文件
         */
        Arrays.stream(Objects.requireNonNull(dir.listFiles())).forEach((d) -> {
            if (d.isFile()) {
                // 仅留下.txt结尾的文本文件
                // 仅留下以a开头的文件
                if(!d.getName().startsWith("a") && !d.getName().endsWith(".txt")){
                    d.delete();
                }
            } else {
                //条件一：仅留下文件夹名包括a的文件夹
                if(!d.getName().contains("a")){
                    deleteAllDir(d);
                    d.delete(); // 文件夹要是空的
                }

            }
        });
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
            File randomFile = new File(dir.getPath() + "/" + dir.getName()+getRandomCharFromPoll() + i +"."+ getRandomStringFromPoll());
            randomFile.createNewFile();
        }
        return true;
    }
    public static String getRandomStringFromPoll(){
        String[] strings = {"random","txt"};
        return strings[(int) (Math.random()*strings.length)];
    }
    public static char getRandomCharFromPoll() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = '0'; i <= '9'; i++) {
            stringBuilder.append((char) i);
        }

        for (int i = 'a'; i < 'z'; i++) {
            stringBuilder.append((char) i);
        }

        for (int i = 'A'; i < 'Z'; i++) {
            stringBuilder.append((char) i);
        }

        return stringBuilder.charAt(random.nextInt(stringBuilder.length()));
    }
}
