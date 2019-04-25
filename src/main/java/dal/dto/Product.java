package dal.dto;

public class Product implements IProduct {

    //TODO implement class

    int productID;
    String productName;

    @Override
    public int getProductID(IProduct product) {
        return 0;
    }

    @Override
    public void setProductID(int productID) {

    }

    @Override
    public String getProductName(IProduct product) {
        return null;
    }

    @Override
    public void setProductName(String productName) {

    }
}
