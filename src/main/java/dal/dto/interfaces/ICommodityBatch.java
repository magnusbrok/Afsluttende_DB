package dal.dto.interfaces;

public interface ICommodityBatch {

    //døjer med nogle overvejelser omkring relevante attributter... - siff



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
