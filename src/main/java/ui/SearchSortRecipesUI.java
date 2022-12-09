package ui;

import search.*;
import javax.swing.*;
import java.awt.*;
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

        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(nameLabel);
        nameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(nameInput);

        cuisineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(cuisineLabel);
        cuisineInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(cuisineInput);

        ingredientsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(ingredientsLabel);
        ingredientsInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(ingredientsInput);

        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(timeLabel);
        timeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(timeInput);

        sortTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(sortTypeLabel);
        sortTypeInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(sortTypeInput);

        isSortAscendingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(isSortAscendingLabel);
        isSortAscendingInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(isSortAscendingInput);


        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(e -> {
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

        });
        searchPanel.add(searchButton);

        this.add(searchPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        }
}
