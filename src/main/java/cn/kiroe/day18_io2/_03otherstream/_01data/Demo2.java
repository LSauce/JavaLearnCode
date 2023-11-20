package cn.kiroe.day18_io2._03otherstream._01data;

import java.io.*;

/**
 * @author kiro
 * @description:
 * @data 16:05 2/11/2023
 **/
public class Demo2 {
    public static void main(String[] args) {
        writeData();
        readData();
    }

    private static void readData() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("IOTest/a.txt"))) {
            int i = in.readInt();
            double v = in.readDouble();
            System.out.println("i+v = " + i + " " + v);

            int readCount;
            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while ((readCount = in.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,readCount));
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeData() {
        // 创建输出流对象
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("IOTest/a.txt"))) {
            dataOutputStream.writeInt(1000);
            dataOutputStream.writeDouble(3.14);

            dataOutputStream.write("你好啊啊fasdfad".getBytes());
            dataOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // writeInt
        // wireteDouble
    }
}
