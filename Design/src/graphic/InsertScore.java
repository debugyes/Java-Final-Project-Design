package graphic;

import Logic.JDBC_ADD;
import Logic.JDBC_QUERY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class InsertScore {
    public InsertScore() throws Exception {
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
        MenuItem mi4 = new MenuItem("查学生");
        MenuItem mi5 = new MenuItem("查课程");
        MenuItem mi6 = new MenuItem("查成绩");

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        MenuBar.add(m2);
        MenuBar.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jFrame.setMenuBar(MenuBar);

        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                try {
                    new Student();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                try {
                    new Course();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mi6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                try {
                    new Score();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


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
                jFrame.setVisible(false);
                try {
                    new InsertScore();
                } catch (Exception ex) {
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

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        JLabel jLabel1 = new JLabel("学号");
        JTextField jTextField1 = new JTextField("", 30);
        jPanel2.add(jLabel1);
        jPanel2.add(jTextField1);

        JPanel jPanel3 = new JPanel();
        JLabel jLabel2 = new JLabel("课程号");
        JTextField jTextField2 = new JTextField("",30);
        jPanel3.add(jLabel2);
        jPanel3.add(jTextField2);

        JPanel jPanel4 = new JPanel();
        JLabel jLabel3 = new JLabel("成绩");
        JTextField jTextField3 = new JTextField("", 30);
        jPanel4.add(jLabel3);
        jPanel4.add(jTextField3);

        JPanel jPanel5 = new JPanel();
        JButton jButton = new JButton("提交");
        jPanel5.add(jButton);

        JPanel jPanel6 = new JPanel();
        jPanel6.setLayout(new GridLayout(4, 1));
        jPanel6.add(jPanel2);
        jPanel6.add(jPanel3);
        jPanel6.add(jPanel4);
        jPanel6.add(jPanel5);
        jFrame.add(jPanel6, BorderLayout.CENTER);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sid = jTextField1.getText();
                String cid = jTextField2.getText();
                int grade = Integer.parseInt(jTextField3.getText());
                try {
                    JDBC_ADD.addscore(sid, cid, grade);
                } catch (Exception ex) {
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
        jFrame.setVisible(true);
    }
}
