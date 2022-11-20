package profile;

import entities.*;
import recipe.RecipeRepoGateway;
import recipe.RecipeReadWriter;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileInteractor implements ProfileInputBoundary{
    private final ProfileRepoGateway prg =  ProfileRepoImpl.getPrl();
    private final RecipeRepoGateway rrg = RecipeReadWriter.getRecipeRepo();
    private ArrayList<Profile> profile_list;
    final ProfileOutputBoundary outputboundary;


    public ProfileInteractor(ProfileOutputBoundary outputboundary) {
        this.outputboundary = outputboundary;

        try{
            profile_list = prg.getProfile();
        }
        catch(IOException e ){
            profile_list = new ArrayList<>();
            System.out.println("Read file failed.....");
        }
    }

    public void all_created(String username) throws IOException {
        RecipeList all_recipe = rrg.getRecipeList();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        for (Recipe r: all_recipe){
            if (r.getCreator().equals(username)){
                recipeList.add(r);
            }
        }
        Profile result = check_profile(username);
        result.setCreated(recipeList);
        outputboundary.view_created(result);
    }

    public Profile check_profile(String username) throws IOException {
        for (Profile p: profile_list){
            if (p.getUsername().equals(username)){
                return p;
            }
        }
        Profile new_p = new Profile(username);
        prg.saveProfile(new_p);
        return new_p;
    }

    //need jason to modify getUserReviews to be worked.
    public void all_reviewed(String username) throws IOException {
        //ArrayList<Review> all = ReviewDatabase.getUserReviews(user);
        Profile result = check_profile(username);
        //result.setReviewed(all);
        outputboundary.view_reviewed(result);
    }

    public void set_info(String username, ProfileRequestModel prm) {
        for (Profile p: profile_list){
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
