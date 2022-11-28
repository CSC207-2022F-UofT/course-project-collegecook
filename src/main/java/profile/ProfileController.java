package profile;

import java.io.IOException;

public class ProfileController {
    /**
     * This is ProfileController, a class in Controller layer.
     */
    ProfileInputBoundary inputBoundary;

    /**
     * Construct a profile controller.
     * @param inputBoundary An interface to get access of the ProfileInteractor. It is injected here to follow
     * the Dependency Rule.
     */
    public ProfileController(ProfileInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Requests a ProfileInputBoundary to view all created recipes of the user with the given username.
     * @param username the username of the user
     */
    public void performAllCreated(String username) throws IOException {
        inputBoundary.allCreated(username);
    }

    /**
     * Requests a ProfileInputBoundary to view all recipes reviewed by the user with the given username.
     * @param username the username of the user
     */
    public void performAllReviewed(String username) throws IOException {
        inputBoundary.allReviewed(username);
    }

    /**
     * Requests a ProfileInputBoundary to set all information the user.
     * @param username the username of the user
     * @param age the age of the user
     * @param height the height of the user
     * @param weight the weight of the user
     * @param gender the gender of the user
     * This method passes all the parameters excluding username into a ProfileRequestModel to avoid Data Clump,
     * and passes the request model to the recipeInputBoundary.
     */
    public void performSetInfo(String username, int age, float height, float weight, String gender) throws IOException {
        ProfileRequestModel prm = new ProfileRequestModel(age, height, weight, gender);
        inputBoundary.setInfo(username, prm);
    }

    /**
     * Requests a ProfileInputBoundary to view all information of the user with the given username.
     * @param username the username of the user
     */
    public void performViewInfo(String username) throws IOException {
        inputBoundary.viewInfo(username);
    }

    /**
     * Requests a ProfileInputBoundary to check if the user with the given username has already inputted his/her
     * information.
     * @param username the username of the user
     * @return true if the user contains his/her information; false otherwise.
     */
    public boolean performCheckInfo(String username)throws IOException{
        return inputBoundary.checkInfo(username);
    }
}
