package ui;

import profile.ProfileController;
import profile.ProfileCreateBox;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProfileCreatedUI extends JFrame implements ProfileCreateBox {
    JPanel createdPanel = new JPanel();
    JButton created = new JButton("Your Created Recipes");
    ProfileController pc;
    JLabel createdView;
    String username;

    public ProfileCreatedUI(AppController appController) {
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        createdPanel.setLayout(new BoxLayout(createdPanel, BoxLayout.Y_AXIS));

        created.setAlignmentX(Component.CENTER_ALIGNMENT);
        createdPanel.add(created);

        created.addActionListener(e -> {
            try {
                pc.performAllCreated(username);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your profile. ");
            }
        });
        this.add(createdPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    @Override
    public void noCreated() {
        JOptionPane.showMessageDialog(null, "You have no created recipes. ");
    }

    @Override
    public void hasCreated(String result) {
        if (createdView == null) {
            createdView = new JLabel(result);
            createdView.setText("<html>" + result.replaceAll("<", "&lt;").replaceAll(">", "&gt;").
                    replaceAll("\n", "<br/>") + "</html>");
            createdView.setFont(new Font("Monaco", Font.PLAIN, 15));
            createdView.setAlignmentX(Component.CENTER_ALIGNMENT);
            createdPanel.add(createdView);
        }

        this.add(createdPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
