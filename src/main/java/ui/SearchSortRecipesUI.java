package ui;

import search.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSortRecipesUI extends JFrame{
    // search controller
    SearchController searchController;
    // search panel
    JPanel searchPanel = new JPanel();
    // search button
    JButton searchButton = new JButton("Search");

    // search criteria input fields and labels
    JLabel title = new JLabel("Search & Sort for Recipes");

    JTextField nameInput = new JTextField(40);
    JLabel nameLabel = new JLabel("Name/Keyword: ");

    JTextField cuisineInput = new JTextField(40);
    JLabel cuisineLabel = new JLabel("Cuisine: ");

    JTextField ingredientsInput = new JTextField(40);
    JLabel ingredientsLabel = new JLabel("Ingredients (use singular, separate using commas): ");

    JTextField timeInput = new JTextField(40);
    JLabel timeLabel = new JLabel("Time: ");

    JTextField sortTypeInput = new JTextField(40);
    JLabel sortTypeLabel = new JLabel("Sort by 'r' = average rating, 'n' = number of reviews, 't'= time needed");

    JCheckBox isSortAscendingInput = new JCheckBox();
    JLabel isSortAscendingLabel = new JLabel("Sort by ascending? ");



    /**
     * Screen with fields to enter search criteria/sorting options, and button to search
     */
    public SearchSortRecipesUI(AppController appController){
        this.searchController = appController.getSearchController();

        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        searchPanel.add(title);

        nameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(nameInput);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(nameLabel);

        cuisineInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(cuisineInput);
        cuisineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(cuisineLabel);

        ingredientsInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(ingredientsInput);
        ingredientsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(ingredientsLabel);


        timeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(timeInput);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(timeLabel);

        sortTypeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(sortTypeInput);
        sortTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(sortTypeLabel);

        isSortAscendingInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(isSortAscendingInput);
        isSortAscendingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(isSortAscendingLabel);

        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // turn inputted ingredient string into array of ingredients with no leading/trailing whitespace
                String[] inputIngredients = ingredientsInput.getText().split(",");
                String[] trimmedInputIngredients = new String[inputIngredients.length];
                for (int i = 0; i < inputIngredients.length; i++)
                    trimmedInputIngredients[i] = inputIngredients[i].trim();

                try {
                    searchController.getSearchResults(
                            nameInput.getText(),
                            cuisineInput.getText(),
                            ingredientsInput.getText().isEmpty() ? new ArrayList<>(List.of()) : (new ArrayList<>(Arrays.asList(trimmedInputIngredients))),
                            timeInput.getText().isEmpty() ? 0 : Integer.parseInt(timeInput.getText()),
                            sortTypeInput.getText(),
                            isSortAscendingInput.isSelected()
                    );
                } catch (IOException ex) {
                    System.out.println("something went wrong");
                    throw new RuntimeException(ex);
                }

            }
        });
        searchPanel.add(searchButton);

        this.add(searchPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        }
}
