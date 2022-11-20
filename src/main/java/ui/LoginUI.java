package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    JPanel login = new JPanel();
    JButton loginButton = new JButton("Login");
    JPasswordField passwordField = new JPasswordField("Password: ", 15);
    JTextField userName = new JTextField("Username", 15);
    JLabel title = new JLabel("CollegeCook");


    public LoginUI(){
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));
        login.add(title);
        login.add(new JLabel(""));

        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.add(userName);

        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.add(passwordField);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CreateRecipeUI createRecipeUI = new CreateRecipeUI();
//                createRecipeUI.setVisible(true);
//            }
//        });

        login.add(loginButton);


        this.add(login);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


    public static void main(String[] args){
        LoginUI m = new LoginUI();
        m.setVisible(true);
    }
}
