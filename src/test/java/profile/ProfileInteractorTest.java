package profile;

import entities.Profile;
import entities.RecipeList;
import org.junit.jupiter.api.BeforeEach;
import recipe.RecipeInteractor;
import recipe.RecipeOutputBoundary;
import recipe.RecipePresenter;
import recipe.RecipeRepoGateway;
import ui.AppController;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileInteractorTest {
    ProfileInteractor pi;
    ProfileRepoGateway prg;
    ProfileController pc;
    ArrayList<Profile> temp;

    @BeforeEach
    void setUp() throws IOException {
        ProfileOutputBoundary output = new ProfilePresenter();
        prg = ProfileRepoImpl.getPrl();
        pi = new ProfileInteractor(output);
        pc = new ProfileController(pi);
    }

}