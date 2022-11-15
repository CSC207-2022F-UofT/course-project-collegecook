package Entities;

public class UserCalories {

    public static int getUserCalories(){
        Profile pro = new Profile(new User("hi","tyy"));
        int weight = pro.getWeight();
        int height = pro.getHeight();
        boolean gender = pro.getGender();
        int age = pro.getAge();
        int calories;

        if (gender){
            calories = (int) (9.99 * weight + 6.25 * height  - 4.92 * age + 5);
        }else{
            calories = (int) (9.99 * weight + 6.25 * height  - 4.92 * age - 161);
        }

        return calories;
    }
}
