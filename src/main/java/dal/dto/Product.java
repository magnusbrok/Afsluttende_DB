package dal.dto;

public class Product implements IProduct {


    private int productID;
    private String productName;

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public void setProductID(int productID) {this.productID = productID;

    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {this.productName = productName;

    }
}
