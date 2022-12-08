package ui;

import recipe.*;

import javax.swing.*;
import java.awt.*;



public class SearchRecipeUI extends JFrame {
    RecipeController recipeController;

    JPanel view = new JPanel();
    JTextField name = new JTextField();
    JButton read = new JButton("Read");

    public SearchRecipeUI(AppController appController){
        this.recipeController = appController.getRecipeController();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(name);

        read.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.recipeController = appController.getRecipeController();
        read.addActionListener(e -> {
            dispose();
            recipeController.performReadRecipe(name.getText());
        });
        view.add(read);


        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

}
