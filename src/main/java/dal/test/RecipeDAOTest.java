package dal.test;

import dal.dao.RecipeDAO;
import dal.dao.interfaces.IRecipeDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Ingredient;
import dal.dto.Recipe;
import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IRecipe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeDAOTest {
    IRecipeDAO recipeDAO = new RecipeDAO();

    @Test
    public void RecipeTest() {
        IRecipe testRecipe = new Recipe();
        testRecipe.setRecipeID(11);
        testRecipe.setTitle("UnitTEST");
        testRecipe.setProductID(1); // Value for productID chosen from "1TestData", so that the FK reference exists.
        testRecipe.setQuantity(500);

        Ingredient testIngredient = new Ingredient();
        testIngredient.setRecipeID(testRecipe.getRecipeID()); // Value refers to testRecipe above
        testIngredient.setCommodityID(1); // Value for CommodityID chosen from "1TestData", so that the FK reference exists.
        testIngredient.setQuantity(500);
        testIngredient.setDeviation(10);

        try {
            //Test of create- and get- Recipe
            recipeDAO.createRecipe(testRecipe,1);
            IRecipe receivedRecipe = recipeDAO.getRecipe(testRecipe.getRecipeID());
            assertEquals(testRecipe.getTitle(), receivedRecipe.getTitle());
            assertEquals(testRecipe.getProductID(), receivedRecipe.getProductID());
            assertEquals(testRecipe.getQuantity(), receivedRecipe.getQuantity());

            //Test of update Recipe
            testRecipe.setTitle("TestUnit");
            testRecipe.setProductID(1); //ProductID not changed (foreign key)
            testRecipe.setQuantity(1000);
            recipeDAO.updateRecipe(testRecipe);

            receivedRecipe = recipeDAO.getRecipe(testRecipe.getRecipeID());
            assertEquals(testRecipe.getTitle(), receivedRecipe.getTitle());
            assertEquals(testRecipe.getProductID(), receivedRecipe.getProductID());
            assertEquals(testRecipe.getQuantity(), receivedRecipe.getQuantity());

            //Test of createIngredient and getIngredientList
            recipeDAO.createIngredient(testIngredient);
            List<IIngredient> allIngredients = recipeDAO.getIngredientList(testRecipe);
            boolean found = false;
            for (IIngredient ingredient: allIngredients)
                if (ingredient.getRecipeID() == testIngredient.getRecipeID() && ingredient.getCommodityID() == testIngredient.getCommodityID()) {
                    assertEquals(ingredient.getQuantity(),testIngredient.getQuantity());
                    assertEquals(ingredient.getDeviation(), testIngredient.getDeviation());
                    found = true;
                }
            if(!found){fail();}

            //Test of delete Ingredient
            recipeDAO.deleteIngredient(testRecipe.getRecipeID(),testIngredient.getCommodityID());
            allIngredients = recipeDAO.getIngredientList(testRecipe);
            found = false;
            for (IIngredient ingredient: allIngredients)
                if (ingredient.getRecipeID() == testIngredient.getRecipeID() && ingredient.getCommodityID() == testIngredient.getCommodityID()) {
                    found = true;
                }
            if(found){fail();}

            //Test of delete Recipe
            recipeDAO.deleteRecipe(testRecipe.getRecipeID());
            assertEquals(0,recipeDAO.getRecipe(testRecipe.getRecipeID()).getRecipeID());
        }catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }
}