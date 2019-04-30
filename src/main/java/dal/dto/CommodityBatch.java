package dal.dto;


import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;

public class CommodityBatch implements ICommodityBatch {

    //TODO implement extractlist?

    private int commodityBatchID;
    private int commodityID;
    private String manufacturer;
    private int stock;
    private boolean remainder;

   // private List<IProductBatch> extractList; //?


    @Override
    public int getCommodityBatchID() {
        return commodityBatchID;
    }

    @Override
    public void setCommodityBatchID(int commodityBatchID) {
        this.commodityBatchID = commodityBatchID;
    }

    @Override
    public int getCommodityID() {
        return 0;
    }

    @Override
    public void setCommodity(int commodityID) {

    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean IsRemainder() {
        return remainder;
    }

    @Override
    public void setRemainder(boolean remainder) {
        this.remainder = remainder;

    }
}
