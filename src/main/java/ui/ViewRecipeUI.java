package ui;

import recipe.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewRecipeUI extends JFrame implements RecipeViewBox {
    JPanel view = new JPanel();
    JLabel all;
    JLabel user;
    JPanel buttonPanel = new JPanel();
    JButton review = new JButton("Review");
    JButton mealPlan = new JButton("Add to My Meal Plan");
    JButton folllow = new JButton("follow");
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
        folllow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String readRecipe = appController.getRecipeController().getReadingRecipe();
                String creator = appController.getRecipeController().getRecipe(readRecipe).getCreator();
                String user = appController.getLoginControllor().preformGetLoggedInUser();
                try {
                    appController.getLoginControllor().PreformFollow(user,creator);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"You have followed the creator.");;
                }
            }
        });
        buttonPanel.add(review);
        buttonPanel.add(mealPlan);
        buttonPanel.add(folllow);
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

    @Override
    public void followSuccess() {
        JOptionPane.showMessageDialog(null,"You have followed the creator.");
    }

    @Override
    public void followFailure() {
        JOptionPane.showMessageDialog(null,"You have already followed the creator.");
    }

}
