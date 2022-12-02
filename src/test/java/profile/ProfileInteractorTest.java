package profile;

import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.RecipeReadWriter;
import recipe.RecipeRepoGateway;
import review.ReviewDatabaseReadWriter;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileInteractorTest {
    ProfileRepoGateway prg;
    ArrayList<Profile> tempProfile;
    RecipeRepoGateway rrg;
    RecipeList tempRecipe;

    @BeforeEach
    void setUp() throws IOException {
        prg = ProfileRepoImpl.getPrl();
        tempProfile = prg.getProfile();
        ArrayList<Profile> profileList = new ArrayList<>();
        Profile profile = new Profile("Allison");
        Profile profile2 = new Profile("Jacob");
        profileList.add(profile);
        profileList.add(profile2);
        prg.saveProfile(profileList);

        rrg = RecipeReadWriter.getRecipeRepo();
        tempRecipe = rrg.getRecipeList();
    }

    @AfterEach
    void tearDown() throws IOException {
        prg.saveProfile(tempProfile);
        prg = null;
        rrg.saveRecipe(tempRecipe);
        rrg = null;
    }

    @Test
    void testAllCreated() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {
                ArrayList<Profile> profileList = null;
                try{
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p: profileList){
                    if (p.getUsername().equals("Allison")){
                        if (!p.getCreated().isEmpty()){
                            String expected = p.soutCreated();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noCreated() {
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        assertTrue(p.getCreated().isEmpty());
                    }
                }
            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.allCreated("Allison");
    }

    @Test
    void testAllCreatedNonEmpty() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {
                ArrayList<Profile> profileList = null;
                try{
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p: profileList){
                    if (p.getUsername().equals("Allison")){
                        if (!p.getCreated().isEmpty()){
                            String expected = p.soutCreated();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noCreated() {
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        assertTrue(p.getCreated().isEmpty());
                    }
                }
            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox profileBox) {

            }

            @Override
            public void setUI(InfoSetBox infoSetBox) {

            }

            @Override
            public void setUI(InfoViewBox infoViewBox) {

            }
        };
        ArrayList<String> ta = new ArrayList<>();
        RecipeList recipeList = rrg.getRecipeList();
        recipeList.add_recipe("Test", "Procedure", "cuisine", ta, 1, 2,
                3, "Allison");
        rrg.saveRecipe(recipeList);
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.allCreated("Allison");
    }

    @Test
    void testAllReviewed() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        if (!p.getReviewed().isEmpty()) {
                            String expected = p.soutReviewed();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noReviewed() {
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        assertTrue(p.getReviewed().isEmpty());
                    }
                }
            }

            @Override
            public void viewCreated(String result) {

            }

            @Override
            public void noCreated() {

            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.allReviewed("Allison");
    }

    @Test
    void testCheckProfile() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {

            }

            @Override
            public void noCreated() {

            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        ArrayList<Profile> pl = new ArrayList<>();
        Profile p = new Profile("Allison");
        pl.add(p);
        prg.saveProfile(pl);
        ProfileInteractor pi = new ProfileInteractor(output);
        Profile result = pi.checkProfile("Allison");
        assertEquals("Allison", result.getUsername());
    }

    @Test
    void testSetInfo() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {

            }

            @Override
            public void noCreated() {

            }

            @Override
            public void setInfoResult() {
                try {
                    ArrayList<Profile> profileList = prg.getProfile();
                    for (Profile p : profileList) {
                        if (p.getUsername().equals("Allison")) {
                            assertEquals(20, p.getAge());
                            assertEquals(163, p.getHeight());
                            assertEquals(45, p.getWeight());
                            assertEquals("Female", p.getGender());
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        ProfileRequestModel prm = new ProfileRequestModel(20, 163, 45, "Female");
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.setInfo("Allison", prm);
    }


    @Test
    void testViewInfo() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {

            }

            @Override
            public void noCreated() {

            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        String expected = p.soutInfo();
                        assertEquals(expected, result);
                    }
                }
            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        Profile p = new Profile("Allison");
        p.setAge(20);
        p.setHeight(163);
        p.setWeight(45);
        p.setGender("Female");
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.viewInfo("Allison");
    }

    @Test
    void testCheckInfo() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {

            }

            @Override
            public void noReviewed() {

            }

            @Override
            public void viewCreated(String result) {

            }

            @Override
            public void noCreated() {

            }

            @Override
            public void setInfoResult() {

            }

            @Override
            public void viewInfo(String result) {

            }

            @Override
            public void setUI(ProfileBox pb) {

            }

            @Override
            public void setUI(InfoSetBox isb) {

            }

            @Override
            public void setUI(InfoViewBox ivb) {

            }
        };
        ProfileInteractor pi = new ProfileInteractor(output);
        boolean status = pi.checkInfo("Jacob");
        assertSame(false, status);
    }


}