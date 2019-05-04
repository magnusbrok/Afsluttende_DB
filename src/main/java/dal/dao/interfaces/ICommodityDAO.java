package dal.dao.interfaces;

import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import dal.dto.interfaces.IProductBatch;

import java.util.List;

public interface ICommodityDAO {

    //Create
    void createCommodity(ICommodity commodity) throws IUserDAO.DALException;
    void createCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException;
    void createExtract(int pb_ID, int cb_ID, float exstractSize) throws IUserDAO.DALException;

    //Read
    ICommodity getCommodity(int commodityID) throws IUserDAO.DALException;

    ICommodityBatch getCBatch(int commodityBatchID) throws IUserDAO.DALException;

    List<ICommodity> getCommodityList() throws IUserDAO.DALException;

    List<ICommodity> getReorderList() throws IUserDAO.DALException;

    List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException;

    List<ICommodityBatch> getCBatchList(int commodityID) throws IUserDAO.DALException;

    List<ICommodityBatch> getRemainderList() throws IUserDAO.DALException;

    List<ICommodityBatch> getExtractList(int productBatchID) throws IUserDAO.DALException; // kan være extract metoder skal ligge et andet sted? - siff

    //Update
    void updateCommodity(ICommodity commodity) throws IUserDAO.DALException;
    void updateCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException;

    //Delete skal ikke bruges, men det er nice de er der.
    void deleteCommodity(int commodityID) throws IUserDAO.DALException;
    void deleteCBatch(int commodityBatchID) throws IUserDAO.DALException;

    //Helping Methods - skal køres efter en update/delete metode
    void checkRemainder(ICommodityBatch commodityBatch) throws IUserDAO.DALException;

    void checkReorder(ICommodityBatch commodityBatch) throws IUserDAO.DALException;
}
