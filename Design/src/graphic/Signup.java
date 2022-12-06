package graphic;

import Logic.JDBC_ADD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Signup {
    JFrame frame;
    // 设置按钮组件
    private JButton ok = new JButton("确定注册");
    private JButton back = new JButton("返回登录界面");

    private JLabel jlb1 = new JLabel("用户名");
    private JLabel jlb2 = new JLabel("  密码  ");

    // 设置文本框组件
    private JTextField admin = new JTextField(22);
    private JTextField password = new JTextField(22);
    //private JTextField idea=new JTextField("",33);
    public Signup(){
        //界面设计
        frame=new JFrame("用户注册");
        frame.setBounds(460, 300, 400, 300);
        frame.setLayout(new GridLayout(4,1));
        frame.setLocationRelativeTo(null);//设置窗口在屏幕位置居中


        //账号
        JPanel panel1=new JPanel();
        panel1.add(jlb1);
        panel1.add(admin);


        //密码
        JPanel panel2=new JPanel();
        panel2.add(jlb2);
        panel2.add(password);


        //注册与返回
        JPanel panel3=new JPanel();
        panel3.add(back);
        panel3.add(ok);

        JPanel panel4 = new JPanel();

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameGet = admin.getText();
                String passwordGet = admin.getText();
                try {
                    JDBC_ADD.addusername(usernameGet, passwordGet);
                    frame.setVisible(false);
                    new SignupSuccess();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }
}
