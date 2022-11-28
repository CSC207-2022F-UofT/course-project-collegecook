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
    private String username;
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
     * @param age The input age of the user
     * Set the age of the user in his/her Profile.
     */
    public void setAge(int age) { this.age = age; }

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
     * @param height The input height of the user
     * Set the height of the user in his/her Profile.
     */
    public void setHeight(float height) { this.height = height; }

    /**
     * @param weight The input weight of the user
     * Set the weight of the user in his/her Profile.
     */
    public void setWeight(float weight) { this.weight = weight; }

    /**
     * @param gender The input gender of the user
     * Set the gender of the user in his/her Profile.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @param reviewed A arraylist of profile which contains all the recipes reviewed by the user.
     * Set the reviewed of the user in his/her Profile.
     */
    public void setReviewed(ArrayList<Review> reviewed) {
        this.reviewed = reviewed;
    }

    /**
     * @param created A arraylist of profile which contains all the recipes created by the user.
     * Set the reviewed of the user in his/her Profile.
     */
    public void setCreated(ArrayList<Recipe> created) {
        this.created = created;
    }


    /**
     * @return Return a string which contains all the recipes reviewed by the user.
     */
    public String soutReviewed() {
        String result = new String("");
        for (Review r : reviewed){
            result = result + r.toString() + "\n";
        }
        return result;
    }

    /**
     * @return Return a string which contains all the recipes created by the user.
     */
    public String soutCreated() {
        String result = new String("");
        for (Recipe r : created){
            result = result + r.toString() + "\n";
        }
        return result;
    }

    /**
     * @return Return a string that contains the age, height, weight, and gender of the user in this profile.
     */
    public String soutInfo(){
        String result = new String("");
        return "Age: " + age + "\n" +
                "Height: " + height + "cm \n" +
                "Weight: " + weight + "kg \n" +
                "Gender: " + gender + "\n";
    }

}
