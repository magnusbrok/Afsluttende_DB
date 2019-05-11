package dal.dto.interfaces;

import java.util.List;

public interface IRecipe {

    int getRecipeID();

    void setRecipeID(int recipeID);

    int getProductID();

    void setProductID(int productID);

    int getQuantity();

    void setQuantity(int quantity);

    String getTitle();

    void setTitle(String title);

    List<IIngredient> getIngredientList();

    void setIngredientList(List<IIngredient> ingredientList);

    void addIngredient(IIngredient ingredient);

    void removeIngredient(IIngredient ingredient);

}
