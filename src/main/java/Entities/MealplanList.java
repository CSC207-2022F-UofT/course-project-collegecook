package Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MealplanList implements Serializable {
    private final Map<String, Mealplan> mealplans = new HashMap<>();

    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public void add(User user, Mealplan mealplan) {
        mealplans.put(user.getUsername(), mealplan);
    }

    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public Mealplan getMealplan(String username) {
        return mealplans.get(username);
    }
}
