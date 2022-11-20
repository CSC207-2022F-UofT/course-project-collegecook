package ui;

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

    public SearchRecipeUI(RecipeController recipeController, RecipeOutputBoundary recipeOutputBoundary){
        this.recipeController = recipeController;
        this.recipeOutputBoundary = recipeOutputBoundary;
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
        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();
        RecipeViewBox recipeViewBox = new ViewRecipeUI();
        recipeOutputBoundary.setUI(recipeViewBox);
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeInputBoundary recipeInputBoundary = new RecipeInteractor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);
        SearchRecipeUI m = new SearchRecipeUI(recipeController, recipeOutputBoundary);
        m.setVisible(true);

    }
}
