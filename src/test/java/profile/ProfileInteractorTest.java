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
    /**
     * This test covers 100% ProfileInteractor class in the profile package,
     * 100% methods, and 94% lines.
     * The line coverage doesn't reach 100% because the constructor of ProfileInteractor
     * will catch IOException if any. But this testing actually could not generate an IOException,
     * since a list of profiles will always be gotten from the local file.
     */

    ProfileRepoGateway profileRepoGateway;
    ArrayList<Profile> tempProfile;
    RecipeRepoGateway recipeRepoGateway;
    RecipeList tempRecipe;
    ReviewDatabaseReadWriter reviewDatabaseReadWriter;
    ReviewDatabase current;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        profileRepoGateway = ProfileRepoImpl.getProfileRepoImpl();
        tempProfile = profileRepoGateway.getProfile();
        ArrayList<Profile> profileList = new ArrayList<>();
        Profile profile = new Profile("Allison");
        Profile profile2 = new Profile("Jacob");
        profileList.add(profile);
        profileList.add(profile2);
        profileRepoGateway.saveProfile(profileList);

        recipeRepoGateway = RecipeReadWriter.getRecipeRepo();
        tempRecipe = recipeRepoGateway.getRecipeList();

        reviewDatabaseReadWriter = ReviewDatabaseReadWriter.getReviewRepo();
        current = reviewDatabaseReadWriter.readFromFile("reviews.sav");
    }

    @AfterEach
    void tearDown() throws IOException {
        profileRepoGateway.saveProfile(tempProfile);
        profileRepoGateway = null;
        recipeRepoGateway.saveRecipe(tempRecipe);
        recipeRepoGateway = null;
        reviewDatabaseReadWriter.saveToFile("reviews.sav", current);
        reviewDatabaseReadWriter = null;
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
                ArrayList<Profile> profileList;
                try{
                    profileList = profileRepoGateway.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p: profileList){
                    if (p.getUsername().equals("Allison")){
                        if (!p.getCreated().isEmpty()){
                            String expected = p.createdInformation();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noCreated() {
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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
                ArrayList<Profile> profileList;
                try{
                    profileList = profileRepoGateway.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p: profileList){
                    if (p.getUsername().equals("Allison")){
                        if (!p.getCreated().isEmpty()){
                            String expected = p.createdInformation();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noCreated() {
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

            }

            @Override
            public void setUI(InfoSetBox infoSetBox) {

            }

            @Override
            public void setUI(InfoViewBox infoViewBox) {

            }
        };
        ArrayList<String> ta = new ArrayList<>();
        RecipeList recipeList = recipeRepoGateway.getRecipeList();
        recipeList.addRecipe("Test", "Procedure", "cuisine", ta, 1, 2,
                3, "Allison");
        recipeRepoGateway.saveRecipe(recipeList);
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.allCreated("Allison");
    }

    @Test
    void testAllReviewed() throws IOException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        if (!p.getReviewed().isEmpty()) {
                            String expected = p.reviewedInformation();
                            assertEquals(result, expected);
                        }
                    }
                }
            }

            @Override
            public void noReviewed() {
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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
    void testAllReviewedNonEmpty() throws IOException, ClassNotFoundException {
        ProfileOutputBoundary output = new ProfileOutputBoundary() {
            @Override
            public void viewReviewed(String result) {
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        if (!p.getReviewed().isEmpty()) {
                            String expected = p.reviewedInformation();
                            assertEquals(result, expected);
                        }
                    }
                }
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
            public void setUI(ProfileReviewBox profileReviewBox) {

            }

            @Override
            public void setUI(ProfileCreateBox profileCreateBox) {

            }

            @Override
            public void setUI(InfoSetBox infoSetBox) {

            }

            @Override
            public void setUI(InfoViewBox infoViewBox) {

            }
        };
        ArrayList<String> ta = new ArrayList<>();
        RecipeList recipeList = recipeRepoGateway.getRecipeList();
        Recipe recipe = new Recipe("Test2", "Procedure", "cuisine", ta, 1, 2,
                3, "Cindy");
        recipeList.addRecipe("Test2", "Procedure", "cuisine", ta, 1, 2,
                3, "Cindy");

        ReviewDatabase reviewDatabase = reviewDatabaseReadWriter.readFromFile("reviews.sav");
        Review review = new Review("Allison", recipe, "good", 4);
        reviewDatabase.addReview(review);
        reviewDatabaseReadWriter.saveToFile("reviews.sav", reviewDatabase);

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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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
        profileRepoGateway.saveProfile(pl);
        ProfileInteractor pi = new ProfileInteractor(output);
        Profile result = pi.checkProfile("Allison");
        assertEquals("Allison", result.getUsername());
    }

    @Test
    void testCheckProfile2() throws IOException{
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
            public void setUI(ProfileReviewBox profileReviewBox) {

            }

            @Override
            public void setUI(ProfileCreateBox profileCreateBox) {

            }

            @Override
            public void setUI(InfoSetBox infoSetBox) {

            }

            @Override
            public void setUI(InfoViewBox infoViewBox) {

            }
        };
        ProfileInteractor pi = new ProfileInteractor(output);
        Profile result = pi.checkProfile("Maya");
        assertEquals("Maya", result.getUsername());
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
                    ArrayList<Profile> profileList = profileRepoGateway.getProfile();
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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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
                ArrayList<Profile> profileList;
                try {
                    profileList = profileRepoGateway.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        String expected = p.infoDetail();
                        assertEquals(expected, result);
                    }
                }
            }

            @Override
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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
            public void setUI(ProfileReviewBox prb) {

            }

            @Override
            public void setUI(ProfileCreateBox pcb) {

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