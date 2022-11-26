package ui;

import entities.Recipe;
import search.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchSortRecipesUI extends JFrame{

    // search criteria input fields and labels
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

    // title of screen
    JLabel title = new JLabel("Search & Sort Recipes");

    // search button
    JButton searchButton = new JButton("Search");

    // search panel
    JPanel searchPanel = new JPanel();

    // search controller
    SearchController searchController;

    /**
     * Screen with fields to enter search criteria/sorting options, and button to search
     */
    public SearchSortRecipesUI(AppController appController){
        this.searchController = appController.getSearchController();

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cuisineInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuisineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ingredientsInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        ingredientsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        timeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        sortTypeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        sortTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        isSortAscendingInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        isSortAscendingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchPanel.add(nameInput);
        searchPanel.add(nameLabel);
        searchPanel.add(cuisineInput);
        searchPanel.add(cuisineLabel);
        searchPanel.add(ingredientsInput);
        searchPanel.add(ingredientsLabel);
        searchPanel.add(timeInput);
        searchPanel.add(timeLabel);
        searchPanel.add(sortTypeInput);
        searchPanel.add(sortTypeLabel);
        searchPanel.add(isSortAscendingInput);
        searchPanel.add(isSortAscendingLabel);

        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(e -> {
            ArrayList<String> ingredients = new ArrayList<>(Arrays.asList(ingredientsInput.getText().split(",")));

            try {
                searchController.getSearchResults(
                        nameInput.getText(),
                        cuisineInput.getText(),
                        ingredients,
                        Integer.parseInt(timeInput.getText()),
                        sortTypeInput.getText(),
                        isSortAscendingInput.isSelected()
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        searchPanel.add(searchButton);
        this.add(searchPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        }
}
