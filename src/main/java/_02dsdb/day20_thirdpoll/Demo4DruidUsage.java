package _02dsdb.day20_thirdpoll;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author Kiro
 * @Date 2023/12/01 11:01
 **/
public class Demo4DruidUsage {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        ExecuteQueryByConnection.query(connection);


    }
}
