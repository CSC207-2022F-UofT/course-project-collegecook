package profile;

import entities.Profile;
import entities.User;

import java.io.IOException;

public class ProfileController {
    ProfileInputBoundary inputBoundary;

    public ProfileController(ProfileInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void performAllCreated(String username) throws IOException {
        inputBoundary.allCreated(username);
    }

    public void performAllReviewed(String username) throws IOException {
        inputBoundary.allReviewed(username);
    }

    public void performSetInfo(String username, int age, float height, float weight, String gender) throws IOException {
        ProfileRequestModel prm = new ProfileRequestModel(age, height, weight, gender);
        inputBoundary.setInfo(username, prm);
    }
}
