package login;

import entities.RecipeList;
import entities.User;
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
                assertFalse(userList.contains("d"));

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
                assertFalse(userList.contains("c"));

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
        userManager.CheckAllUser("a","12345");

    }




    @Test
    void login() {
        LoginOutputBound loginOutputBound = new LoginOutputBound() {
            @Override
            public void LoginSuccess() {
                UserList userList = null;
                try {
                    userList = userGateWay.getAllUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                assertTrue(userList.contains("a"));

            }



            @Override
            public void LoginFailed() {
                UserList userList = null;
                try {
                    userList = userGateWay.getAllUser();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                assertFalse(userList.contains("c"));

            }


            @Override
            public void CreatAccountSuccess() {

            }

            @Override
            public void CreatAccountFail() {

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
        User c = new User("c","12345");
        userManager.Login(c.getUsername(),"12345");
        String actual1 = userManager.getLoggedInUser() ;
        assertEquals(null, actual1);
        userManager.Login("a","12345");
        String expected = "a";
        String actual = userManager.getLoggedInUser() ;
        assertEquals(expected, actual);

    }


    @Test
    void checkFollow() throws IOException { LoginOutputBound loginOutputBound = new LoginOutputBound() {
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
        userManager.CheckAllUser("b","12345");
        Boolean expected = true;
        Boolean actual = userManager.CheckFollow("a","b");
        assertEquals(expected, actual);


    }

    @Test
    void follow()throws IOException {
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
        userManager.CheckAllUser("b","12345");
        User c = new User("c","12345");
        userManager.follow("a","b");
        Boolean expected = false;
        Boolean actual = userManager.CheckFollow("a","b");
        assertEquals(expected, actual);
        Boolean expected1 = false;
        Boolean actual1 = userManager.CheckFollow("a",c.getUsername());
        assertEquals(expected1, actual1);
    }

    @Test
    void checkUnFollow() throws IOException {LoginOutputBound loginOutputBound = new LoginOutputBound() {
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
        userManager.CheckAllUser("b","12345");
        userManager.follow("a","b");
        Boolean expected = true;
        Boolean actual = userManager.CheckUnFollow("a","b");
        assertEquals(expected, actual);
    }

    @Test
    void unfollow() throws IOException {LoginOutputBound loginOutputBound = new LoginOutputBound() {
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
        userManager.CheckAllUser("b","12345");
        User c = new User("c","12345");
        userManager.follow("a","b");
        userManager.Unfollow("a","b");
        Boolean expected = false;
        Boolean actual = userManager.CheckUnFollow("a","b");
        assertEquals(expected, actual);
        Boolean expected1 = false;
        Boolean actual1 = userManager.CheckUnFollow("a",c.getUsername());
        assertEquals(expected1, actual1);
    }

    @Test
    void getLoggedInUser() {
    }
}