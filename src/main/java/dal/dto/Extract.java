package dal.dto;

public class Extract implements IExtract{


    private IProductBatch productBatch;
    private ICommodityBatch commodityBatch;
    private ICommodity commodity;

    @Override
    public IProductBatch getProductBatch() {
        return productBatch;
    }

    @Override
    public void setProductBatch(IProductBatch productBatch) {
        this.productBatch = productBatch;
    }

    @Override
    public ICommodityBatch getCommodityBatch() {
        return commodityBatch;
    }

    @Override
    public void setCommodityBatch(ICommodityBatch commodityBatch) {
        this.commodityBatch = commodityBatch;
    }

    @Override
    public ICommodity getCommodity() {
        return commodity;
    }

    @Override
    public void setCommodity(ICommodity commodity) {
        this.commodity = commodity;
    }
}


