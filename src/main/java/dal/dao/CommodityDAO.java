package dal.dao;

import dal.dao.interfaces.ICommodityDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.*;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import dal.dto.interfaces.IProductBatch;

import javax.swing.*;
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
        try {
            Connection con = createConnection();
            ICommodity comm = new Commodity();
            PreparedStatement create = con.prepareStatement("INSERT INTO Commodity VALUES (?, ?, ?, ?)");
            create.setInt(1,commodity.getCommodityID());
            create.setString(2, commodity.getCommodityName());
            create.setBoolean(3, commodity.isActive());
            create.setBoolean(4, commodity.isReorder());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            ICommodityBatch comm = new CommodityBatch();
            PreparedStatement create = con.prepareStatement("INSERT INTO cBatch VALUES (?, ?, ?, ?, ?) ");
            create.setInt(1, comm.getCommodityBatchID());
            create.setInt(2, comm.getCommodityID());
            create.setString(3, comm.getManufacturer());
            create.setInt(4, comm.getStock());
            create.setBoolean(5, comm.isRemainder());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ICommodity getCommodity(int commodityID) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            ICommodity commodity = new Commodity();
            //Statement comStatement = con.createStatement();
            PreparedStatement comStatementP = con.prepareStatement("SELECT * FROM Commodity WHERE c_Id = \" + commodityID + \";");
            ResultSet commodityRS = comStatementP.executeQuery();
            //ResultSet commodityRS = comStatement.executeQuery("SELECT * FROM Commodity WHERE c_Id = " + commodityID + ";");
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
            //Statement IComSt = con.createStatement();
            //ResultSet IComRS = IComSt.executeQuery("SELECT * FROM cBatch WHERE cb_ID = " + commodityBatchID + ";");
            PreparedStatement IComST = con.prepareStatement("SELECT * FROM cBatch WHERE cb_ID = \" + commodityBatchID + \";");
            ResultSet IComRS = IComST.executeQuery();
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
            //Statement comList = con.createStatement();
            //ResultSet ListRS = comList.executeQuery("SELECT * FROM Commodity;");
            PreparedStatement comList = con.prepareStatement("SELECT * FROM Commodity;");
            ResultSet ListRS = comList.executeQuery();

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
        try {
            Connection con = createConnection();
            List<ICommodity> ReorderList = new ArrayList<>();
            PreparedStatement reList = con.prepareStatement("SELECT * FROM Commodity WHERE reorder = ")

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException {
        try{
            Connection con = createConnection();
            List<ICommodityBatch> cBList = new ArrayList<>();
            //Statement cBst = con.createStatement();
            //ResultSet cbRS = cBst.executeQuery("SELECT * FROM cBatch;");
            PreparedStatement cBst = con.prepareStatement("SELECT * FROM cBatch;");
            ResultSet cbRS = cBst.executeQuery();

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
    public List<ICommodityBatch> getCBatchList(int commodityID) throws IUserDAO.DALException {
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
    public void updateCBatch(ICommodityBatch commodityBatchID) throws IUserDAO.DALException {

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
