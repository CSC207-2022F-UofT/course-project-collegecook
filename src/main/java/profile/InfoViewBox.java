package profile;

/**
 *This is an interface between the view layer and the presenter layer. Related UI should implement this interface.
 */
public interface InfoViewBox {
    /**
     * Present the interface of viewInfoSuccess when the user's information has already been filled and needed to
     * view the information.
     */
    void viewInfoSuccess(String result);

}
