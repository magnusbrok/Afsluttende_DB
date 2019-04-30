package dal.dto.interfaces;

import java.util.List;

public interface IProductBatch {

    int getProductBatchID();

    void setProductBatchID(int productBatchID);

    int getProductID();

    void setProductID(int productID);

    int getRecipeID();

    void setRecipeID(int recipeID);

    int getStatusID();

    void setStatusID(int statusID);

    int getQuantity();

    void setQuantity(int quantity);

    List<ICommodityBatch> getExtractList();

    void setExtractList(List<ICommodityBatch> extractList);

}
