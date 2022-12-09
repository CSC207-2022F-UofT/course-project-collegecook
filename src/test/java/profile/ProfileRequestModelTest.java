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

    ProfileRequestModel prm;

    @BeforeEach
    void setUp() {
        prm = new ProfileRequestModel(20, 163, 45, "Female");
    }

    @AfterEach
    void tearDown(){
        prm = null;
    }

    @Test
    void testGetAgePrm(){
        assertEquals(20, prm.getAge());
    }

    @Test
    void testGetHeightPrm(){
        assertEquals(163, prm.getHeight());
    }
    @Test
    void testGetWeightPrm(){
        assertEquals(45, prm.getWeight());
    }
    @Test
    void testGetGenderPrm(){
        assertEquals("Female", prm.getGender());
    }

}
