package cn.kiroe.day16_file._03api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kiro
 * @description:
 * @data 17:14 31/10/2023
 **/
public class Demo5 {

    public static void main(String[] args) {

        File file = new File("aa");
        // 获取File对象表示的抽象文件的绝对路径
        // public String getAbsolutePath()
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());
        // 获取File对象表示的抽象文件，路径名字符串
        // public String getPath()
        System.out.println("file.getPath() = " + file.getPath());
        // 获取文件或者目录的名字
        // public String getName()
        System.out.println("file.getName() = " + file.getName());
        // 返回由此抽象路径名表示的文件的长度。不能返回文件夹的长度
        // 此抽象路径名表示的文件的长度，以字节为单位；如果文件不存在，则返回 0L
        // public long length ()
        System.out.println("file.length() = " + file.length());
        // 返回此抽象路径名表示的文件最后一次被修改的时间。
        // 表示文件最后一次被修改的时间的 long 值，用与时间点（1970 年1月1日，00:00:00 GMT）之间的毫秒数表示
        // public long lastModified ()
        System.out.println("file.lastModified() = " +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date(file.lastModified())));
    }
}
