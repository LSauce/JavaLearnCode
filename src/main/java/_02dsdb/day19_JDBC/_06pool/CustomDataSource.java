package _02dsdb.day19_JDBC._06pool;

import _02dsdb.day19_JDBC.JDBCUtil;
import cn.kiroe.day22_network.upd.v4.OnePerson;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author Kiro 实现直接的 连接池
 * @Date 2023/11/30 17:39
 **/

/*
连接池 功能
1. 获取连接，对外提供连接
2. 释放连接，对外归还的功能
3. 当池子为空时创建,最大大小为 MAX_CAPACITY

// 下面代码有哪些改进
// 1. 连接池的大小
// 下面代码如何改成单例模式
 */
public class CustomDataSource {

    private CustomDataSource() {

    }
    public static CustomDataSource getInstance() {
        if(instance == null){
            synchronized (CustomDataSource.class){
                if(instance == null){
                    instance = new CustomDataSource();
                }
            }
        }
        return instance;
    }

    private static CustomDataSource instance;

    private  static final int MAX_CAPACITY;
    private static final Deque<Connection> connections = new ArrayDeque<>();
    private static final Set<Connection> connectionUsedSet = new HashSet<>();
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/java/_02dsdb/day19_JDBC/jdbc.properties"));
            MAX_CAPACITY = Integer.parseInt(properties.getProperty("MAX_CAPACITY"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            try {
                connections.offer(JDBCUtil.getConnection());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connections.isEmpty()){
            // 池子空了，没连接了,创建
            if(connectionUsedSet.size() < MAX_CAPACITY){
                connections.offer(JDBCUtil.getConnection());
            }else{
                return null;
            }

        }
        // 从集合中取 一个出来
        Connection poll = connections.poll();
        connectionUsedSet.add(poll);
        return poll;

    }

    public static void returnConnection(Connection connection){
        // 归回
        connections.offer(connection);
        connectionUsedSet.remove(connection);
    }

}


class CustomDataSourceTest{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 从池子获取连接
        for (int i = 0; i < 20; i++) {
            Connection connection = CustomDataSource.getConnection();
            if (connection == null){
                System.out.println(i+"用完了");
            }
        }
    }
}