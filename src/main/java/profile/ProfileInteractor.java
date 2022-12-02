package profile;

import entities.*;
import recipe.RecipeRepoGateway;
import recipe.RecipeReadWriter;
import review.ReviewInteractor;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileInteractor implements ProfileInputBoundary{
    private final ProfileRepoGateway prg =  ProfileRepoImpl.getPrl();
    private final RecipeRepoGateway rrg = RecipeReadWriter.getRecipeRepo();
    private ArrayList<Profile> profileList;
    final ProfileOutputBoundary outputBoundary;

    /**
     * Construct a ProfileInteractor with a profile output boundary.
     * @param outputBoundary The profile output boundary.
     */
    public ProfileInteractor(ProfileOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;

        try{
            profileList = prg.getProfile();
        }
        catch(IOException e ){
            profileList = new ArrayList<>();
            System.out.println("Read file failed.....");
        }
    }

    /**
     * View all the recipes created by the user with the given username.
     * @param username The username of the user.
     * This method calls noCreated in the Profile Output Boundary if the user has no created recipes; otherwise, it
     * calls viewCreated of the output boundary.
     * @throws IOException
     */
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
            outputBoundary.noCreated();
        }
        else{
            String result = p.soutCreated();
            outputBoundary.viewCreated(result);
        }
    }

    /**
     * Check if the profile with the given username exists in the Profile Database.
     * @param username The username of the user.
     * @return If the profile already exists in the Database, return the current profile; otherwise, return a new
     * profile with the given username.
     * @throws IOException
     */
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

    /**
     * View all the recipes reviewed by the user with the given username.
     * @param username The username of the user.
     * This method calls noReviewed in the Profile Output Boundary if the user has no reviewed recipes; otherwise, it
     * calls viewReviewed of the output boundary.
     * @throws IOException
     */
    public void allReviewed(String username) throws IOException {
        ArrayList<Review> all = ReviewInteractor.loadReviewDatabase().getUserReviews(username);
        Profile p = checkProfile(username);
        p.setReviewed(all);
        if (p.getReviewed().isEmpty()){
            outputBoundary.noReviewed();
        }
        else{
            String result = p.soutReviewed();
            outputBoundary.viewReviewed(result);
        }
    }

    /**
     * View all information of user with the given username in his/her profile.
     * @param username The username of the user.
     * This method calls viewInfo in the Profile Output Boundary.
     * @throws IOException
     */
    public void viewInfo(String username) throws IOException {
        Profile p = checkProfile(username);
        String result = p.soutInfo();
        outputBoundary.viewInfo(result);
    }

    /**
     * Check if the profile contains all the information of the user with the given username.
     * @param username The username of the user.
     * @return true if the profile contains the information; false otherwise.
     * @throws IOException
     */
    public boolean checkInfo(String username) throws IOException {
        Profile p = checkProfile(username);
        int age = p.getAge();
        float height = p.getHeight();
        float weight = p.getWeight();
        String gender = p.getGender();
        return age != 0 || height != 0 || weight != 0 || gender != null;
    }

    /**
     * Set all the information of the user with the given username and ProfileRequestModel.
     * @param username The username of the user.
     * @param prm A Profile request model.
     * After setting all the information, call setInfoResult in the Profile Output Boundary.
     * @throws IOException
     */
    public void setInfo(String username, ProfileRequestModel prm) throws IOException {
        Profile p = checkProfile(username);
        setAll(prm, p);
        prg.saveProfile(profileList);
        outputBoundary.setInfoResult();
    }

    /**
     * This helper method is extracted from and for setInfo.
     * @param prm A Profile request model.
     * @param p A given Profile.
     */
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
