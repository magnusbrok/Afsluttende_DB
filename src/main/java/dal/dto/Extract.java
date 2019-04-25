package dal.dto;

public class Extract implements IExtract{


    ProductBatch pb = new ProductBatch();
    CommodityBatch cb = new CommodityBatch();
    Commodity commodity = new Commodity();


    @Override
    public int getCommodityID() {
        return commodity.getCommodityID();
    }

    @Override
    public int getCommodityBatchID() {
        return cb.getCommodityBatchID();
    }


    @Override
    public int getProductBatchID() {
        return pb.getProductBatchID();
    }
}


