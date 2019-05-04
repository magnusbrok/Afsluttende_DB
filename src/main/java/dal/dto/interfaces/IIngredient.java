package dal.dto.interfaces;

public interface IIngredient {

    int getRecipeID();
    void setRecipeID(int recipeID);

    int getCommodityID();
    void setCommodityID(int commodityID);

    float getQuantity();
    void setQuantity(float quantity);

    float getDeviation();
    void setDeviation(float deviation);
}
