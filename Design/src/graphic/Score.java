package graphic;

import Logic.JDBC_QUERY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Score {
    public Score() throws SQLException {
        JFrame jFrame = new JFrame("金陵科技学院学生管理系统");
        jFrame.setBounds(600, 400, 1200, 800);

        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        MenuBar MenuBar = new MenuBar();
        Menu m1 = new Menu("文件");
        MenuItem mi1 = new MenuItem("个人中心");
        MenuItem mi2 = new MenuItem("帮助");
        MenuItem mi3 = new MenuItem("退出");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        MenuBar.add(m1);
        MenuBar.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jFrame.setMenuBar(MenuBar);

        Menu m2 = new Menu("操作");
        MenuItem mi4 = new MenuItem("查班级");
        MenuItem mi5 = new MenuItem("查课程");
        MenuItem mi6 = new MenuItem("查学生");
        MenuItem mi7 = new MenuItem("查成绩");

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        MenuBar.add(m2);
        MenuBar.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jFrame.setMenuBar(MenuBar);


        JPanel jPanel1 = new JPanel(new GridLayout(4, 1));
        JButton jbtn1 = new JButton("查学生");
        JButton jbtn2 = new JButton("查课程");
        JButton jbtn3 = new JButton("查成绩");
        JButton jbtn4 = new JButton("录入成绩");
        jPanel1.add(jbtn1);
        jPanel1.add(jbtn2);
        jPanel1.add(jbtn3);
        jPanel1.add(jbtn4);
        jFrame.add(jPanel1, BorderLayout.WEST);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(0, 1));
        JScrollPane jScrollPane = JDBC_QUERY.selectScore();
        jPanel.add(jScrollPane);
        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);

        //给查学生按钮绑定动作

        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jFrame.setVisible(false);
                    new Student();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //给查课程按钮绑定动作
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jFrame.setVisible(false);
                    new Course();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //给查成绩按钮绑定动作
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jFrame.setVisible(false);
                    new Score();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //插入成绩
        jbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                try {
                    new InsertScore();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
