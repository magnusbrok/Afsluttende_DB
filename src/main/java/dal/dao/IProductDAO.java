package dal.dao;

import dal.dto.*;

import java.util.List;

public interface IProductDAO {

    //Create
    void createProduct(IProduct product) throws IUserDAO.DALException;
    void createPBatch(IProductBatch productBatch) throws IUserDAO.DALException;
    void createExtract(IExtract extract) throws IUserDAO.DALException; // kan være extract metoder skal ligge et andet sted? - siff

    //Reed
    IProduct getProduct(int productID)  throws IUserDAO.DALException;
    IProductBatch getPBatch(int productBatchID) throws IUserDAO.DALException;
    List<IProduct> getProductList() throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList() throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList(IProduct product) throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList(IRecipe recipe) throws IUserDAO.DALException;
    List<IProductBatch> getPBatchList(int statusID) throws IUserDAO.DALException;
    List<ICommodity> getExtractList(IProductBatch productBatch) throws IUserDAO.DALException; // kan være extract metoder skal ligge et andet sted? - siff

    //Update
    void updateProduct(IProduct product) throws IUserDAO.DALException;
    void updatePBatch(IProductBatch productBatch) throws IUserDAO.DALException;
    void updateExtract(IExtract extract) throws IUserDAO.DALException;

    //Delete - giver det egenligt mening at have disse delete metoder i forhold til logik og database desing? - siff
    void deleteProduct(int productID) throws IUserDAO.DALException;
    void deletePBatch(int productBatchID) throws IUserDAO.DALException;
}
