package dal.dao;

import dal.dto.ICommodity;
import dal.dto.ICommodityBatch;
import dal.dto.IProductBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CommodityDAO implements ICommodityDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    @Override
    public void createCommodity(ICommodity commodity) throws IUserDAO.DALException {

    }

    @Override
    public void createCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException {

    }

    @Override
    public ICommodity getCommodity(int commodityID) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public ICommodityBatch getCBatch(int commodityBatchID) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodity> getCommodityList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodity> getReorderList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList(ICommodity commodity) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodityBatch> getRemainderList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<IProductBatch> getExtractList(ICommodityBatch commodityBatch) throws IUserDAO.DALException {
        return null;
    }

    @Override
    public void updateCommodity(ICommodity commodity) throws IUserDAO.DALException {

    }

    @Override
    public void updtateCBatch(ICommodityBatch commodityBatchID) throws IUserDAO.DALException {

    }

    @Override
    public void deleteCommodity(int commodityID) throws IUserDAO.DALException {

    }

    @Override
    public void deleteCBatch(int commodityBatchID) throws IUserDAO.DALException {

    }

    @Override
    public void checkRemainder(int commodityBatchID) throws IUserDAO.DALException {

    }

    @Override
    public void checkReorder(int commodityID) throws IUserDAO.DALException {

    }
}
