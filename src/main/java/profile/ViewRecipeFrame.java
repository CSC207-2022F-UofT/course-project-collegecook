package profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewRecipeFrame extends JFrame implements ProfileBox{

    JPanel recipePanel = new JPanel();
    JButton createdButton = new JButton("Your Created Recipes");
    JButton  reviewedButton = new JButton("Your Reviewed Recipes");
    JLabel createdView;
    JLabel reviewedView;
    ProfileController pc;

    public ViewRecipeFrame(String username){
        recipePanel.setLayout(new BorderLayout());
        recipePanel.add(createdButton, BorderLayout.NORTH);
        recipePanel.add(reviewedButton, BorderLayout.SOUTH);

        createdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pc.performAllCreated(username);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Oops! There is something wrong with your profile. ");
                }
            }
        });

        reviewedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pc.performAllReviewed(username);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Oops! There is something wrong with your profile. ");
                }
            }
        });

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
