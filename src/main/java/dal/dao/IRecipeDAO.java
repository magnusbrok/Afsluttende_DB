package dal.dao;

import dal.dto.IRecipe;

import java.util.List;

public interface IRecipeDAO {

    //Create
    void createRecipe(IRecipe recipe);
    void createIngredient (IIngredient ingredient);

    //Reed
    IRecipe getRecipe (int recipeID);
    List<IRecipe> getRecipeList();
    List<IRecipe> getRecipeList(int productID);
    List<IRecipe> getIngredientList(IRecipe recipe);

    //Update
    void updateRecipe (IRecipe recipe);

    //Delete
    void deleteRecipe (int recipeID);

}
