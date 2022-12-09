package profile;

import entities.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileRepoImplTest {
    /**
     * This test covers 100% ProfileRepoImp class in the entity package,
     * 100% methods, and 90% lines.
     * The line coverage doesn't reach 100% because a method in ProfileRepoImpl will catch
     * IOException if any. But this testing actually could not generate an IOException,
     * since a list of profiles will always be gotten from the local file.
     */

    ProfileRepoImpl profileRepo;
    ArrayList<Profile> profileList;
    ArrayList<Profile> temp;

    @BeforeEach
    void setUp() throws IOException {
        profileRepo = ProfileRepoImpl.getProfileRepoImpl();
        profileList = profileRepo.getProfile();
        temp = profileRepo.getProfile();
        Profile p = new Profile("Allison");
        profileList.add(p);
        profileRepo.saveProfile(profileList);
    }

    @AfterEach
    void tearDown() throws IOException {
        profileRepo.saveProfile(temp);
        profileRepo = null;
        profileList = null;
        temp = null;
    }

    @Test
    void testGetProfileRepoImpl(){
        assertSame(profileRepo, ProfileRepoImpl.getProfileRepoImpl());
    }

    @Test
    void testGetProfile() {
        ArrayList<Profile> profileList = profileRepo.getProfile();
        assertEquals("Allison", profileList.get(0).getUsername());
    }

    @Test
    void testSaveProfile() throws IOException{
        profileList.add(new Profile("Jacob"));
        profileRepo.saveProfile(profileList);
        ArrayList<Profile> result = profileRepo.getProfile();
        assertEquals("Allison", result.get(0).getUsername());
        assertEquals("Jacob", result.get(1).getUsername());
    }

}
