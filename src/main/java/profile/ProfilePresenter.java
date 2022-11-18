package profile;

import entities.Profile;

public class ProfilePresenter implements ProfileOutputBoundary{

    @Override
    public void view_created(Profile p) {
        if (p.getCreated().isEmpty()){
            System.out.println("You have no created recipes. ");
        }
        else{
            System.out.println(p.soutCreated());
        }
    }

    @Override
    public void view_reviewed(Profile p) {
        if (p.getReviewed().isEmpty()){
            System.out.println("You have no reviewed recipes. ");
        }
        else{
            System.out.println(p.soutReviewed());
        }
    }

    @Override
    public void set_info_success() {
        System.out.println("You have successfully set your information. ");
    }
}
