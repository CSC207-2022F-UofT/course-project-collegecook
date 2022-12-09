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
     * 100% methods, and 74% lines.
     * The line coverage doesn't reach 100% because a method in ProfileRepoImpl will catch
     * IOException if any. But this testing actually could not generate an IOException,
     * since a list of profiles will always be gotten from the local file.
     */

    ProfileRepoImpl pri;
    ArrayList<Profile> pl;
    ArrayList<Profile> temp;

    @BeforeEach
    void setUp() throws IOException {
        pri = ProfileRepoImpl.getProfileRepoImpl();
        pl = pri.getProfile();
        temp = pri.getProfile();
        Profile p = new Profile("Allison");
        pl.add(p);
        pri.saveProfile(pl);
    }

    @AfterEach
    void tearDown() throws IOException {
        pri.saveProfile(temp);
        pri = null;
        pl = null;
        temp = null;
    }

    @Test
    void testGetProfileRepoImpl(){
        assertSame(pri, ProfileRepoImpl.getProfileRepoImpl());
    }

    @Test
    void testGetProfile() throws IOException{
        ArrayList<Profile> profileList = pri.getProfile();
        assertEquals("Allison", profileList.get(0).getUsername());
    }

    @Test
    void testSaveProfile() throws IOException{
        pl.add(new Profile("Jacob"));
        pri.saveProfile(pl);
        ArrayList<Profile> result = pri.getProfile();
        assertEquals("Allison", result.get(0).getUsername());
        assertEquals("Jacob", result.get(1).getUsername());
    }

}
