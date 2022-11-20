package mealplan;
import entities.MealplanList;

import java.io.IOException;

public interface MealplanGateway {
    /**
     * @param mealplans mealplan list to be serialized
     */
    void saveToFile(MealplanList mealplans) throws IOException;


    MealplanList readFromFile() throws IOException, ClassNotFoundException;

}