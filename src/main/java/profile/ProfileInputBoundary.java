package profile;

import entities.User;

import java.io.IOException;

public interface ProfileInputBoundary {
    void all_created(String username) throws IOException;
    void all_reviewed(String username) throws IOException;
    void set_info(String username, int age, float height, float weight, String gender) throws IOException;
}
