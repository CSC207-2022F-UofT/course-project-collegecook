package profile;

import entities.*;
import recipe.RecipeRepoGateway;
import recipe.RecipeReadWriter;
import review.ReviewInteractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ProfileInteractor implements ProfileInputBoundary{
    private final ProfileRepoGateway prg =  ProfileRepoImpl.getPrl();
    private final RecipeRepoGateway rrg = RecipeReadWriter.getRecipeRepo();
    private ArrayList<Profile> profileList;
    final ProfileOutputBoundary outputboundary;


    public ProfileInteractor(ProfileOutputBoundary outputboundary) {
        this.outputboundary = outputboundary;

        try{
            profileList = prg.getProfile();
        }
        catch(IOException e ){
            profileList = new ArrayList<>();
            System.out.println("Read file failed.....");
        }
    }

    public void allCreated(String username) throws IOException {
        RecipeList allRecipe = rrg.getRecipeList();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        for (Recipe r: allRecipe){
            if (r.getCreator().equals(username)){
                recipeList.add(r);
            }
        }
        Profile p = checkProfile(username);
        p.setCreated(recipeList);
        if (p.getCreated().isEmpty()){
            outputboundary.noCreated();
        }
        else{
            String result = p.soutCreated();
            outputboundary.viewCreated(result);
        }
    }

    public Profile checkProfile(String username) throws IOException {
        for (Profile p: profileList){
            if (p.getUsername().equals(username)){
                return p;
            }
        }
        Profile new_p = new Profile(username);
        profileList.add(new_p);
        prg.saveProfile(profileList);
        return new_p;
    }

    public void allReviewed(String username) throws IOException {
        ArrayList<Review> all = ReviewInteractor.loadReviewDatabase().getUserReviews(username);
        Profile p = checkProfile(username);
        p.setReviewed(all);
        if (p.getReviewed().isEmpty()){
            outputboundary.noReviewed();
        }
        else{
            String result = p.soutReviewed();
            outputboundary.viewReviewed(result);
        }
    }

    public void setInfo(String username, ProfileRequestModel prm) throws IOException {
        Profile p = checkProfile(username);
        setAll(prm, p);
        prg.saveProfile(profileList);
        outputboundary.setInfoResult();
    }

    public void viewInfo(String username) throws IOException {
        Profile p = checkProfile(username);
        String result = p.soutInfo();
        outputboundary.viewInfo(result);
    }

    public boolean checkInfo(String username) throws IOException {
        Profile p = checkProfile(username);
        int age = p.getAge();
        float height = p.getHeight();
        float weight = p.getWeight();
        String gender = p.getGender();
        return age != 0 || height != 0 || weight != 0 || gender != null;
    }

    private void setAll(ProfileRequestModel prm, Profile p) {
        int age = prm.getAge();
        float height = prm.getHeight();
        float weight = prm.getWeight();
        String gender = prm.getGender();
        p.setAge(age);
        p.setHeight(height);
        p.setWeight(weight);
        p.setGender(gender);
    }

}
