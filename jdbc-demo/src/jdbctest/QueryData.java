package jdbctest;

import java.sql.*;

/**
 * @Description: Java利用jdbc连接数据库实现查询
 * @Author: zhangxy
 * @Date: Created in 15:44 2019/9/24
 * @Modified By:
 */
public class QueryData {

    public static void main(String[] args) throws Exception {
        // 连接数据库时使用的url
        String url = "jdbc:mysql://localhost:3306/jdbcStudy";
        // 连接数据时使用的用户名
        String username = "root";
        // 连接数据库时使用的密码
        String password = "root";

        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.获取向数据库发送sql语句的statement
        Statement stat = conn.createStatement();
        // 4.向数据库发送sql，并获取结果集
        String sql = "select * from users";
        ResultSet rs = stat.executeQuery(sql);
        // 5.取出数据
        while (rs.next()) {
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }
        // 6.关闭连接
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stat = null;
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
