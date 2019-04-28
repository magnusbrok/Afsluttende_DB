package dal.dto;

import java.util.List;

public class ProductBatch implements IProductBatch {

    //TODO implement extractlist

    int productBatchID;
    IProduct product;
    IRecipe recipe;
    String status;
    int quiantity;
    List<ICommodityBatch> extractList; //?

    @Override
    public int getProductBatchID() {
        return productBatchID;
    }

    @Override
    public void setProductBatchID(int productBatchID) {this.productBatchID = productBatchID;

    }

    @Override
    public IProduct getProduct() {
        return product;
    }

    @Override
    public void setProductID(IProduct product) {this.product = product;

    }

    @Override
    public IRecipe getRecipe() {
        return recipe;
    }

    @Override
    public void setRecipe(IRecipe recipe) {this.recipe = recipe;

    }

    @Override
    public String getStatusID() {
        return status;
    }

    @Override
    public void setStatus(String status) {this.status = status;

    }

    @Override
    public int getQuantity() {
        return quiantity;
    }

    @Override
    public void setQuantity(int quantity) {this.quiantity = quantity;

    }
}
