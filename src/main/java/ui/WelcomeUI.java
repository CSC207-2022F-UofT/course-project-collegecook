package ui;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends JFrame {
    JPanel welcome = new JPanel();
    JButton login = new JButton("Log In" );
    JButton signUp = new JButton("Sign Up");
    JLabel title = new JLabel("CollegeCook");
    AppController appController;

    public WelcomeUI(AppController appController){
        this.appController = appController;
        welcome.setLayout(new BoxLayout(welcome, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        welcome.add(title);
        welcome.add(new JLabel(""));

        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener(e -> {
            dispose();
            UserUI loginUI = new UserUI(appController);
            loginUI.setVisible(true);
        });

        welcome.add(login);
        signUp.setAlignmentX(Component.CENTER_ALIGNMENT);

        signUp.addActionListener(e -> {
            dispose();
            SignUpUI signUpUI = new SignUpUI(appController);
            signUpUI.setVisible(true);
        });
        welcome.add(signUp);


        this.add(welcome);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }



}
