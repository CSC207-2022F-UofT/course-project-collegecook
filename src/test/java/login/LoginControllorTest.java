package login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginControllorTest {
    LoginController loginController;
    @BeforeEach
    void setup() {
        LoginInputBound loginInputBound = new LoginInputBound() {
            @Override
            public void CheckAllUser(String username, String password) {assertTrue(true);}

            @Override
            public void Login(String username, String password) {assertTrue(true);}

            @Override
            public boolean CheckFollow(String username, String other) {return true;}

            @Override
            public void follow(String username, String other) throws IOException {assertTrue(true);}

            @Override
            public boolean CheckUnFollow(String username, String other) {return true;}

            @Override
            public void Unfollow(String username, String other) {assertTrue(true);}

            @Override
            public String getLoggedInUser() {return null;}
        };
        loginController = new LoginController(loginInputBound);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
     void performCreateAllUser() {
        loginController.PerformCreateAllUser("a","12345");
    }

    @Test
    void performLogin() {
        loginController.PerformLogin("a","12345");
    }

    @Test
    void preformFollow() throws IOException {
        loginController.PerformCreateAllUser("b","12345");
        loginController.PreformFollow("a","b");
    }

    @Test
    void preformUnFollow() {
        loginController.PreformUnFollow("a","b");
    }

    @Test
    void preformGetLoggedInUser() {
        assertNull(loginController.preformGetLoggedInUser());
    }
}