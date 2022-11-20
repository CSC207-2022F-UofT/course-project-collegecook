package profile;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {
    JPanel infoPanel = new JPanel();
    JLabel main = new JLabel("Your Information");
    JButton age = new JButton("Age");
    JButton height = new JButton("Height");
    JButton weight = new JButton("Weight");
    JButton gender = new JButton("Gender");
    JTextField ageInput = new JTextField();
    JTextField heightInput = new JTextField();
    JTextField weightInput = new JTextField();
    JTextField genderInput = new JTextField();
    ProfileController ci;

    public InfoFrame(String username){
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        main.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(main);

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

}
