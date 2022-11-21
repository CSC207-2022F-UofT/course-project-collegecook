package profile;

import entities.Profile;

import java.io.IOException;

public interface ProfileInputBoundary {
    void allCreated(String username) throws IOException;
    void allReviewed(String username) throws IOException;
    void setInfo(String username, ProfileRequestModel prm) throws IOException;
    boolean checkInfo(String username) throws IOException ;
    Profile checkProfile(String username) throws IOException;
    void viewInfo(String username) throws IOException;

}
