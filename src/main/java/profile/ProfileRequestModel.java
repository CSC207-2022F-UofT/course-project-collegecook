package profile;

public class ProfileRequestModel {
    private int age;
    private float height;
    private float weight;
    private String gender;

    public ProfileRequestModel(int age, float height, float weight, String gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

}
