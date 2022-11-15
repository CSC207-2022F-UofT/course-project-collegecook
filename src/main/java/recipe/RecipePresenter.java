package recipe;

public class RecipePresenter implements RecipeOutputBoundary{
    @Override
    public void createSuccessView() {
        System.out.println("Your recipe is created successfully!");
    }

    @Override
    public void createFailureView() {
        System.out.println("The recipe's name is already existed.");
    }

    @Override
    public void readSuccessView(String result) {
        System.out.println("This is the recipe you are looking for.");
        System.out.println(result);
    }

    @Override
    public void readFailureView() {
        System.out.println("Sorry, the recipe doesn't exist.");
    }
}
