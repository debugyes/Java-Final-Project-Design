package graphic;

import Logic.JDBC_QUERY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Login{
    public static void main(String[] args) {
        new Login();
    }
    public Login(){
        //设置装标题的panel
        JPanel jp1 = new JPanel();
        JLabel hello = new JLabel("金陵科技学院学生管理系统-登录");
        hello.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jp1.add(hello);

        //设置用户名的panel
        JPanel jp2 = new JPanel();
        JLabel usernameLabel = new JLabel("用户名");
        JTextField username = new JTextField("", 30);
        jp2.add(usernameLabel);
        jp2.add(username);

        //设置密码的panel
        JPanel jp3 = new JPanel();
        JLabel passwordLabel = new JLabel("  密码  ");
        JTextField password = new JTextField("", 30);
        jp3.add(passwordLabel);
        jp3.add(password);

        //设置按钮的panel
        JPanel jp4 = new JPanel();
        JButton login = new JButton("登录");
        JButton singup = new JButton("注册");
        jp4.add(login);
        jp4.add(singup);

        //设置窗体
        JFrame jframe = new JFrame("金陵科技学院学生管理系统");
        jframe.setBounds(460, 300, 600, 400);
        jframe.setLocationRelativeTo(null);
        jframe.setLayout(new GridLayout(4, 1));
        jframe.setVisible(true);
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        //panel组装进页面
        jframe.add(jp1);
        jframe.add(jp2);
        jframe.add(jp3);
        jframe.add(jp4);

        //给登录按钮添加动作绑定
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameGet = username.getText();
                String passwordGet = password.getText();
                try {
                    if (JDBC_QUERY.selectpassword(usernameGet, passwordGet)) {
                        jframe.setVisible(false);
                        new MainGUI();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //给注册按钮添加动作绑定
        singup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                new Signup();
            }
        });
    }

}
