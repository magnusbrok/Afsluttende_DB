package dal.dto;

public class CommodityBatch implements ICommodityBatch {

    Commodity commodity = new Commodity();


    private int commodityBatchID;
    private String manufaturer;
    private int stock;


    @Override
    public int getCommodityID() {
        return commodity.getCommodityID();
    }

    @Override
    public int getCommodityBatchID() {
        return commodityBatchID;
    }

    @Override
    public void setCommodityBatchID(int commodityBatchID) {
        this.commodityBatchID = commodityBatchID;
    }


    @Override
    public String getManufacturer() {
        return manufaturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufaturer = manufacturer;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }
}
