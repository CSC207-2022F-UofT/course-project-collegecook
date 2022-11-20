package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeUI extends JFrame {
    JPanel welcome = new JPanel();
    JButton login = new JButton("Log In" );
    JButton signUp = new JButton("Sign Up");
    JLabel title = new JLabel("CollegeCook");


    public WelcomeUI(String user){
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        welcome.add(title);
        welcome.add(new JLabel(""));

        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginUI loginUI = new LoginUI();
                loginUI.setVisible(true);
            }
        });

        welcome.add(login);
        signUp.setAlignmentX(Component.CENTER_ALIGNMENT);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUpUI signUpUI = new SignUpUI();
                signUpUI.setVisible(true);
            }
        });
        welcome.add(signUp);


        this.add(welcome);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


    public static void main(String[] args){
        WelcomeUI m = new WelcomeUI("Brenden");
        m.setVisible(true);
    }
}
