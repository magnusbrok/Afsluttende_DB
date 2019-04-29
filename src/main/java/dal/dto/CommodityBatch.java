package dal.dto;

// import java.util.List;

public class CommodityBatch implements ICommodityBatch {

    //TODO implement extractlist?

    private int commodityBatchID;
    private ICommodity commodity;
    private String manufacturer;
    private int stock;
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
    public ICommodity getCommodity() {
        return commodity;
    }

    @Override
    public void setCommodity(ICommodity commodity) {
        this.commodity = commodity;
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
}
