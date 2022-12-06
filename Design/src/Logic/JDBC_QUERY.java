package Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class JDBC_QUERY {
    public JDBC_QUERY(){

    }

    public static boolean selectpassword(String usernameGet, String passwordGet) throws Exception{
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select * from login";
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);
        boolean flag = false;
        while(rs.next()) {
            String usernameQuery = rs.getString("username");
            String passwordQuery = rs.getString("password");
            if (usernameQuery.equals(usernameGet)&& passwordQuery.equals(passwordGet)) {
                flag = true;
            }
            else {
                flag = false;
            }
        }
        return flag;
    }
    public static JScrollPane selectStudent() throws Exception {
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select * from student";
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //开始构建数据表格
        DefaultTableModel model = new DefaultTableModel();
        JTable jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setModel(model);

        ResultSetMetaData rsmd = rs.getMetaData();
        int column = rsmd.getColumnCount();
        for (int i = 1; i <= column; i++) {
            model.addColumn(rsmd.getColumnName(i));
        }

        String[] row = new String[column];
        while(rs.next()){
            for (int i = 0; i < column; i++) {
                row[i] = rs.getString(i+1);
            }
            model.addRow(row);
        }
        return jScrollPane;
    }

    public static JScrollPane selectCourse() throws SQLException {
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select * from Course";
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //开始构建数据表格
        DefaultTableModel model = new DefaultTableModel();
        JTable jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setModel(model);

        ResultSetMetaData rsmd = rs.getMetaData();
        int column = rsmd.getColumnCount();
        for (int i = 1; i <= column; i++) {
            model.addColumn(rsmd.getColumnName(i));
        }

        String[] row = new String[column];
        while(rs.next()){
            for (int i = 0; i < column; i++) {
                row[i] = rs.getString(i+1);
            }
            model.addRow(row);
        }
        return jScrollPane;
    }

    public static JScrollPane selectScore() throws SQLException {
        //1. 获取数据连接connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "011126";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select student.sid, student.sname, course.cname, Score.grade from student, " +
                "course, score where student.sid = score.sid and score.cid = course.cid";
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //开始构建数据表格
        DefaultTableModel model = new DefaultTableModel();
        JTable jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setModel(model);

        ResultSetMetaData rsmd = rs.getMetaData();
        int column = rsmd.getColumnCount();
        for (int i = 1; i <= column; i++) {
            model.addColumn(rsmd.getColumnName(i));
        }

        String[] row = new String[column];
        while(rs.next()){
            for (int i = 0; i < column; i++) {
                row[i] = rs.getString(i+1);
            }
            model.addRow(row);
        }
        return jScrollPane;
    }
}
