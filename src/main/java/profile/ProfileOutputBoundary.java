package profile;

public interface ProfileOutputBoundary {
    void viewReviewed(String result);
    void noReviewed();
    void viewCreated(String result);
    void noCreated();
    void setInfoResult();
    void viewInfo(String result);
    void setUI(ProfileBox pb);
    void setUI(InfoSetBox isb);
    void setUI(InfoViewBox ivb);
}
