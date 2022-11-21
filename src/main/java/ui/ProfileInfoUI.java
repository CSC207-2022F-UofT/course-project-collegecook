package ui;

import profile.InfoSetBox;
import profile.ProfileController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileInfoUI extends JFrame implements InfoSetBox {
    JPanel infoPanel = new JPanel();
    JButton setButton = new JButton("Set your information");
    JLabel age = new JLabel("Age");
    JLabel height = new JLabel("Height");
    JLabel weight = new JLabel("Weight");
    JLabel gender = new JLabel("Gender");
    JTextField ageInput = new JTextField();
    JTextField heightInput = new JTextField();
    JTextField weightInput = new JTextField();
    JTextField genderInput = new JTextField();
    ProfileController pc;
    String username;

    public ProfileInfoUI(AppController appController){
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pcAge = Integer.parseInt(ageInput.getText());
                float pcHeight = Float.parseFloat(heightInput.getText());
                float pcWeight = Float.parseFloat(weightInput.getText());
                try {
                    dispose();
                    JOptionPane.showMessageDialog(null,
                            "You must enter all information at once, which can't be changed later. ");
                    pc.performSetInfo(username, pcAge, pcHeight, pcWeight, genderInput.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Oops! There is something wrong with your Profile. ");
                }
            }
        });

        setButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(setButton);

        age.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(age);
        ageInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(ageInput);

        height.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(height);
        heightInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(heightInput);

        weight.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(weight);
        weightInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(weightInput);

        gender.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(gender);
        genderInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(genderInput);


        this.add(infoPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

    }

    @Override
    public void setInfoSuccess() {
        JOptionPane.showMessageDialog(null, "You have successfully set all your information. ");
    }

}
