package login;

public interface LoginOutputBound {
    void LoginSuccess();
    void LoginFailed();
    void CreatAccountSuccess();
    void CreatAccountFail();

    void LogoutFail();

    void FollowedSuccess();
    void FollowedFail();

    void UnFollowedSuccess();
    void UnFollowedFail();
    void AddProfile();


}
