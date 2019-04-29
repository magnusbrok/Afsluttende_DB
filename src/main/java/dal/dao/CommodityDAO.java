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
    public void createCommodity(ICommodity commodity) {

    }

    @Override
    public void createCBatch(ICommodityBatch commodityBatch) {

    }

    @Override
    public ICommodity getCommodity(int commodityID) {
        return null;
    }

    @Override
    public ICommodityBatch getCBatch(int commodityBatchID) {
        return null;
    }

    @Override
    public List<ICommodity> getCommodityList() {
        return null;
    }

    @Override
    public List<ICommodity> getReorderList() {
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList() {
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList(ICommodity commodity) {
        return null;
    }

    @Override
    public List<ICommodityBatch> getRemainderList() {
        return null;
    }

    @Override
    public List<IProductBatch> getExtractList(ICommodityBatch commodityBatch) {
        return null;
    }

    @Override
    public void updateCommodity(ICommodity commodity) {

    }

    @Override
    public void updtateCBatch(ICommodityBatch commodityBatchID) {

    }

    @Override
    public void deleteCommodity(int commodityID) {

    }

    @Override
    public void deleteCBatch(int commodityBatchID) {

    }

    @Override
    public void checkRemainder(int commodityBatchID) {

    }

    @Override
    public void checkReorder(int commodityID) {

    }
}
