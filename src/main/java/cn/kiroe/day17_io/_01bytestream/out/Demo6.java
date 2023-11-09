package cn.kiroe.day17_io._01bytestream.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kiro
 * @description:
 * @data 11:02 1/11/2023
 **/
/*
try-with-resources
语法:
    try(资源 实现了AutoCloseable类的对象){

    } catch(){

    } catch(){
    }
 */
public class Demo6 {

    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("b.txt",true)){
            outputStream.write("test".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
