package mealplan;
import entities.MealplanList;
import entities.Profile;
import entities.RecipeList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

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
    void getMealplanlist() throws IOException, ClassNotFoundException {
        mealplanInteractor.addRecipe("recipe",1);
        assertEquals(mealplanInteractor.getMealplanList(),mealplanGate.readFromFile());
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
        rl.add_recipe("recipe", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        rl.add_recipe("recipe2", "procedure",
                "cuisine", ingredients, 500, 2, 3, "Brenden");
        mealplanInteractor.addRecipe("recipe2",1);
        assertEquals(1000,mealplanInteractor.computeRecipeCal(rl));
    }

    @Test
    void computeProfileCal(){
        Profile pro = new Profile("user");
        pro.setAge(20);
        pro.setGender("male");
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


}
