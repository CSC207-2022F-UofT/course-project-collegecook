package ui;

import login.*;
import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpUI extends JFrame {
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
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                Menu menu = new Menu(userName.getText());
//                menu.setVisible(true);
//            }
//        });
        login.add(userNamePanel);
        login.add(passwordPanel);
        login.add(loginButton);


        this.add(login);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


    public static void main(String[] args){
        UserGateWay userGateWay = UserRepoImpl.getUserRepoImpl();
        LoginOutputBound loginOutputBound = new LoginPresenter();
        UserManager userManager = new UserManager(loginOutputBound);
        LoginControllor loginControllor = new LoginControllor(userManager);

        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);

        AppController appController1 = new AppController(recipeController, loginControllor);
        SignUpUI m = new SignUpUI(appController1);
        m.setVisible(true);
    }
}
