package sort;

public interface SortInputBoundary {
    SortResponseModel sortRecipesByAverageRating(SortRequestModel requestModel);
    SortResponseModel sortRecipesByTimeNeeded(SortRequestModel requestModel);
    SortResponseModel sortRecipesByNumberOfReviews(SortRequestModel requestModel);
}
