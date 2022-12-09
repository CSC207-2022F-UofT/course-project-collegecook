package profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileRequestModelTest {
    /**
     * This test covers 100% ProfileRequestModel class in the profile package,
     * 100% methods, and 100% lines.
     */

    ProfileRequestModel profileRequestModel;

    @BeforeEach
    void setUp() {
        profileRequestModel = new ProfileRequestModel(20, 163, 45, "Female");
    }

    @AfterEach
    void tearDown(){
        profileRequestModel = null;
    }

    @Test
    void testGetAgePrm(){
        assertEquals(20, profileRequestModel.getAge());
    }

    @Test
    void testGetHeightPrm(){
        assertEquals(163, profileRequestModel.getHeight());
    }
    @Test
    void testGetWeightPrm(){
        assertEquals(45, profileRequestModel.getWeight());
    }
    @Test
    void testGetGenderPrm(){
        assertEquals("Female", profileRequestModel.getGender());
    }

}
