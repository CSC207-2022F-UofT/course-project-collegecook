package profile;

import ui.AppController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileFrame extends JFrame implements InfoViewBox {

    JPanel p_panel = new JPanel();
    JButton recipeButton = new JButton("View Your Related Recipes");
    JButton infoButton = new JButton("information");
    JLabel infoLabel;
    ProfileController pc;
    String username;


    public ProfileFrame(AppController appController) {
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        p_panel.setLayout(new BorderLayout());
        p_panel.add(recipeButton, BorderLayout.NORTH);
        p_panel.add(infoButton, BorderLayout.CENTER);

        recipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRecipeFrame recipeFrame = new ViewRecipeFrame(appController);
                recipeFrame.setVisible(true);
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = false;
                try {
                    status = pc.performCheckInfo(username);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Oops! There is something wrong with your profile. ");
                }
                if (status) {
                    try {
                        pc.performViewInfo(username);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,
                                "Oops! There is something wrong with your profile. ");
                    }
                } else {
                    InfoFrame infoFrame = new InfoFrame(appController);
                    infoFrame.setVisible(true);
                }
            }
        });
    }

    @Override
    public void viewInfoSuccess(String result) {
        infoLabel = new JLabel(result);
        infoLabel.setText("<html>" + result.replaceAll("<","&lt;").replaceAll(">", "&gt;").
                replaceAll("\n", "<br/>") + "</html>");
        infoLabel.setFont(new Font("Monaco", Font.PLAIN, 15));
        p_panel.add(infoLabel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
