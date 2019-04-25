package dal.dto;

public class Ingredient implements IIngredient {

    //TODO implement class when interface is done

    private IRecipe recipe;
    private ICommodity commodity;
    private int quantity;
    private int deviation;


    @Override
    public int getDeviation() {
        return deviation;
    }

    @Override
    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }
}
