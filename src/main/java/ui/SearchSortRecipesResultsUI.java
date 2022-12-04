package ui;

import entities.Recipe;
import entities.Review;
import entities.ReviewDatabase;
import review.ReviewInteractor;
import search.SearchController;
import search.SearchRequestModel;
import search.SearchResponseModel;
import search.SearchResultsBox;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class SearchSortRecipesResultsUI extends JFrame implements SearchResultsBox {
    JPanel searchResultsPanel = new JPanel();
    AppController appController;

    public SearchSortRecipesResultsUI(AppController appController){
        this.appController = appController;
        searchResultsPanel.setLayout(new BoxLayout(searchResultsPanel, BoxLayout.Y_AXIS));
    }

    @Override
    public void success(SearchResponseModel searchResponseModel) {
        searchResultsPanel.removeAll();
        SearchRequestModel searchCriteria = searchResponseModel.getSearchRequestModel();
        ReviewDatabase reviewDatabase = ReviewInteractor.loadReviewDatabase();
        for (Recipe recipe: searchResponseModel.getMatchingRecipes()){
            searchResultsPanel.add(new JLabel(recipe.getRecipeName()));
            if (Objects.equals(searchCriteria.getSortType(), "t")) {
                searchResultsPanel.add(new JLabel(String.valueOf(recipe.getTime())));
            }
            else if (Objects.equals(searchCriteria.getSortType(), "n")){
                ArrayList<Review> reviews = reviewDatabase.getRecipeReviews(recipe);
                searchResultsPanel.add(new JLabel(String.valueOf(reviews.size())));
            }
            else {
                ArrayList<Review> reviews = reviewDatabase.getRecipeReviews(recipe);
                int avgRating = (reviews.stream().mapToInt(Review::getRating).sum())/ reviews.size();
                searchResultsPanel.add(new JLabel(String.valueOf(avgRating)));
            }


        }
        this.add(searchResultsPanel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void failure(String error) {
        JOptionPane.showMessageDialog(null,"Sorry, no results were found.");
    }

    //    }
}
