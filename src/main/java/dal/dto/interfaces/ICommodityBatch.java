package dal.dto.interfaces;

public interface ICommodityBatch {


    int getCommodityBatchID();
    void setCommodityBatchID(int commodityBatchID);

    int getCommodityID();
    void setCommodityID(int commodityID);

    String getManufacturer();
    void setManufacturer(String manufacturer);

    float getStock();
    void setStock(float stock);


    boolean isRemainder();

    void setRemainder(boolean remainder);

}
