package dal.dto;

import java.util.List;

public interface IRecipe {

    int getRecipeID();

    void setRecipeID(int recipeID);

    IProduct getProduct();

    void setProduct(IProduct product);

    List<IIngredient> getIngredientList();

    void setIngredientList(List<IIngredient> ingredientList);

    void addIngredient(IIngredient ingredient);

    void removeIngredient(IIngredient ingredient);

}
