package dal.dao;

import dal.dto.*;

import java.util.List;

public interface IRecipeDAO {

    //Create
    void createRecipe(IRecipe recipe);
    void createIngredient (IIngredient ingredient);

    //Reed
    IRecipe getRecipe (int recipeID);

    List<IRecipe> getRecipeList();

    List<IRecipe> getRecipeList(int productID);

    List<IIngredient> getIngredientList(IRecipe recipe); // skal det ikke være en liste af ingredienser? -MB, ups, det er rettet nu - Siff

    //Update
    void updateRecipe (IRecipe recipe);

    //Delete + log recipe
    void deleteRecipe (int recipeID);
        // er ved at undersøge database-design til log-historik - Siff
}
