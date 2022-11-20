package profile;

import entities.*;
import recipe.RecipeInterActor;
import recipe.RecipeOutputBoundary;
import recipe.RecipeRepoGateway;
import recipe.RecipeRepoImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileInteractor implements ProfileInputBoundary{
    private final ProfileRepoGateway prg =  ProfileRepoImpl.getPrl();
    private final RecipeRepoGateway rrg = RecipeRepoImpl.getRecipeRepoImpl();
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
            if (r.get_creator().equals(username)){
                recipeList.add(r);
            }
        }
        Profile result = checkProfile(username);
        result.setCreated(recipeList);
        outputboundary.view_created(result);
    }

    public Profile checkProfile(String username) throws IOException {
        for (Profile p: profileList){
            if (p.getUsername().equals(username)){
                return p;
            }
        }
        Profile new_p = new Profile(username);
        prg.saveProfile(new_p);
        return new_p;
    }

    //need jason to modify getUserReviews to be worked.
    public void allReviewed(String username) throws IOException {
        ArrayList<Review> all = ReviewDatabase.getUserReviews(username);
        Profile result = checkProfile(username);
        result.setReviewed(all);
        outputboundary.view_reviewed(result);
    }


    public void setInfo(String username, ProfileRequestModel prm) {
        for (Profile p: profileList){
            if (p.getUsername().equals(username)){
                set_all(prm, p);
                outputboundary.set_info_success();
            }
        }
    }

    private void set_all(ProfileRequestModel prm, Profile p) {
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
