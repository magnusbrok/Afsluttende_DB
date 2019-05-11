package dal.dto;

import dal.dto.interfaces.IProductBatch;

public class ProductBatch implements IProductBatch {


    private int productBatchID;
    private int productID;
    private int recipeID;
    private int statusID;

    @Override
    public int getProductBatchID() {
        return productBatchID;
    }

    @Override
    public void setProductBatchID(int productBatchID) {this.productBatchID = productBatchID;}

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public int getRecipeID() {
        return recipeID;
    }

    @Override
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    @Override
    public int getStatusID() {
        return statusID;
    }

    @Override
    public void setStatusID(int statusID) {
        this.statusID = statusID;

    }
}
