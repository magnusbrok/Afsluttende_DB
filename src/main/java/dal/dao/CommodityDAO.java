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
            PreparedStatement comStatementP = con.prepareStatement("SELECT * FROM Commodity WHERE c_Id = ? ;");
            comStatementP.setInt(1, commodityID);
            ResultSet commodityRS = comStatementP.executeQuery();

            if (commodityRS.next()) {
                commodity.setCommodityID(commodityRS.getInt("c_ID"));
                commodity.setCommodityName(commodityRS.getString("name"));
                commodity.setActive(commodityRS.getBoolean("active"));
                commodity.setReorder(commodityRS.getBoolean("reorder"));
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
            PreparedStatement IComST = con.prepareStatement("SELECT * FROM cBatch WHERE cb_ID = ?;");
            IComST.setInt(1, commodityBatchID);
            ResultSet IComRS = IComST.executeQuery();

            if (IComRS.next()) {
                ICom.setCommodityBatchID(IComRS.getInt("c_ID"));
                ICom.setCommodityID(IComRS.getInt("c_ID"));
                ICom.setStock(IComRS.getInt("stock"));
                ICom.setRemainder(IComRS.getBoolean("remainder"));
            }
            return ICom;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
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
                commodityList.add(getCommodity(ListRS.getInt("c_Id")));

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
            PreparedStatement reList = con.prepareStatement("SELECT * FROM Commodity WHERE reorder = 1");
            ResultSet resultSet = reList.executeQuery();
            while (resultSet.next()) {
                ReorderList.add(getCommodity(resultSet.getInt("c_Id")));

            }
            return ReorderList;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }

    }

    @Override
    public List<ICommodityBatch> getCBatchList() throws IUserDAO.DALException {
        try{
            Connection con = createConnection();
            List<ICommodityBatch> cBList = new ArrayList<>();
            PreparedStatement cBst = con.prepareStatement("SELECT * FROM cBatch;");
            ResultSet cbRS = cBst.executeQuery();

            while (cbRS.next()) {
                cBList.add(getCBatch(cbRS.getInt("cBatch")));

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
    public List<ICommodityBatch> getExtractList(IProductBatch productBatch) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("SELECT cb_ID " +
                    "FROM pBatch NATURAL LEFT JOIN Extract NATURAL LEFT JOIN cBatch WHERE pb_ID = ?");

            statement.setInt(1,productBatch.getProductBatchID());
            ResultSet resultSet = statement.executeQuery();

            List<ICommodityBatch> commodityBatchList = new ArrayList<>();
            while (resultSet.next()) {
                ICommodityBatch commodityBatch = getCBatch(resultSet.getInt("cb_ID"));
                commodityBatchList.add(commodityBatch);
            }

            return commodityBatchList;

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
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
