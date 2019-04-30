package dal.dto.interfaces;

public interface IExtract {

    IProductBatch getProductBatch();
    void setProductBatch(IProductBatch productBatch);

    ICommodityBatch getCommodityBatch();
    void setCommodityBatch(ICommodityBatch commodityBatch);

    ICommodity getCommodity();
    void setCommodity(ICommodity commodity);

}
