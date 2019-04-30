package dal.dao.interfaces;

import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IProduct;
import dal.dto.interfaces.IRecipe;

import java.util.List;

public interface IRecipeDAO {

    //Create
    void createRecipe(IRecipe recipe, IProduct product)  throws IUserDAO.DALException;
    void createIngredient (IIngredient ingredient, IRecipe recipe, ICommodity commodity)  throws IUserDAO.DALException;

    //Read
    IRecipe getRecipe (int recipeID)  throws IUserDAO.DALException;

    List<IRecipe> getRecipeList()  throws IUserDAO.DALException;

    List<IRecipe> getRecipeList(int productID)  throws IUserDAO.DALException;

    List<IIngredient> getIngredientList(IRecipe recipe) throws IUserDAO.DALException; // skal det ikke være en liste af ingredienser? -MB, ups, det er rettet nu - Siff

    //Update
    void updateRecipe (IRecipe recipe) throws IUserDAO.DALException;

    //Delete + log recipe
    void deleteRecipe (int recipeID) throws IUserDAO.DALException;
        // er ved at undersøge database-design til log-historik - Siff
}
