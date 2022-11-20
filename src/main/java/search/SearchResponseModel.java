package search;

import entities.Recipe;

import java.util.ArrayList;

public class SearchResponseModel {
    ArrayList<Recipe> matchingRecipes;

    public SearchResponseModel(ArrayList<Recipe> matchingRecipes){
        this.matchingRecipes = matchingRecipes;
    }

    public ArrayList<Recipe> getMatchingRecipes() {
        return matchingRecipes;
    }

    public void setMatchingRecipes(ArrayList<Recipe> matchingRecipes) {
        this.matchingRecipes = matchingRecipes;
    }
}
