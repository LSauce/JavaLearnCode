package cn.kiroe.day19_thread1.homework.work3;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 19:27 3/11/2023
 **/
/*
使用多线程实现方式一来实现多个文件一起复制功能(3个线程复制3个文件)，
并在控制台显示复制的进度，进度以百分比表示

例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
注: 为了更好的显示百分比推荐使用字节流进行复制操作
提示: 进度可以用当前已循环读写的字节和除以文件大小字节
 */
public class ThreadWork2 {
    public static void main(String[] args) {
        File sourceDir = new File("IOTest");
        File targetDir = new File("IOTest/target");
        new FileUtils2().multithreadedCopy(sourceDir, targetDir);

    }


}

// 使用多线程实现方式一来实现多个文件一起复制功能(3个线程复制3个文件)，
// 传入 文件list，和目标路径，使用多线程将文件复制到 目标路径
class FileUtils2 {
    public boolean multithreadedCopy(File sourceDir, File targetDir) {
        if (sourceDir == null || targetDir == null || sourceDir.isFile() || targetDir.isFile()) {
            return false;
        }
        // 创建目标目录
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        // 获取目录下文件
        File[] files = sourceDir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File sourceFile = files[i];
            if (sourceFile.isFile()) {
                File targetFile = new File(targetDir.getPath() + "/" + sourceFile.getName());
                Thread thread = new FileCopyThread(sourceFile, targetFile);
                thread.setName("CopyThread-" + i);
                thread.start();
            }
        }

        return true;
    }

    // 复制文件
    // 如何获取当前进度
    static class FileCopyThread extends Thread {
        // 当前进度
        private File sourceFile;
        private File targetFile;

        private long copied = 0;

        public FileCopyThread(File sourceFile, File targetFile) {
            this.sourceFile = sourceFile;
            this.targetFile = targetFile;
        }

        @Override
        public void run() {
            copyFile(sourceFile, targetFile);
        }

        private void copyFile(File sourceFile, File targetFile) {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile));
                 BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile))) {
                // 边读取，变写入
                byte[] bytes = new byte[1024];
                long totalSize = sourceFile.length();
                copied = 0;
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    out.write(bytes, 0, readCount);
                    copied += readCount;
                    System.out.println(Thread.currentThread().getName()+"线程: 目前进度为" + (copied * 100) / totalSize + "%");
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 传入
    }
}


