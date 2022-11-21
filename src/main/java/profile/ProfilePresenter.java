package profile;

public class ProfilePresenter implements ProfileOutputBoundary{
    ProfileBox pb;
    InfoViewBox ivb;
    InfoSetBox isb;

    @Override
    public void viewCreated(String result) {
        pb.hasCreated(result);
    }

    @Override
    public void noCreated() {
        pb.noCreated();
    }

    @Override
    public void viewReviewed(String result) {
        pb.hasReviewed(result);
    }

    @Override
    public void noReviewed() {
        pb.noReviewed();
    }

    @Override
    public void setInfoResult() {
        isb.setInfoSuccess();
    }

    @Override
    public void viewInfo(String result) {
        ivb.viewInfoSuccess(result);
    }

    @Override
    public void setUI(ProfileBox pb) {
        this.pb = pb;
    }

    @Override
    public void setUI(InfoSetBox isb) {
        this.isb = isb;
    }

    @Override
    public void setUI(InfoViewBox ivb) {
        this.ivb = ivb;
    }

}
