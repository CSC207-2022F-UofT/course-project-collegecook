package profile;

import entities.Profile;

import java.io.IOException;

/**
 * This is an interface between the controller and the interactor, helping to follow the Dependency Rule.
 * ProfileInteractor should implement this interface.
 */

public interface ProfileInputBoundary {

    /**
     * View all the recipes created by the user with the given username.
     * @param username The username of the user.
     * @throws IOException
     */
    void allCreated(String username) throws IOException;

    /**
     * View all the recipes reviewed by the user with the given username.
     * @param username The username of the user.
     * @throws IOException
     */
    void allReviewed(String username) throws IOException;

    /**
     * Set all the information of the user with the given username and ProfileRequestModel.
     * @param username The username of the user.
     * @param prm A Profile request model.
     * @throws IOException
     */
    void setInfo(String username, ProfileRequestModel prm) throws IOException;

    /**
     * Check if the profile contains all the information of the user with the given username.
     * @param username The username of the user.
     * @return true if the profile contains the information; false otherwise.
     * @throws IOException
     */
    boolean checkInfo(String username) throws IOException ;

    /**
     * Check if the profile with the given username exists in the Profile Database.
     * @param username The username of the user.
     * @return If the profile already exists in the Database, return the current profile; otherwise, return a new
     * profile with the given username.
     * @throws IOException
     */
    Profile checkProfile(String username) throws IOException;

    /**
     * View all information of user with the given username in his/her profile.
     * @param username The username of the user.
     * @throws IOException
     */
    void viewInfo(String username) throws IOException;

}
