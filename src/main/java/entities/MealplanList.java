package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MealplanList implements Serializable {
    private final Map<String, Mealplan> mealplans = new HashMap<>();

    /**
     * Add user to this user list.
     * @param username the user to add
     */
    public void add(String username, Mealplan mealplan) {
        mealplans.put(username, mealplan);
    }

    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public Mealplan getMealplan(String username) {
        return mealplans.get(username);
    }
}
