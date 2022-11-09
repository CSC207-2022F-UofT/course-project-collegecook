package Entities;

import java.util.List;
import java.io.Serializable;

public class Recipe implements Serializable{
    private String recipe_name;
    private String procedure;
    private String cuisine;
    private List<String> ingredients;
    private int calories;
    private int time;
    private int difficulty;
    private User creator;


    public Recipe(String recipe_name, String procedure, String cuisine, List<String> ingredients,
                  int calories, int time, int difficulty){
        this.procedure = procedure;
        this.recipe_name = recipe_name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.calories = calories;
        this.time = time;
        this.difficulty = difficulty;
    }

    public String get_procedure(){return this.procedure;}
    public String get_recipe_name(){return this.recipe_name;
    }
    public String get_cuisine(){return this.cuisine;}
    public int get_calories(){return this.calories;}
    public int get_time(){return this.time;}
    public int get_difficulty(){return this.difficulty;}

    public List<String> get_ingredients(){return this.ingredients;}

    public void set_cuisine(String cuisine){this.cuisine = cuisine;}
    public void set_calories(int calories){this.calories = calories;}
    public void set_time(int time){this.time = time;}
    public void set_difficulty(int difficulty){this.difficulty = difficulty;}

    public void set_ingredients(List<String> ingredients){this.ingredients = ingredients;}













}
