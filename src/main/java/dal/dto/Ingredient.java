package dal.dto;

public class Ingredient implements IIngredient {

    IRecipe recipe;
    ICommodity commodity;
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
