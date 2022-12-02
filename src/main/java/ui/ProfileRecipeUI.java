package ui;

import profile.ProfileBox;
import profile.ProfileController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProfileRecipeUI extends JFrame implements ProfileBox {

    JPanel recipePanel = new JPanel();
    JButton createdButton = new JButton("Your Created Recipes");
    JButton  reviewedButton = new JButton("Your Reviewed Recipes");
    JLabel createdView;
    JLabel reviewedView;
    ProfileController pc;
    String username;

    public ProfileRecipeUI(AppController appController){
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        recipePanel.setLayout(new BorderLayout());
        recipePanel.add(createdButton, BorderLayout.NORTH);
        recipePanel.add(reviewedButton, BorderLayout.SOUTH);

        createdButton.addActionListener(e -> {
            try {
                pc.performAllCreated(username);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your profile. ");
            }
        });

        reviewedButton.addActionListener(e -> {
            try {
                pc.performAllReviewed(username);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your profile. ");
            }
        });
        this.add(recipePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    @Override
    public void noCreated() {
        JOptionPane.showMessageDialog(null, "You have no created recipes. ");
    }

    @Override
    public void hasCreated(String result) {
        createdView = new JLabel(result);
        createdView.setText("<html>" + result.replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        createdView.setAlignmentX(Component.CENTER_ALIGNMENT);
        createdView.setFont(new Font("Monaco", Font.PLAIN, 15));
        recipePanel.add(createdView, BorderLayout.CENTER);

        this.add(recipePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void noReviewed() {
        JOptionPane.showMessageDialog(null, "You have no reviewed recipes. ");
    }

    @Override
    public void hasReviewed(String result) {
        reviewedView = new JLabel(result);
        reviewedView.setText("<html>" + result.replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        reviewedView.setFont(new Font("Monaco", Font.PLAIN, 15));
        recipePanel.add(reviewedView, BorderLayout.AFTER_LAST_LINE);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
