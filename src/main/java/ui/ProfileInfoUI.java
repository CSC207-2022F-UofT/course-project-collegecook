package ui;

import profile.InfoSetBox;
import profile.ProfileController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProfileInfoUI extends JFrame implements InfoSetBox {
    JPanel infoPanel = new JPanel();
    JButton setButton = new JButton("Set your information");
    JLabel age = new JLabel("Age");
    JLabel height = new JLabel("Height (cm) ");
    JLabel weight = new JLabel("Weight (kg) ");
    JLabel genderLabel = new JLabel("Select your gender");
    JRadioButton femaleButton = new JRadioButton("Female");
    JRadioButton maleButton = new JRadioButton("Male");
    JButton confirmButton = new JButton("Confirm");
    ButtonGroup G1 = new ButtonGroup();
    JTextField ageInput = new JTextField();
    JTextField heightInput = new JTextField();
    JTextField weightInput = new JTextField();
    ProfileController pc;
    String username;

    public ProfileInfoUI(AppController appController){
        this.pc = appController.getProfileController();
        this.username = appController.getLoginControllor().preformGetLoggedInUser();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        setButton.addActionListener(e -> {
            int pcAge = Integer.parseInt(ageInput.getText());
            float pcHeight = Float.parseFloat(heightInput.getText());
            float pcWeight = Float.parseFloat(weightInput.getText());
            String gender;
            if (femaleButton.isSelected()){
                gender = femaleButton.getText();
            }
            else{
                gender = maleButton.getText();
            }
            try {
                dispose();
                JOptionPane.showMessageDialog(null,
                        "You must enter all information at once, which can't be changed later. ");
                pc.performSetInfo(username, pcAge, pcHeight, pcWeight, gender);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Oops! There is something wrong with your Profile. ");
            }
        });

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

        genderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(genderLabel);
        femaleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(femaleButton);
        maleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(maleButton);
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(confirmButton);
        G1.add(femaleButton);
        G1.add(maleButton);

        setButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(setButton);

        this.add(infoPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

    }

    @Override
    public void setInfoSuccess() {
        JOptionPane.showMessageDialog(null, "You have successfully set all your information. ");
    }

}
