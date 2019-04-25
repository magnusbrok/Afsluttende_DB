package dal.dto;

public interface ICommodityBatch {

    //døjer med nogle overvejelser omkring relevante attributter... - siff



    int getCommodityBatchID();
    void setCommodityBatchID(int commodityBatchID);

    int getCommodityID();

    String getManufacturer();
    void setManufacturer(String manufacturer);

    int getStock();
    void setStock(int stock);


}
