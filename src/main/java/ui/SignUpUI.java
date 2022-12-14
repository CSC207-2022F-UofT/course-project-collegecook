package ui;

import login.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUpUI extends JFrame implements SignUpBox {
    JPanel login = new JPanel();
    JButton loginButton = new JButton("Sign Up");
    JPasswordField passwordField = new JPasswordField(15);
    JTextField userName = new JTextField(15);
    JPanel passwordPanel = new JPanel();
    JPanel userNamePanel = new JPanel();
    JLabel title = new JLabel("CollegeCook");
    JLabel userNameLabel = new JLabel("Name: ");
    JLabel passwordLabel = new JLabel("Password: ");
    AppController appController;



    public SignUpUI(AppController appController){
        this.appController = appController;
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 80));

        login.add(title);
        login.add(new JLabel(""));
        userNamePanel.add(userNameLabel);
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        userNamePanel.add(userName);

        passwordPanel.add(passwordLabel);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordPanel.add(passwordField);


        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                appController.getLoginControllor().PerformCreateAllUser(userName.getText(),
                        Arrays.toString(passwordField.getPassword()));
            }
        });
        login.add(userNamePanel);
        login.add(passwordPanel);
        login.add(loginButton);


        this.add(login);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public void createSuccess(){
        JOptionPane.showMessageDialog(null,
                "Successfully created a new account");
        UserUI loginUI = new UserUI(appController);
        loginUI.setVisible(true);
    }

    public void createFailed(){
        this.setVisible(true);
        JOptionPane.showMessageDialog(null,
                "Please choose another username");
    }

}
