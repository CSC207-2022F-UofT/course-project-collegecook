package ui;

import login.*;
import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginUI extends JFrame implements LoginBox{
    JPanel login = new JPanel();
    JButton loginButton = new JButton("Login");
    JPasswordField passwordField = new JPasswordField(15);
    JTextField userName = new JTextField(15);

    JPanel passwordPanel = new JPanel();
    JPanel userNamePanel = new JPanel();
    JLabel title = new JLabel("CollegeCook");
    JLabel userNameLabel = new JLabel("User Name: ");
    JLabel passwordLabel = new JLabel("Password: ");
    AppController appController;


    public LoginUI(AppController appController){
        this.appController = appController;
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 100));

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
                appController.getLoginControllor().PerformLogin(userName.getText(),
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

    public void loginSuccess(){
        Menu menu = new Menu(appController);
        menu.setVisible(true);
    }

    public void loginFailed(){
        this.setVisible(true);
        JOptionPane.showMessageDialog(null,
                "Username or password failed");
    }



    public static void main(String[] args){
//        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
//        LoginOutputBound loginOutputBound = new LoginPresenter();
//        UserManager userManager = new UserManager(loginOutputBound, userGateWay);
//        LoginControllor loginControllor = new LoginControllor(userManager);
//
//        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
//        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
//        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
//        RecipeController recipeController = new RecipeController(recipeInputBoundary);
//
//        AppController appController1 = new AppController(recipeController, loginControllor);
//        LoginUI m = new LoginUI(appController1);
//        m.setVisible(true);
    }
}
