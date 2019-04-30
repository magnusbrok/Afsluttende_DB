package dal.dto.interfaces;

import java.util.List;

public interface IProductBatch {

    int getProductBatchID();

    void setProductBatchID(int productBatchID);

    IProduct getProduct();

    void setProductID(IProduct product);

    IRecipe getRecipe();

    void setRecipe(IRecipe recipe);

    String getStatusID();

    void setStatus(String status);

    int getQuantity();

    void setQuantity(int quantity);

    List<ICommodityBatch> getExtractList();

    void setExtractList(List<ICommodityBatch> extractList);

}
