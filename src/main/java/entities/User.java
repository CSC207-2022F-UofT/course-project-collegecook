package entities;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class User{

    private String username;
    private String password;

    private boolean LoginStatus;
    private Profile profile;
    private List<User> followers;
    private List<User> followed;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public boolean isLoginStatus() {
        return LoginStatus;
    }

    public int GetNumberOfFollowers(){return followers.size();}

    public int GetNumberOfFollowed(){return followed.size(); }

    public void setLoginStatus(boolean loginStatus) {
        LoginStatus = loginStatus;
    }

    public void addFollowers(List<User> followers) {
        this.followers.add((User) followers);
    }
    public void addFollowed(List<User> followed) {
        this.followed.add((User) followed);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void RemoveFollowers(List<User> followers) {
        this.followers.remove((User) followers);
    }

    public void RemoveFollowed(List<User> followed) {
        this.followed.remove((User) followed);
    }
    // Comparator for sorting the list by followers
    public static Comparator<User> UserFollowerComparator = new Comparator<User>() {
        public int compare(User u1, User u2) {
            int userFollowers1 = u1.GetNumberOfFollowers();
            int userFollowers2 = u2.GetNumberOfFollowers();
            return userFollowers1 - userFollowers2;
        }
    };

    // Comparator for sorting the list by average rating
    public static Comparator<User> UserAvgRating = new Comparator<User>() {
        public int compare(User u1, User u2) {
            AverageRatings averageRatings = new AverageRatings();
            double userAvgRating1 = averageRatings.getAverageRating(u1.getUsername());
            double userAvgRating2 = averageRatings.getAverageRating(u2.getUsername());
            double userAvgDiff = userAvgRating1-userAvgRating2;
            if(userAvgDiff>0){return 1;}
            if(userAvgDiff<0){return -1;}
            return 0;
        }
    };

    // Comparator for sorting the list by Total Recipe
    public static Comparator<User> UserTotalRecipe = new Comparator<User>() {
        public int compare(User u1, User u2) {
            Profile profile1 = new Profile(u1.getUsername());
            Profile profile2 = new Profile(u2.getUsername());
            int userTotalrecipe1 = profile1.getCreated().size();
            int userTotalrecipe2 = profile2.getCreated().size();
            return userTotalrecipe1 - userTotalrecipe2;
        }
    };


}

