package cn.kiroe.day18_io2._03otherstream._02print;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author kiro
 * @description:
 * @data 16:30 2/11/2023
 **/
/*
使用打印流
 */
public class Demo2 {

    public static void main(String[] args) {

        // printStream();

        //想要使用  autoFlush，当使用 println(),format(Locale l, String format, Object ... args),printf(Locale l, String format, Object ... args)

        try(PrintWriter printWriter = new PrintWriter("IOTest/a.txt", String.valueOf(true))){
            printWriter.println(10000);
            printWriter.println(1000);
            printWriter.format("%d",12);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printStream() {
        try (PrintStream printStream = new PrintStream("IOTest/a.txt")){
            printStream.print(3.14);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
