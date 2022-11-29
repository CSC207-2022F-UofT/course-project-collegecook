package profile;

import entities.Profile;

import java.io.IOException;
import java.util.ArrayList;

public interface ProfileRepoGateway {
    /**
     * This interface is implemented by ProfileRepoImpl to get and save profiles.
     */

    ArrayList<Profile> getProfile() throws IOException;

    void saveProfile(ArrayList<Profile> pro) throws IOException;
}
