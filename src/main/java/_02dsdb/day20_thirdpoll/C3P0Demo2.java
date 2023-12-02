package _02dsdb.day20_thirdpoll;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author Kiro
 * @Date 2023/12/01 10:23
 **/
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        ExecuteQueryByConnection.query(connection);
        connection.close();
    }
}
