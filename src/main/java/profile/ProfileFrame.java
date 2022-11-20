package profile;

import entities.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileFrame extends JFrame {

    JPanel p_panel = new JPanel();
    JButton createdButton = new JButton("View Your Created Recipes");
    JButton  reviewedButton = new JButton("View Your Reviewed Recipes");
    JButton infoButton = new JButton("information");
    ProfileController pc;

    public ProfileFrame(String username) {
        p_panel.setLayout(new BorderLayout());
        p_panel.add(createdButton, BorderLayout.NORTH);
        p_panel.add(reviewedButton, BorderLayout.CENTER);
        p_panel.add(infoButton, BorderLayout.SOUTH);

        this.add(p_panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        createdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pc.performAllCreated(username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        reviewedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pc.performAllReviewed(username);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoFrame infoFrame = new InfoFrame(username);
                infoFrame.setVisible(true);
            }
        });
    }

}
