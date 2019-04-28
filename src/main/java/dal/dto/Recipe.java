package dal.dto;

import java.util.List;

public class Recipe implements IRecipe {

    //TODO implement titel and methods add/remove ingredient

    private int recipeID;
    private IProduct product;
    private String title;
    private List<IIngredient> ingredientList;

    @Override
    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public void setRecipeID(int recipeID) {this.recipeID = recipeID;

    }

    @Override
    public IProduct getProduct() {
        return product;
    }

    @Override
    public void setProduct(IProduct product) {this.product = product;

    }

    @Override
    public List<IIngredient> getIngredientList() {
        return ingredientList;
    }

    @Override
    public void setIngredientList(List<IIngredient> ingredientList) {this.ingredientList = ingredientList;

    }


    @Override
    public void addIngredient(IIngredient ingredient) {

    }

    @Override
    public void removeIngredient(IIngredient ingredient) {

    }
}
