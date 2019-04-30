package dal.dto.interfaces;

public interface IIngredient {

    IRecipe getRecipe();
    void setRecipe(IRecipe recipe);

    ICommodity getCommodity();
    void setCommodity(ICommodity commodity);

    int getQuantity();
    void setQuantity(int quantity);

    int getDeviation();
    void setDeviation(int deviation);
}
