package dal.dto;
import dal.dto.interfaces.IIngredient;

public class Ingredient implements IIngredient {

    private int recipeID;
    private int commodityID;
    private float quantity;
    private float deviation;

    @Override
    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    @Override
    public int getCommodityID() {
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    @Override
    public float getQuantity(){return quantity;}

    @Override
    public void setQuantity(float quantity){this.quantity = quantity;}


    @Override
    public float getDeviation() {
        return deviation;
    }

    @Override
    public void setDeviation(float deviation) {
        this.deviation = deviation;
    }
}
