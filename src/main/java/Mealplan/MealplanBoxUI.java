package Mealplan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import Recipe.*;

import Entities.*;

public class MealplanBoxUI {
    MealplanController mealplanController;

    JFrame mealplanbox = new JFrame("Meal Plan");
    JPanel panel_b = new JPanel();
    JPanel panel_l = new JPanel();
    JPanel panel_d = new JPanel();
    JPanel panel_s = new JPanel();
    JPanel panel_cal = new JPanel();
    JLabel label_b = new JLabel("Breakfast");
    JLabel label_l = new JLabel("Lunch");
    JLabel label_d = new JLabel("Dinner");
    public MealplanBoxUI(MealplanController mealplanController){
        this.mealplanController = mealplanController;

        JButton button_b = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mealplanController.deleteMealplan(0);
            }
        });

        JButton button_l = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mealplanController.deleteMealplan(1);
            }
        });

        JButton button_d = new JButton( new AbstractAction("delete") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mealplanController.deleteMealplan(2);
            }
        });

        JButton button_cal = new JButton( new AbstractAction("calculate calories") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                mealplanController.getCalories();
            }
        });

        JButton button_save = new JButton( new AbstractAction("Save") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    mealplanController.saveMealplan();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel_b.setBackground(Color.ORANGE);
        panel_l.setBackground(Color.YELLOW);
        panel_d.setBackground(Color.PINK);

        panel_b.add(label_b);
        panel_l.add(label_l);
        panel_d.add(label_d);

        panel_b.add(button_b);
        panel_l.add(button_l);
        panel_d.add(button_d);
        panel_s.add(button_cal);
        panel_s.add(button_save);

        mealplanbox.add(panel_b);
        mealplanbox.add(panel_l);
        mealplanbox.add(panel_d);
        mealplanbox.add(panel_cal);

        mealplanbox.setLayout(new GridLayout(4,0));

        mealplanbox.setSize(400,400);
        mealplanbox.setVisible(true);
    }

    public void setMealplan(String recipe, int meal, RecipeController recipeController){

        JButton button_m = new JButton( new AbstractAction(recipe) {
            @Override
            public void actionPerformed( ActionEvent e ) {
                recipeController.performReadRecipe(recipe);
            }
        });

        if (meal == 0){
            panel_b.add(button_m);

        } else if (meal == 1) {
            panel_l.add(button_m);
        } else {
            panel_d.add(button_m);
        }
    }


}
