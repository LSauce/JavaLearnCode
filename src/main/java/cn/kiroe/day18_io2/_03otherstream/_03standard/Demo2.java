package cn.kiroe.day18_io2._03otherstream._03standard;

import java.io.*;
import java.util.stream.Stream;

/**
 * @author kiro
 * @description:
 * @data 17:12 2/11/2023
 **/
/*
练习：利用System.in 完成Scanner的nextLine()的功能。
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {

        ScannerD scannerD = new ScannerD(FileDescriptor.in);
        String string = scannerD.nextLine();
        System.out.println("string = " + string);
        String string1 = scannerD.mulLine();
        System.out.println(string1);
    }
}


class ScannerD {

    private FileDescriptor in;
    private BufferedReader bufferedReader;

    public ScannerD(FileDescriptor in) {
        this.in = in;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
    }

    public String nextLine() throws IOException {
        return  bufferedReader.readLine();
    }
    // 多次输入 end结束
    public String mulLine() throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line= bufferedReader.readLine())!=null && !line.equals("end")){
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }
}