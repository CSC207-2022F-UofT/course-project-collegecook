package profile;

import entities.Profile;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.*;
import ui.AppController;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileInteractorTest {
    ProfileRepoGateway prg;
    ArrayList<Profile> temp;

    @BeforeEach
    void setUp() throws IOException {
        prg = ProfileRepoImpl.getPrl();
        temp = prg.getProfile();
    }

    @AfterEach
    void tearDown() throws IOException {
        prg.saveProfile(temp);
        prg = null;
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
        ProfileRequestModel prm = new ProfileRequestModel(20, 163, 45, "Female");
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.setInfo("Allison", prm);
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
                        if (!p.getCreated().isEmpty()) {
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
        ProfileRequestModel prm = new ProfileRequestModel(20, 163, 45, "Female");
        ProfileInteractor pi = new ProfileInteractor(output);
        pi.setInfo("Allison", prm);
        pi.allReviewed("Allison");
    }

    @Test
    void testCheckProfile(){
        // todo
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
                ArrayList<Profile> profileList = null;
                try {
                    profileList = prg.getProfile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Profile p : profileList) {
                    if (p.getUsername().equals("Allison")) {
                        assertEquals(20, p.getAge());
                        assertEquals(163, p.getHeight());
                        assertEquals(45, p.getWeight());
                        assertEquals("Female", p.getGender());
                    }
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
    void testViewInfo(){
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
    }

    @Test
    void testCheckInfo(){

    }

    @Test
    void testSetAll(){

    }


}