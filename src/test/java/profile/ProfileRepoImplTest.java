package profile;

import entities.Profile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileRepoImplTest {
    ProfileRepoImpl pri;
    ArrayList<Profile> pl;
    ArrayList<Profile> temp;

    @BeforeEach
    void setUp() throws IOException {
        pri = ProfileRepoImpl.getPrl();
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
    void testGetPrl(){
        assertSame(pri, ProfileRepoImpl.getPrl());
    }

    @Test
    void testGetProfile() throws IOException{
        ArrayList<Profile> profileList = pri.getProfile();
        assertTrue(profileList.get(0).getUsername().equals("Allison"));
    }

    @Test
    void testSaveProfile() throws IOException{
        pl.add(new Profile("Jacob"));
        pri.saveProfile(pl);
        ArrayList<Profile> result = pri.getProfile();
        assertTrue(result.get(0).getUsername().equals("Allison"));
        assertTrue(result.get(1).getUsername().equals("Jacob"));
    }
}
