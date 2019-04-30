package dal.dto.interfaces;

public interface IIngredient {

    int getRecipeID();
    void setRecipe(int recipeID);

    int getCommodityID();
    void setCommodity(int commodityID);

    int getQuantity();
    void setQuantity(int quantity);

    int getDeviation();
    void setDeviation(int deviation);
}
