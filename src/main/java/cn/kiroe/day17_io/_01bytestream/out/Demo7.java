package cn.kiroe.day17_io._01bytestream.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kiro
 * @description:
 * @data 11:05 1/11/2023
 **/

/*

验证try-with-resources 自动释放
 */
public class Demo7 {

    public static void main(String[] args) throws SQLException {

        try (A a  = new A()){
            a.func();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Connection connection = DriverManager.getConnection("http://127.0.0.1");

    }
}

class A implements AutoCloseable {


    public void func(){
        System.out.println("fucn 执行了");
    }
    @Override
    public void close() throws Exception {
        System.out.println("释放了");
    }
}
