package cn.kiroe.day16_file._03api;

import java.io.File;

/**
 * @author kiro
 * @description:
 * @data 16:54 31/10/2023
 **/

/*

删除功能
 */
public class Demo3 {
    public static void main(String[] args) {
        // 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除
        // delete不会因为文件不存在,路径名不正确而抛出异常,只会返回false, 并且不会进入回收站
        // public boolean delete()
        File file = new File("aaa/bbb/cc/cccc");
        file.mkdirs();
        File file1 = new File("aaa/bbb");
        System.out.println(        file1.delete());

    }
}
