package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddMealplanUI extends JFrame {
    JPanel AddMealplan = new JPanel();
    public AddMealplanUI(AppController appController, String recipe){
        JButton button_b = new JButton( new AbstractAction("Breakfast") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().addMealplan(recipe,0);
            }

        });

        JButton button_l = new JButton( new AbstractAction("Lunch") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().addMealplan(recipe,1);
            }

        });

        JButton button_d = new JButton( new AbstractAction("Dinner") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                appController.getMealplanController().addMealplan(recipe,2);
            }

        });

        AddMealplan.add(button_b);
        AddMealplan.add(button_l);
        AddMealplan.add(button_d);;

        this.add(AddMealplan);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
