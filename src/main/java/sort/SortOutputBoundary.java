package sort;

public interface SortOutputBoundary{
    public SortResponseModel prepareSuccessView(SortResponseModel responseModel);
    public SortResponseModel prepareErrorView(SortResponseModel responseModel);
}
