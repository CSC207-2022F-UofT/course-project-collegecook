package profile;

public class ProfileRequestModel {
    /**
     * This is a RequestModel, which combines information inputs together to avoid data clump (code smell).
     */
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
