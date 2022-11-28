package login;

import entities.RecipeList;
import entities.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.RecipeReadWriter;
import recipe.RecipeRepoGateway;

import java.io.IOException;

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
    }

    @Test
    void login() {
    }

    @Test
    void logout() {
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