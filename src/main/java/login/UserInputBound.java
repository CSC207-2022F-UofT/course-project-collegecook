package login;

import java.io.IOException;

public interface UserInputBound {
    void CheckAllUser(String username,String password);
    void Login(String username, String password);
    boolean CheckFollow(String username, String other);
    void follow(String username, String other) throws IOException;
    boolean CheckUnFollow(String username, String other);
    void Unfollow(String username, String other);
    String getLoggedInUser();
}
