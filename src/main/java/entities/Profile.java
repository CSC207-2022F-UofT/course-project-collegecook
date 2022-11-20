package entities;

import java.util.ArrayList;

public class Profile {

    private ArrayList<Review> reviewed;
    private ArrayList<Recipe> created;
    private int age;
    private float height;
    private float weight;
    private String username;
    private String gender;

    public Profile(String username) {
        this.reviewed = new ArrayList<>();
        this.created = new ArrayList<>();
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) { this.age = age; }

    public void setHeight(float height) { this.height = height; }

    public void setWeight(float weight) { this.weight = weight; }

    public String soutReviewed() {
        String result = new String("");
        for (Review r : reviewed){
            result = result + r.toString() + "\n";
        }
        return result;
    }

    public String soutCreated() {
        String result = new String("");
        for (Recipe r : created){
            result = result + r.toString() + "\n";
        }
        return result;
    }

    public String soutInfo(){
        String result = new String("");
        return "Age: " + age + "\n" +
                "Height: " + height + "\n" +
                "Weight: " + weight + "\n" +
                "Gender: " + gender + "\n";
    }


    public ArrayList<Review> getReviewed() {
        return reviewed;
    }

    public ArrayList<Recipe> getCreated() {
        return created;
    }

    public void setReviewed(ArrayList<Review> reviewed) {
        this.reviewed = reviewed;
    }


    public void setCreated(ArrayList<Recipe> created) {
        this.created = created;
    }

}
