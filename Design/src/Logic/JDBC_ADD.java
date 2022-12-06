package Logic;

import java.sql.*;

public class JDBC_ADD {
    public JDBC_ADD(){}

    /**
     * 插入账号密码
     * @param usernameGet 从TextField获得的用户名
     * @param passwordGet 从TextField获得的密码
     */
    public static void addusername(String usernameGet, String passwordGet) throws SQLException {
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "insert into login values (\'"+usernameGet+"\', \'"+passwordGet+"\')";
        System.out.println(sql);
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        stmt.execute(sql);
    }

    public static void addscore(String sid, String cid, int grade) throws Exception {
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "insert into score values ("+sid+","+cid+","+grade+")";
        System.out.println(sql);
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        stmt.execute(sql);
    }

}
