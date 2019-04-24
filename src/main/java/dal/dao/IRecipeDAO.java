package dal.dao;

import dal.dto.*;

import java.util.List;

public interface IRecipeDAO {

    //Create
    void createRecipe(IRecipe recipe);
    void createIngredient (IIngredientDTO ingredient);

    //Reed
    IRecipe getRecipe (int recipeID);

    List<IRecipe> getRecipeList();

    List<IRecipe> getRecipeList(int productID);

    List<IRecipe> getIngredientList(IRecipe recipe); // skal det ikke være en liste af ingredienser? -MB

    //Update
    void updateRecipe (IRecipe recipe);

    //Delete + log recipe
    void deleteRecipe (int recipeID);

}
