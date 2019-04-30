package dal.dto;

import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IRecipe;

public class Ingredient implements IIngredient {

    private IRecipe recipe;
    private ICommodity commodity;
    private int quantity;
    private int deviation;


    @Override
    public IRecipe getRecipe() {
        return recipe;
    }

    @Override
    public void setRecipe(IRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public ICommodity getCommodity(){return commodity;}

    @Override
    public void setCommodity(ICommodity commodity) {this.commodity = commodity;}

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
