package dal.dao;

import dal.dto.*;

import java.util.List;

public interface ICommodityDAO {

    //Create
    void createCommodity(ICommodity commodity) throws IUserDAO.DALException;
    void createCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException;

    //Read
    ICommodity getCommodity(int commodityID) throws IUserDAO.DALException;

    ICommodityBatch getCBatch(int commodityBatchID) throws IUserDAO.DALException;

    List<ICommodity> getCommodityList() throws IUserDAO.DALException;

    List<ICommodity> getReorderList() throws IUserDAO.DALException;

    List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException;

    List<ICommodityBatch> getCBatchList(ICommodity commodity) throws IUserDAO.DALException;

    List<ICommodityBatch> getRemainderList() throws IUserDAO.DALException;

    List<IProductBatch> getExtractList(ICommodityBatch commodityBatch) throws IUserDAO.DALException; // kan være extract metoder skal ligge et andet sted? - siff

    //Update
    void updateCommodity(ICommodity commodity) throws IUserDAO.DALException;
    void updtateCBatch(ICommodityBatch commodityBatchID) throws IUserDAO.DALException;

    //Delete - giver det egenligt mening at have disse delete metoder i forhold til logik og database desing? - siff
    void deleteCommodity(int commodityID) throws IUserDAO.DALException;
    void deleteCBatch(int commodityBatchID) throws IUserDAO.DALException;

    //Helping Methods - hører måske til under product DTO? - siff
    void checkRemainder(int commodityBatchID) throws IUserDAO.DALException;
    void checkReorder(int commodityID) throws IUserDAO.DALException;
}
