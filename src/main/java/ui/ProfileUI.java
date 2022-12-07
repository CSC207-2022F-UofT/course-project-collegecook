package ui;

import profile.InfoViewBox;
import profile.ProfileController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProfileUI extends JFrame implements InfoViewBox {

    JPanel p_panel = new JPanel();
    JButton createdButton = new JButton("View Your Created Recipes");
    JButton reviewedButton = new JButton("View Your Reviewed Recipes");
    JButton infoButton = new JButton("information");
    JLabel infoLabel;
    ProfileController pc;
    String username;


    public ProfileUI(AppController appController) {
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        p_panel.setLayout(new BoxLayout(p_panel, BoxLayout.Y_AXIS));

        createdButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        p_panel.add(createdButton);

        reviewedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        p_panel.add(reviewedButton);

        infoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        p_panel.add(infoButton);

        createdButton.addActionListener(e -> {
            ProfileCreatedUI profileCreatedUI = new ProfileCreatedUI(appController);
            profileCreatedUI.setVisible(true);
        });

        reviewedButton.addActionListener(e -> {
            ProfileReviewUI profileReviewUI = new ProfileReviewUI(appController);
            profileReviewUI.setVisible(true);
        });

        infoButton.addActionListener(e -> {
            boolean status = false;
            try {
                dispose();
                status = pc.performCheckInfo(username);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your profile. ");
            }
            if (status) {
                try {
                    dispose();
                    pc.performViewInfo(username);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Oops! There is something wrong with your profile. ");
                }
            } else {
                ProfileInfoUI piUI = new ProfileInfoUI(appController);
                piUI.setVisible(true);
            }
        });
        this.add(p_panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    @Override
    public void viewInfoSuccess(String result) {
        if (infoLabel == null) {
            infoLabel = new JLabel(result);
            infoLabel.setText("<html>" + result.replaceAll("<", "&lt;").replaceAll(">", "&gt;").
                    replaceAll("\n", "<br/>") + "</html>");
            infoLabel.setFont(new Font("Monaco", Font.PLAIN, 15));
            infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            p_panel.add(infoLabel);
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
