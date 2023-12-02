package _02dsdb.day20_thirdpoll;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author Kiro
 * @Date 2023/12/01 11:11
 **/
public class Demo5HikaricpUsage {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/hikariCP.properties"));
        HikariConfig hikariConfig = new HikariConfig(properties);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        Connection connection = dataSource.getConnection();
        ExecuteQueryByConnection.query(connection);
        connection.close();


    }
}
