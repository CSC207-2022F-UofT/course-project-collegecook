package ui;

import recipe.*;

import javax.swing.*;
import java.awt.*;

public class ViewRecipeUI extends JFrame implements RecipeViewBox {
    JPanel view = new JPanel();
    JLabel all;
    JLabel user;
    JPanel buttonPanel = new JPanel();
    JButton review = new JButton("Review");
    JButton mealPlan = new JButton("Add to My Meal Plan");
    AppController appController;

    public ViewRecipeUI(AppController appController){
        this.appController = appController;
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
    }
    @Override
    public void success(String result){
        all = new JLabel(result);
        all.setText("<html>" + result.replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        all.setAlignmentX(Component.CENTER_ALIGNMENT);
        all.setFont(new Font("Monaco", Font.PLAIN, 15));
        view.add(all);

        buttonPanel.add(review);
        buttonPanel.add(mealPlan);
        view.add(buttonPanel);
        this.add(view);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void failure(){
        JOptionPane.showMessageDialog(null,"Sorry, the recipe doesn't exist");
    }

}
