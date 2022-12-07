package login;

import entities.Recipe;
import entities.RecipeList;
import entities.User;
import entities.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.RecipeReadWriter;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoImplTest {
    UserRepoImpl userRepoImpl;
    UserList ul;
    UserList temp;
    @BeforeEach
    void setUp() throws IOException {
        userRepoImpl = UserRepoImpl.getUserRepoImpl();
        temp = userRepoImpl.getAllUser();
        ul = userRepoImpl.getAllUser();
        User a = new User("a","12345");
        ul.AddAllUser("a","12345");
        userRepoImpl.saveUser(ul);
    }
    @AfterEach
    void tearDown() throws IOException {
        userRepoImpl.saveUser(temp);
        userRepoImpl = null;
        ul = null;
        temp = null;

    }

    @Test
    void getUserRepoImpl() {
        assertSame(userRepoImpl,  UserRepoImpl.getUserRepoImpl());
    }

    @Test
    void getAllUser() throws IOException {
        assertTrue(userRepoImpl.getAllUser().contains("a"));
    }

    @Test
    void saveUser() throws IOException {
        ul.AddAllUser("c","12345");
        userRepoImpl.saveUser(ul);
        assertTrue(userRepoImpl.getAllUser().contains("c"));
    }

}