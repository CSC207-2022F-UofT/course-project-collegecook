package entities;

import java.util.ArrayList;

public class Profile {

    private ArrayList<Recipe> reviewed;
    private ArrayList<Recipe> created;
    private int age;
    private int height;
    private int weight;

    public Profile() {
        this.reviewed = new ArrayList<>();
        this.created = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(int age) { this.age = age; }

    public void setHeight(int height) { this.height = height; }

    public void setWeight(int weight) { this.weight = weight; }

    public void storeallreviewed(){
        //get all reviewed recipes from somewhere in Review,
        //and add them in reviewed.
    }


    public void storeallcreated(){
        //get all created recipes from somewhere in Recipe,
        //and add them in created.
    }

    public ArrayList<Recipe> getReviewed() { return reviewed; }

    public ArrayList<Recipe> getCreated() { return created; }
}