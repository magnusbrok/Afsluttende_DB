package dal.dto;

import dal.dto.interfaces.ICommodityBatch;
import dal.dto.interfaces.IProduct;
import dal.dto.interfaces.IProductBatch;
import dal.dto.interfaces.IRecipe;

import java.util.List;

public class ProductBatch implements IProductBatch {


    private int productBatchID;
    private int productID;
    private int recipeID;
    private int statusID;

    private List<ICommodityBatch> extractList;

    @Override
    public int getProductBatchID() {
        return productBatchID;
    }

    @Override
    public void setProductBatchID(int productBatchID) {this.productBatchID = productBatchID;

    }

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

    @Override
    public List<ICommodityBatch> getExtractList(){return extractList;}

    @Override
    public void setExtractList(List<ICommodityBatch> extractList){this.extractList = extractList;}
}
