package cn.kiroe.day17_io._01bytestream.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 10:24 1/11/2023
 **/

/*


 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt",true);


        fileOutputStream.write("abcd\r".getBytes());

        fileOutputStream.close();
    }
}
