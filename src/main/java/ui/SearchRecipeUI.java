package ui;

import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRecipeUI extends JFrame {
    JPanel view = new JPanel();
    JTextField name = new JTextField();
    JButton read = new JButton("Read");

    public SearchRecipeUI(){
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(name);

        read.setAlignmentX(Component.CENTER_ALIGNMENT);
        RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter(new ViewRecipeUI());
        RecipeRepoGateway recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        RecipeInputBoundary recipeInputBoundary = new RecipeInterActor(recipeOutputBoundary, recipeRepoGateway);
        RecipeController recipeController = new RecipeController(recipeInputBoundary);
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
}
