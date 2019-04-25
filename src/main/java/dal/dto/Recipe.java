package dal.dto;

import java.util.List;

public class Recipe implements IRecipe {

    //TODO implement class

    private int recipeID;
    private IProduct product;
    private String title;
    private List<IIngredient> ingredientList;

    @Override
    public int getRecipeID() {
        return 0;
    }

    @Override
    public void setRecipeID(int recipeID) {

    }

    @Override
    public IProduct getProduct() {
        return null;
    }

    @Override
    public void setProduct(IProduct product) {

    }

    @Override
    public List<IIngredient> getIngredientList() {
        return null;
    }

    @Override
    public void setIngredientList(List<IIngredient> ingredientList) {

    }

    @Override
    public void addIngredient(IIngredient ingredient) {

    }

    @Override
    public void removeIngredient(IIngredient ingredient) {

    }
}
