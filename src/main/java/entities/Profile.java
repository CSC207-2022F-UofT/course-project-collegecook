package entities;

import java.io.Serializable;
import java.util.ArrayList;


public class Profile implements Serializable {
    /**
     * This is the class of Recipe, which is an entity.
     */

    private ArrayList<Review> reviewed;
    private ArrayList<Recipe> created;
    private int age;
    private float height;
    private float weight;
    private final String username;
    private String gender;

    /**
     * Construct a Profile with the given username.
     * @param username The username of the user of this profile.
     */

    public Profile(String username) {
        this.reviewed = new ArrayList<>();
        this.created = new ArrayList<>();
        this.username = username;
    }


    /**
     * Get the age of the user in his/her Profile.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the height of the user in his/her Profile.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Get the weight of the user in his/her Profile.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Get the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the gender of the user in his/her Profile.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get all recipes that are reviewed by the user in his/her Profile.
     */
    public ArrayList<Review> getReviewed() {
        return reviewed;
    }

    /**
     * Get all recipes that are created by the user in his/her Profile.
     */
    public ArrayList<Recipe> getCreated() {
        return created;
    }


    /**
     * Set the age of the user in his/her Profile.
     * @param age The input age of the user
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Set the height of the user in his/her Profile.
     * @param height The input height of the user
     */
    public void setHeight(float height) { this.height = height; }

    /**
     * Set the weight of the user in his/her Profile.
     * @param weight The input weight of the user
     */
    public void setWeight(float weight) { this.weight = weight; }

    /**
     * Set the gender of the user in his/her Profile.
     * @param gender The input gender of the user
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set the reviewed of the user in his/her Profile.
     * @param reviewed An arraylist of profile which contains all the recipes reviewed by the user.
     */
    public void setReviewed(ArrayList<Review> reviewed) {
        this.reviewed = reviewed;
    }

    /**
     * Set the reviewed of the user in his/her Profile.
     * @param created An arraylist of profile which contains all the recipes created by the user.
     */
    public void setCreated(ArrayList<Recipe> created) {
        this.created = created;
    }


    /**
     * A method that returns all information of the reviewed recipes of the user in this profile.
     * @return Return a string which contains all the recipes reviewed by the user.
     */
    public String reviewedInformation() {
        StringBuilder result = new StringBuilder();
        for (Review r : reviewed){
            result.append("Recipe: ").append(r.getRecipe().getRecipeName()).append(System.lineSeparator()).
                    append("Rating: ").append(r.getRating()).append("/5").append(System.lineSeparator()).append("\"").
                    append(r.getContent()).append("\"").append(System.lineSeparator()).append(System.lineSeparator());
        }
        return result.toString();
    }

    /**
     * A method that returns all information of the created recipes of the user in this profile.
     * @return Return a string which contains all the recipes created by the user.
     */
    public String createdInformation() {
        StringBuilder result = new StringBuilder();
        for (Recipe r : created){
            result.append(r.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

    /**
     * A method that returns all information of the user in this profile.
     * @return Return a string that contains the age, height, weight, and gender of the user in this profile.
     */
    public String infoDetail(){
        return "Age: " + age + "\n" +
                "Height: " + height + "cm \n" +
                "Weight: " + weight + "kg \n" +
                "Gender: " + gender + "\n";
    }

}
