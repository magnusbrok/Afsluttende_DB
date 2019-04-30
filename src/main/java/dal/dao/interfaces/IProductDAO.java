package dal.dao.interfaces;

import dal.dto.interfaces.*;

import java.util.List;

public interface IProductDAO {

    //Create
    void createProduct(IProduct product) throws IUserDAO.DALException;
    void createPBatch(IProductBatch productBatch) throws IUserDAO.DALException;

    //Reed
    IProduct getProduct(int productID)  throws IUserDAO.DALException;
    IProductBatch getPBatch(int productBatchID) throws IUserDAO.DALException;

    List<IProductBatch> getPBatchList() throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList(IProduct productID) throws IUserDAO.DALException;
//    List<IProductBatch> getPBatchList(IRecipe recipe) throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList(int statusID) throws IUserDAO.DALException;

    List<IProductBatch> getExtractList(ICommodityBatch commodityBatch) throws IUserDAO.DALException; // kan være extract metoder skal ligge et andet sted? - siff

    //Update
    void updateProduct(IProduct product) throws IUserDAO.DALException;
    void updatePBatch(IProductBatch productBatch) throws IUserDAO.DALException;


    //Delete
    void deleteProduct(int productID) throws IUserDAO.DALException;
    void deletePBatch(int productBatchID) throws IUserDAO.DALException;
}
