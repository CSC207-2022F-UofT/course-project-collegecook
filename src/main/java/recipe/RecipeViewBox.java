package recipe;

public interface RecipeViewBox {
    void success(String result);

    void failure();

    void followSuccess();

    void followFailure();
}
