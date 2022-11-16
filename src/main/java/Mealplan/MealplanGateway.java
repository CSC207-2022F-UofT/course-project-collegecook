package Mealplan;
import Entities.MealplanList;

import java.io.IOException;

public interface MealplanGateway {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    MealplanList readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
