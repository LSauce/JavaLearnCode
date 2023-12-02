package _02dsdb.day19_JDBC._06pool;

import _02dsdb.day19_JDBC.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 改进的地方
 * 1. 空了，创建一个
 * 2. 不能无法创建
 * @Author Kiro
 * @Date 2023/11/30 17:47
 **/
public class CusDataSourceTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 从池子中那 连接，用完归还,
        Connection connection = CustomDataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from city");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            JDBCUtil.printResultSet(resultSet);
        }

        CustomDataSource.returnConnection(connection);


    }
}
