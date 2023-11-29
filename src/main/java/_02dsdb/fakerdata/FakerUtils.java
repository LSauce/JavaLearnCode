package _02dsdb.fakerdata;


import net.datafaker.Faker;
import org.junit.Test;

import java.sql.*;
import java.util.Locale;

/**
 * @author kiro
 * @description:
 * @data 15:31 25/11/2023
 **/
public class FakerUtils {
    public static void main(String[] args) {
        testFaker();
    }

    public static void  testFaker(){
        Faker faker = new Faker(new Locale("zh_cn"));

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        for (int i = 0; i < 10; i++) {
            System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
            System.out.println("faker.animal().name() = " + faker.animal().name());
        }
    }
    @Test
    public  void testJDBC(){
        String url = "jdbc:mysql://192.168.4.16:3306/homework_55th";
        String username = "root";
        String password = "123321";

        try(Connection connection = DriverManager.getConnection(url, username,password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "-" + name);
            }

            // 获取字段
            System.out.println("获取字段");
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet studentResultSet = metaData.getColumns(null, null, "student", null);
            while (studentResultSet.next()){
                String name = studentResultSet.getString("COLUMN_NAME");
                System.out.println("name = " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
