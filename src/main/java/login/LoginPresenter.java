package login;

public class LoginPresenter implements LoginOutputBound{
    @Override
    public void LoginSuccess() {
        System.out.println("You have logged in");
    }

    @Override
    public void LoginFailed() {
        System.out.println("Username or password failed");

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
    public void LogoutFail() {
        System.out.println("You have logged out");

    }

    @Override
    public void FollowedSuccess() {
        System.out.println("Followed successfully");

    }

    @Override
    public void FollowedFail() {
        System.out.println("You have already followed this user or the user doesn't exist");

    }

    @Override
    public void UnFollowedSuccess() {
        System.out.println("Unfollowed successfully");

    }

    @Override
    public void UnFollowedFail() {
        System.out.println("Unfollow fail,You did not follow this user");

    }

    @Override
    public void AddProfile() {
        System.out.println("Please Check Username");

    }
}
