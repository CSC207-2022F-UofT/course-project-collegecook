package ui;

import profile.ProfileController;
import profile.ProfileReviewBox;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ProfileReviewUI extends JFrame implements ProfileReviewBox {
    JPanel reviewedPanel = new JPanel();
    JButton reviewed = new JButton("Your Reviewed Recipes");
    ProfileController pc;
    JLabel reviewedView;
    String username;

    public ProfileReviewUI(AppController appController) {
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        reviewedPanel.setLayout(new BoxLayout(reviewedPanel, BoxLayout.Y_AXIS));

        reviewed.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviewedPanel.add(reviewed);

        reviewed.addActionListener(e -> {
            try {
                pc.performAllReviewed(username);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your profile. ");
            }
        });
        this.add(reviewedPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }


    @Override
    public void noReviewed() {
        JOptionPane.showMessageDialog(null, "You have no reviewed recipes. ");
    }

    @Override
    public void hasReviewed(String result) {
        JLabel temp = new JLabel(result);
        temp.setText("<html>" + result.replaceAll("<", "&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        if (reviewedView == null) {
            createReviewedView(result);
        } else if (!Objects.equals(reviewedView.getText(), temp.getText())) {
            reviewedView.setText("");
            createReviewedView(result);
        }

        this.add(reviewedPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void createReviewedView(String result) {
        reviewedView = new JLabel(result);
        reviewedView.setText("<html>" + result.replaceAll("<", "&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        reviewedView.setFont(new Font("Monaco", Font.PLAIN, 15));
        reviewedView.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviewedPanel.add(reviewedView);
    }
}
