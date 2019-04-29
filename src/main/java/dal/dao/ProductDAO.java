package dal.dao;

import dal.dto.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    @Override
    public void createProduct(IProduct product) throws IUserDAO.DALException {

    }

    @Override
    public void createPBatch(IProductBatch productBatch) throws IUserDAO.DALException {

    }

    @Override
    public void createExtract(IExtract extract) throws IUserDAO.DALException {

    }

    @Override
    public IProduct getProduct(int productID)throws IUserDAO.DALException {
        return null;
    }

    @Override
    public IProductBatch getPBatch(int productBatchID) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProduct> getProductList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(IProduct product) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(IRecipe recipe) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(int statusID) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodity> getExtractList(IProductBatch productBatch) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public void updateProduct(IProduct product) throws IUserDAO.DALException {

    }

    @Override
    public void updatePBatch(IProductBatch productBatch) throws IUserDAO.DALException {

    }

    @Override
    public void updateExtract(IExtract extract) throws IUserDAO.DALException {

    }

    @Override
    public void deleteProduct(int productID) throws IUserDAO.DALException {

    }

    @Override
    public void deletePBatch(int productBatchID) throws IUserDAO.DALException {

    }
}
