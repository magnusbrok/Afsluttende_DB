package dal.dto.interfaces;

public interface IIngredient {

    int getRecipeID();
    void setRecipeID(int recipeID);

    int getCommodityID();
    void setCommodityID(int commodityID);

    int getQuantity();
    void setQuantity(int quantity);

    int getDeviation();
    void setDeviation(int deviation);
}
