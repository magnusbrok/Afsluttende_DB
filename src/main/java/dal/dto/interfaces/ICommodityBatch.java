package dal.dto.interfaces;

import dal.dto.interfaces.ICommodity;

public interface ICommodityBatch {

    //døjer med nogle overvejelser omkring relevante attributter... - siff



    int getCommodityBatchID();
    void setCommodityBatchID(int commodityBatchID);

    ICommodity getCommodity();
    void setCommodity(ICommodity commodity);

    String getManufacturer();
    void setManufacturer(String manufacturer);

    int getStock();
    void setStock(int stock);


}
