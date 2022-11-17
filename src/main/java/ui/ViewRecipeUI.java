package ui;

import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRecipeUI extends JFrame {
    JPanel view = new JPanel();
    JLabel all;
    JButton read = new JButton("Read");
    RecipeOutputBoundary recipeOutputBoundary = new RecipePresenter();

    public ViewRecipeUI(String result){
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        all = new JLabel(result);
        all.setText("<html>" + result.replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        all.setAlignmentX(Component.CENTER_ALIGNMENT);
        all.setFont(new Font("Monaco", Font.PLAIN, 15));
        view.add(all);

        JPanel buttonPanel = new JPanel();
        JButton review = new JButton("Review");
        JButton mealPlan = new JButton("Add to My Meal Plan");
        buttonPanel.add(review);
        buttonPanel.add(mealPlan);
        view.add(buttonPanel);

        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
