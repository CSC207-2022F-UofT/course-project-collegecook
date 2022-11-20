package ui;

import login.*;
import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchRecipeUI extends JFrame {
    RecipeController recipeController;
    RecipeOutputBoundary recipeOutputBoundary;
    JPanel view = new JPanel();
    JTextField name = new JTextField();
    JButton read = new JButton("Read");

    public SearchRecipeUI(AppController appController){
        this.recipeController = appController.getRecipeController();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(name);

        read.setAlignmentX(Component.CENTER_ALIGNMENT);
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recipeController.performReadRecipe(name.getText());
            }
        });
        view.add(read);


        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
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
//        AppController appController = new AppController(recipeController, loginControllor);
//        RecipeViewBox recipeViewBox = new ViewRecipeUI(appController);
//        recipeOutputBoundary.setUI(recipeViewBox);
//        SearchRecipeUI m = new SearchRecipeUI(appController);
//        m.setVisible(true);

    }
}
