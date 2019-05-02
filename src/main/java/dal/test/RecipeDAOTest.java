package dal.test;

import dal.dao.RecipeDAO;
import dal.dao.interfaces.IRecipeDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Recipe;
import dal.dto.interfaces.IRecipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RecipeDAOTest {
    IRecipeDAO recipeDAO = new RecipeDAO();

    @Test
    public void RecipeTest() {
        Recipe testRecipe = new Recipe();
        testRecipe.setRecipeID(11);
        testRecipe.setTitle("UnitTEST");
        testRecipe.setProductID(1);
        testRecipe.setQuantity(500);

        try {
            recipeDAO.createRecipe(testRecipe,1);
            IRecipe receivedRecipe = recipeDAO.getRecipe(testRecipe.getRecipeID());
            assertEquals(testRecipe.getTitle(), receivedRecipe.getTitle());
            assertEquals(testRecipe.getProductID(), receivedRecipe.getProductID());
            assertEquals(testRecipe.getQuantity(), receivedRecipe.getQuantity());
            recipeDAO.deleteRecipe(11);
        }catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }
}
