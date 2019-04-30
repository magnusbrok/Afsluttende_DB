package dal.dto.interfaces;

import dal.dto.interfaces.ICommodity;

public interface ICommodityBatch {

    //døjer med nogle overvejelser omkring relevante attributter... - siff



    int getCommodityBatchID();
    void setCommodityBatchID(int commodityBatchID);

    int getCommodityID();
    void setCommodity(int commodityID);

    String getManufacturer();
    void setManufacturer(String manufacturer);

    int getStock();
    void setStock(int stock);


    boolean IsRemainder();

    void setRemainder(boolean remainder);

}
