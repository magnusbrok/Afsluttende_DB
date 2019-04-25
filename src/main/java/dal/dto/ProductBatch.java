package dal.dto;

import java.util.List;

public class ProductBatch implements IProductBatch {

    //TODO implement class

    int productBatchID;
    IProduct product;
    IRecipe recipe;
    String status;
    int quiantity;
    List<ICommodityBatch> extractList; //?

    @Override
    public int getProductBatchID() {
        return 0;
    }

    @Override
    public void setProductBatchID(int productBatchID) {

    }

    @Override
    public IProduct getProduct() {
        return null;
    }

    @Override
    public void setProductID(IProduct product) {

    }

    @Override
    public IRecipe getRecipe() {
        return null;
    }

    @Override
    public void setRecipe(IRecipe recipe) {

    }

    @Override
    public String getStatusID() {
        return null;
    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public void setQuantity(int quantity) {

    }
}
