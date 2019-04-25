package dal.dto;

public interface IProduct {

    int getProductID(IProduct product);

    void setProductID(int productID);

    String getProductName(IProduct product);

    void setProductName(String productName);

}
