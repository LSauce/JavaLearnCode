package cn.kiroe.day23_annotation._04handle;


import java.io.File;
import java.sql.Connection;

/**
 * @author kiro
 * @description:
 * @data 15:00 8/11/2023
 **/
public class DBUtils {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("\"  dfsdfdfsf fdsf   df  sf  asdf\".trim() = " + "     fsdfds  fdsf   df  sf  asdf".trim());
        System.out.println("\"dfasdf fasdf fasdf fadsf dasfasdf fdsafs   fasdfasd fasdf\".replace(\" \",\"\") = " + "dfasdf fasdf fasdf fadsf dasfasdf fdsafs   fasdfasd fasdf".replace(" ", ""));

        try {
            test();
        }catch (Exception e){
            System.out.println("异常了");
        }

        new File("");
    }
    public static void test2() throws ClassNotFoundException {
        test();
    }
    public static void test(){
        System.out.println(10/0);
    }
    @DBConfig(username = "root",password = "123321")
    public static Connection getConnection(){
        // 将字节码类对象 传给某个没，让其处理连接

        return null;
    }


}


@interface DBConfig{

    String username();
    String password();

}


