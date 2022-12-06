package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignupSuccess {
    public SignupSuccess() throws InterruptedException {
        JFrame jframe = new JFrame("金陵科技学院学生管理系统");
        jframe.setBounds(460, 300, 400, 300);
        jframe.setLocationRelativeTo(null);
        jframe.setLayout(new GridLayout(2, 1));
        jframe.setVisible(true);
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("注册成功");
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jPanel.add(jLabel, Component.CENTER_ALIGNMENT);
        jframe.add(jPanel);

        JPanel jPanel1 = new JPanel();
        JButton jbtn_back = new JButton("返回");
        jPanel1.add(jbtn_back);
        jframe.add(jPanel1);

        jbtn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
                new Login();
            }
        });


        jframe.setVisible(true);



    }
}
