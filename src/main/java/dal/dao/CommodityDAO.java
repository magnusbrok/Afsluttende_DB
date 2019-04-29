package dal.dao;

import com.mysql.cj.protocol.Resultset;
import dal.dto.*;

import java.sql.*;
import java.util.ArrayList;
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
        try {
            Connection con = createConnection();
            ICommodity commodity = new Commodity();
            Statement comStatement = con.createStatement();
            ResultSet commodityRS = comStatement.executeQuery("SELECT * FROM Commodity WHERE c_Id = " + commodityID + ";");
            if (commodityRS.next()) {
                commodity.setCommodityID(commodityRS.getInt("c_ID"));
                commodity.setCommodityName(commodityRS.getString("name"));
                commodity.setActive(false); //hvad skal der stå i parentesen?
                commodity.setReorder(false); //hvad skal der stå i parentesen?
            }
            return commodity;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }

    }

    @Override
    public ICommodityBatch getCBatch(int commodityBatchID) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            ICommodityBatch ICom = new CommodityBatch();
            Statement IComSt = con.createStatement();
            ResultSet IComRS = IComSt.executeQuery("SELECT * FROM cBatch WHERE cb_ID = " + commodityBatchID + ";");
        }

        catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ICommodity> getCommodityList() throws IUserDAO.DALException {
        try{
            Connection con = createConnection();
            List<ICommodity> commodityList = new ArrayList<>();
            Statement comList = con.createStatement();
            ResultSet ListRS = comList.executeQuery("SELECT * FROM Commodity;");

            while (ListRS.next()) {
                ICommodity commodity = new Commodity();
                commodity.setCommodityID(ListRS.getInt("c_ID"));
                commodity.setCommodityName(ListRS.getString("name"));
                commodity.setActive(true); //hvad skal der stå i parentesen?
                commodity.setReorder(true); //hvad skal der stå i parentesen?


                commodityList.add(commodity);
            }
            return commodityList;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public List<ICommodity> getReorderList() throws IUserDAO.DALException {
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException {
        try{
            Connection con = createConnection();
            List<ICommodityBatch> cBList = new ArrayList<>();
            Statement cBst = con.createStatement();
            ResultSet cbRS = cBst.executeQuery("SELECT * FROM cBatch;");

            while (cbRS.next()) {
                ICommodityBatch commodityBatch = new CommodityBatch();
                commodityBatch.setCommodityBatchID(cbRS.getInt("c_ID"));
                // commodityBatch.setCommodity(cbRS.get("name"));
                // commodityBatch.getManufacturer(cbRS.getString();
                // commodityBatch.getStock(cbRS.getInt());


                cBList.add(commodityBatch);
            }
            return cBList;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
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
