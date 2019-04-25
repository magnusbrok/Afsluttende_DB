package dal.dao;

import dal.dto.*;

import java.util.List;

public interface ICommodityDAO {

    //Create
    void createCommodity(ICommodity commodity);
    void createCBatch(ICommodityBatch commodityBatch);

    //Reed
    ICommodity getCommodity(int commodityID);

    ICommodityBatch getCBatch(int commodityBatchID);

    List<ICommodity> getCommodityList();

    List<ICommodity> getReorderList();

    List<ICommodityBatch> getCBatchList();

    List<ICommodityBatch> getCBatchList(ICommodity commodity);

    List<ICommodityBatch> getRemainderList();

    List<IProductBatch> getExtractList(ICommodityBatch commodityBatch); // kan være extract metoder skal ligge et andet sted? - siff

    //Update
    void updateCommodity(ICommodity commodity);
    void updtateCBatch(ICommodityBatch commodityBatchID);

    //Delete - giver det egenligt mening at have disse delete metoder i forhold til logik og database desing? - siff
    void deleteCommodity(int commodityID);
    void deleteCBatch(int commodityBatchID);

    //Helping Methods - hører måske til under product DTO? - siff
    void checkRemainder(int commodityBatchID);
    void checkReorder(int commodityID);
}
