package login;

import entities.RecipeList;
import entities.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    UserGateWay userGateWay;
    UserList temp;
    String WrongName;

    @BeforeEach
    void setUp() throws IOException {
        userGateWay = UserRepoImpl.getUserRepoImpl();
        temp = userGateWay.getAllUser();
    }

    @AfterEach
    void tearDown()throws IOException {
        userGateWay.saveUser(temp);
        userGateWay = null;

    }

    @Test
    void checkAllUser() {
        LoginOutputBound loginOutputBound = new LoginOutputBound() {
            @Override
            public void LoginSuccess() {

            }

            @Override
            public void LoginFailed() {

            }

            @Override
            public void CreatAccountSuccess() {
                UserList userList = null;
                try {
                    userList = userGateWay.getAllUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                assertTrue(userList.contains("a"));

            }

            @Override
            public void CreatAccountFail() {
                UserList userList = null;
                try {
                    userList = userGateWay.getAllUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                assertTrue(userList.contains("a"));

            }

            @Override
            public void LogoutFail() {

            }

            @Override
            public void FollowedSuccess() {

            }

            @Override
            public void FollowedFail() {

            }

            @Override
            public void UnFollowedSuccess() {

            }

            @Override
            public void UnFollowedFail() {

            }

            @Override
            public void AddProfile() {

            }

            @Override
            public void setUI(LoginBox loginBox) {

            }

            @Override
            public void setUI(SignUpBox signUpBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        UserManager userManager = new UserManager(loginOutputBound,userGateWay);
        userManager.CheckAllUser("a","12345");
    }




    @Test
    void login() {
        LoginOutputBound loginOutputBound = new LoginOutputBound() {
            @Override
            public void LoginSuccess() {

            }

            @Override
            public void LoginFailed() {

            }

            @Override
            public void CreatAccountSuccess() {

            }

            @Override
            public void CreatAccountFail() {

            }

            @Override
            public void LogoutFail() {

            }

            @Override
            public void FollowedSuccess() {

            }

            @Override
            public void FollowedFail() {

            }

            @Override
            public void UnFollowedSuccess() {

            }

            @Override
            public void UnFollowedFail() {

            }

            @Override
            public void AddProfile() {

            }

            @Override
            public void setUI(LoginBox loginBox) {

            }

            @Override
            public void setUI(SignUpBox signUpBox) {

            }

            @Override
            public void setUI(RecipeViewBox recipeViewBox) {

            }
        };
        UserManager userManager = new UserManager(loginOutputBound,userGateWay);
        userManager.CheckAllUser("a","12345");
        userManager.Login("a","12345");
        String expected = "a";
        String actual = userManager.getLoggedInUser() ;
        assertEquals(expected, actual);

    }


    @Test
    void checkFollow() {
    }

    @Test
    void follow() {
    }

    @Test
    void checkUnFollow() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void getLoggedInUser() {
    }
}