package _02dsdb.day20_thirdpoll;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author Kiro
 * @Date 2023/12/01 09:46
 **/
public class DBCPDemo1 {
    public static String propertiesFile = "src/main/java/_02dsdb/day20_thirdpoll/dbcp.properties";

    public static void main(String[] args) {
        // DataSource

    }

    @Test
    public void DBCPTest() throws IOException {
        System.out.println("DBCPTest");
        Properties properties = new Properties();
        properties.load(new FileReader(propertiesFile));

        try (BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties)) {
            Connection connection = dataSource.getConnection();

            ExecuteQueryByConnection.query(connection);
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
