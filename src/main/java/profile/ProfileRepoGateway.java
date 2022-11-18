package profile;

import entities.Profile;

import java.io.IOException;
import java.util.ArrayList;

public interface ProfileRepoGateway {
    ArrayList<Profile> getProfile() throws IOException;

    void saveProfile(Profile pro) throws IOException;
}
