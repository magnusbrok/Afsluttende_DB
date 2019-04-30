package dal.dto;

import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IProduct;
import dal.dto.interfaces.IRecipe;

import java.util.List;

public class Recipe implements IRecipe {


    private int recipeID;
    private int productID;
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
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String getTitle(){return title;}

    @Override
    public void setTitle(String titel){this.title = title;}


    @Override
    public List<IIngredient> getIngredientList() {
        return ingredientList;
    }

    @Override
    public void setIngredientList(List<IIngredient> ingredientList) {this.ingredientList = ingredientList;

    }


    @Override
    public void addIngredient(IIngredient ingredient) {this.ingredientList.add(ingredient);

    }

    @Override
    public void removeIngredient(IIngredient ingredient) {this.ingredientList.remove(ingredient);

    }
}
