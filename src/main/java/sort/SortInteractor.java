package sort;

public class SortInteractor implements SortInputBoundary{

    final SortPresenter sortPresenter;

    public SortInteractor(SortPresenter sortPresenter) {
        this.sortPresenter = sortPresenter;
    }

    @Override
    public SortResponseModel sortRecipesByAverageRating(SortRequestModel requestModel) {
        return null;
    }
    @Override
    public SortResponseModel sortRecipesByNumberOfReviews(SortRequestModel requestModel) {
        return null;
    }

    @Override
    public SortResponseModel sortRecipesByTimeNeeded(SortRequestModel requestModel) {
        return null;
    }

}