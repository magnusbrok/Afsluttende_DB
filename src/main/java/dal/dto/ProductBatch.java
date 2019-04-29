package dal.dto;

import java.util.List;

public class ProductBatch implements IProductBatch {


    private int productBatchID;
    private IProduct product;
    private IRecipe recipe;
    private String status;
    private int quantity;
    private List<ICommodityBatch> extractList;

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
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {this.quantity = quantity;

    }

    @Override
    public List<ICommodityBatch> getExtractList(){return extractList;}

    @Override
    public void setExtractList(List<ICommodityBatch> extractList){this.extractList = extractList;}
}
