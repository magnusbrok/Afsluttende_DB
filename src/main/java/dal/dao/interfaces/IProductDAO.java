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

    List<IProductBatch> getExtractList(int commodityBatchID) throws IUserDAO.DALException;

    //Update
    void updateProduct(IProduct product) throws IUserDAO.DALException;

    void updatePBatch(IProductBatch productBatch) throws IUserDAO.DALException;


    //Delete
    void deleteProduct(int productID) throws IUserDAO.DALException;

    void deletePBatch(int productBatchID) throws IUserDAO.DALException;
}
