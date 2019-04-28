package dal.dto;

public class Product implements IProduct {


    private int productID;
    private String productName;

    @Override
    public int getProductID(IProduct product) {
        return productID;
    }

    @Override
    public void setProductID(int productID) {this.productID = productID;

    }

    @Override
    public String getProductName(IProduct product) {
        return productName;
    }

    @Override
    public void setProductName(String productName) {this.productName = productName;

    }
}
