package profile;

import entities.Profile;

public interface ProfileOutputBoundary {
    void view_reviewed(Profile p);
    void view_created(Profile p);
    void set_info_success();
}
