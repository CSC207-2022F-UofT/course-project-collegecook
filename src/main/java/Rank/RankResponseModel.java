package Rank;

public class RankResponseModel {
    String rank;
    String[] users;

    public RankResponseModel(String rank, String[] users) {
        this.rank = rank;
        this.users = users;
    }
    public String getRank() {
        return rank;
    }
    public String[] getUsers() {
        return users;
    }
}
