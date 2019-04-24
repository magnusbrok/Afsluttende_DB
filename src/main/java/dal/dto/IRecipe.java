package dal.dto;

import java.util.List;

public interface IRecipe {

    int getRecepiID();

    void setRecepiID(int recepiID);

    int getProductID();

    void setProductID(int productID);

    int getQuantity();

    void setQuantity(int quantity);

    int getDeviation();
    void setDeviation(int deviation);

    List<IIngredientDTO> getIngredientList();

    void setIngredientList(List<IIngredientDTO> ingredientList);

    void addIngredient(IIngredientDTO ingredient);

    void removeIngredient(IIngredientDTO ingredient);

}
