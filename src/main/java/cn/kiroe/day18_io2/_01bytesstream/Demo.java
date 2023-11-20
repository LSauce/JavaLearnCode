package cn.kiroe.day18_io2._01bytesstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.util.Optional;

/**
 * @author kiro
 * @description:
 * @data 09:50 2/11/2023
 **/
public class Demo {
    public static void main(String[] args) {

        File file = new File("io/TestFiles/fds");

        Optional.ofNullable(file).ifPresent(System.out::print);

    }
}
