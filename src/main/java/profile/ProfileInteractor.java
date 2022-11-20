package profile;

import entities.*;
import recipe.RecipeInterActor;
import recipe.RecipeOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileInteractor implements ProfileInputBoundary{
    private final ProfileRepoGateway prg = new ProfileRepoImpl();
    private ArrayList<Profile> profile_list;
    final ProfileOutputBoundary outputboundary;
    final RecipeOutputBoundary recipeOut;


    public ProfileInteractor(ProfileOutputBoundary outputboundary, RecipeOutputBoundary recipeOut) {
        this.outputboundary = outputboundary;
        this.recipeOut = recipeOut;

        try{
            profile_list = prg.getProfile();
        }
        catch(IOException e ){
            profile_list = new ArrayList<Profile>();
            System.out.println("Read file failed.....");
        }
    }

    public void all_created(String username) throws IOException {
        RecipeInterActor ri = new RecipeInterActor(recipeOut);
        RecipeList rl = ri.getAll();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        for (Recipe r: rl){
            if (r.get_creator().equals(username)){
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

    public void set_info(String username, int age, float height, float weight, String gender) throws IOException {
        for (Profile p: profile_list){
            if (p.getUsername().equals(username)){
               set_all(age, height, weight, gender, p);
               outputboundary.set_info_success();
            }
        }
    }

    private void set_all(int age, float height, float weight, String gender, Profile p) {
        p.setAge(age);
        p.setHeight(height);
        p.setWeight(weight);
        p.setGender(gender);
    }

}
