package mealplan;
import entities.MealplanList;
import entities.Profile;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MealplanInteractorTest {
    MealplanGateway mealplanGate;
    MealplanInputBoundary mealplanInteractor;
    RecipeList rl;
    MealplanList temp;
    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        MealplanOutputBoundary mealplanOutputBoundary= new MealplanPresenter();
        mealplanGate = MealplanGate.getInstance();
        temp = mealplanGate.readFromFile();
        mealplanInteractor = new MealplanInteractor(mealplanOutputBoundary, "user",mealplanGate);
        mealplanInteractor.deleteMealplan(0);
        mealplanInteractor.deleteMealplan(1);
        mealplanInteractor.deleteMealplan(2);
    }

    @AfterEach
    void tearDown() throws IOException {
        mealplanGate.saveToFile(temp);
        mealplanGate = null;
    }

    @Test
    void getMealplanlist() throws IOException{
        mealplanInteractor.addRecipe("recipe2",1);
        mealplanInteractor.saveMealplan();
        assertNotNull(mealplanInteractor.getMealplanList().getMealplan("user"));
    }


    @Test
    void addRecipe(){
        mealplanInteractor.addRecipe("recipe",0);
        assertTrue(mealplanInteractor.getMealplan().returnMealPlan().get(0).contains("recipe"));
    }

    @Test
    void computeRecipeCal(){
        rl = new RecipeList();
        ArrayList<String> ingredients = new ArrayList<>();
        rl.addRecipe("recipe", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        rl.addRecipe("recipe2", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        mealplanInteractor.addRecipe("recipe",0);
        mealplanInteractor.addRecipe("recipe2",1);
        assertEquals(1000,mealplanInteractor.computeRecipeCal(rl));
    }

    @Test
    void computeProfileCal(){
        Profile pro = new Profile("user");
        pro.setAge(20);
        pro.setGender("Male");
        pro.setHeight(180);
        pro.setWeight(60);
        assertEquals(1631,mealplanInteractor.computeProfileCal(pro));

    }

    @Test
    void deleteMealplan(){
        mealplanInteractor.deleteMealplan(1);
        assertTrue(mealplanInteractor.getMealplan().returnMealPlan().get(1).isEmpty());
    }

    @Test
    void saveMealplan() throws IOException {
        mealplanInteractor.saveMealplan();
        assertNotNull(mealplanInteractor.getMealplanList().getMealplan(mealplanInteractor.getUsername()));
    }

    @Test
    void getUser(){
        assertEquals("user", mealplanInteractor.getUsername());
    }

    @Test
    void computeCalories(){
        MealplanOutputBoundary mealplanOutputBoundary = new MealplanOutputBoundary() {
            @Override
            public void createCaloriesView(List<Integer> cal) {
                assertEquals(1631, (int) cal.get(0));
            }

            @Override
            public void setUI(MealplanBox mealplanbox) {

            }
        };
        Profile pro = new Profile("user");
        pro.setAge(20);
        pro.setGender("Male");
        pro.setHeight(180);
        pro.setWeight(60);


        MealplanInteractor mealplanInteractor = new MealplanInteractor(mealplanOutputBoundary,"user",MealplanGate.getInstance());
        rl = new RecipeList();
        ArrayList<String> ingredients = new ArrayList<>();
        rl.add_recipe("recipe", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        rl.add_recipe("recipe2", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        mealplanInteractor.addRecipe("recipe",0);
        mealplanInteractor.addRecipe("recipe2",1);

        mealplanInteractor.computeCalories(pro, rl);
    }

}
