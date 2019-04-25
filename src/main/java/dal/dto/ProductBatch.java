package dal.dto;

public class ProductBatch implements IProductBatch {

    int productBatchID;
    IProduct product;
    IRecipe recipe;
    String status;
    int quiantity;

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
    public int getQuiantity() {
        return 0;
    }

    @Override
    public void setQuiantity(int quantity) {

    }
}
