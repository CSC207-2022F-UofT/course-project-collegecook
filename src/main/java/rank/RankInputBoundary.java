package rank;

public interface RankInputBoundary {
    /**
     *
     * Interface which contains method that needs to be implemented
     * for the feature to successfully run.
     *
     * @param requestModel contains the choice of vari
     */
    RankResponseModel sort(RankRequestModel requestModel);
}