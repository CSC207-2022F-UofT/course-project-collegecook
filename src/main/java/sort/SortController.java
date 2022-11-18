package sort;

public class SortController {
    // Sort by time, averageRating, difficulty, number of ingredients
    String sortType;

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType(){
        return this.sortType;
    }
}
