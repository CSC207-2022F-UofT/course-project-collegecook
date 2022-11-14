package Login;

public class LoginPresenter implements LoginOutputBound{
    @Override
    public void LoginSuccess() {
        System.out.println("You have logged in");
    }

    @Override
    public void LoginFailed() {
        System.out.println("Username or password fail");

    }

    @Override
    public void CreatAccountSuccess() {
        System.out.println("You have created a new account");

    }

    @Override
    public void CreatAccountFail() {
        System.out.println("Please choose another username");

    }

    @Override
    public void LogoutSuccess() {
        System.out.println("You have logged out");

    }

    @Override
    public void LogoutFail() {
        System.out.println("You have logged out");

    }

    @Override
    public void FollowedSuccess() {
        System.out.println("You have followed");

    }

    @Override
    public void FollowedFail() {

    }

// sent user message to re-enter a username when creating account

}
