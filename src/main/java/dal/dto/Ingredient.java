package dal.dto;

import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IRecipe;

public class Ingredient implements IIngredient {

    private int recipeID;
    private int commodityID;
    private int quantity;
    private int deviation;


    @Override
    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public void setRecipe(int recipeID) {
        this.recipeID = recipeID;

    }

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodity(int commodityID) {
        this.commodityID = commodityID;

    }

    @Override
    public int getQuantity(){return quantity;}

    @Override
    public void setQuantity(int quantity){this.quantity = quantity;}


    @Override
    public int getDeviation() {
        return deviation;
    }

    @Override
    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }
}
