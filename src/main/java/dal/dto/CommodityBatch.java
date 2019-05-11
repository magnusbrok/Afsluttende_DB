package dal.dto;

import dal.dto.interfaces.ICommodityBatch;

public class CommodityBatch implements ICommodityBatch {

    private int commodityBatchID;
    private int commodityID;
    private String manufacturer;
    private float stock;
    private boolean remainder;

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
        return commodityID;
    }

    @Override
    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
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
    public float getStock() {
        return stock;
    }

    @Override
    public void setStock(float stock) {
        this.stock = stock;
    }

    @Override
    public boolean isRemainder() {
        return remainder;
    }

    @Override
    public void setRemainder(boolean remainder) {
        this.remainder = remainder;

    }
}
