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
    public void createProduct(IProduct product) {

    }

    @Override
    public void createPBatch(IProductBatch productBatch) {

    }

    @Override
    public void createExtract(IExtract extract) {

    }

    @Override
    public IProduct getProduct(int productID) {
        return null;
    }

    @Override
    public IProductBatch getPBatch(int productBatchID) {
        return null;
    }

    @Override
    public List<IProduct> getProductList() {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList() {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(IProduct product) {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(IRecipe recipe) {
        return null;
    }

    @Override
    public List<IProductBatch> getPBatchList(int statusID) {
        return null;
    }

    @Override
    public List<ICommodity> getExtractList(IProductBatch productBatch) {
        return null;
    }

    @Override
    public void updateProduct(IProduct product) {

    }

    @Override
    public void updatePBatch(IProductBatch productBatch) {

    }

    @Override
    public void updateExtract(IExtract extract) {

    }

    @Override
    public void deleteProduct(int productID) {

    }

    @Override
    public void deletePBatch(int productBatchID) {

    }
}
