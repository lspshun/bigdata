package hvieProject;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        try {
            // 加载驱动
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            // 打开连接
            Connection conn = DriverManager.getConnection("jdbc:192.168.81.128://bigdata:10000/");
            // 获得操作对象 开启会话
            Statement statement = conn.createStatement();
            // 执行操作
            ResultSet rs=statement.executeQuery("show databases");
            // 接收数据
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
            // 释放资源
            rs.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
