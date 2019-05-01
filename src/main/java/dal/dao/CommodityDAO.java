package dal.dao;

import dal.dao.interfaces.ICommodityDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Commodity;
import dal.dto.CommodityBatch;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import dal.dto.interfaces.IProductBatch;

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
        try (Connection con = createConnection()){
            PreparedStatement create = con.prepareStatement("INSERT INTO Commodity (c_ID, name, active, reorder)VALUES (?, ?, ?, ?)");
            create.setInt(1, commodity.getCommodityID());
            create.setString(2, commodity.getCommodityName());
            create.setBoolean(3, commodity.isActive());
            create.setBoolean(4, commodity.isReorder());
            create.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException {
        try (Connection con = createConnection()){

            ICommodityBatch comm = new CommodityBatch();
            PreparedStatement create = con.prepareStatement("INSERT INTO cBatch VALUES (cb_ID = ?, manufacturer = ?, stock = ?, remainder = ?) ");

            create.setInt(1, comm.getCommodityBatchID());
            //create.setInt(2, comm.getCommodityID());
            create.setString(2, comm.getManufacturer());
            create.setInt(3, comm.getStock());
            create.setBoolean(4, comm.isRemainder());
            create.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ICommodity getCommodity(int commodityID) throws IUserDAO.DALException {
        try (Connection con = createConnection()){
            ICommodity commodity = new Commodity();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Commodity WHERE c_ID = ? ;");
            statement.setInt(1, commodityID);
            ResultSet commodityRS = statement.executeQuery();

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
        try (Connection con = createConnection()) {
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
        try (Connection con = createConnection()){
            List<ICommodity> commodityList = new ArrayList<>();
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
        try (Connection con = createConnection()) {
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
        try (Connection con = createConnection()){
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
        try (Connection con = createConnection()) {
            List<ICommodityBatch> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cBatch WHERE remainder = 1");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                list.add(getCBatch(resultSet.getInt("cBatch")));
            }
            return list;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }

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
        try (Connection con = createConnection()) {

            //check reorder?

            PreparedStatement ps = con.prepareStatement("UPDATE Commodity SET name = ?, active = ?, reorder = ? WHERE c_ID = ?");

            ps.setString(1,commodity.getCommodityName());
            ps.setBoolean(2, commodity.isActive());
            ps.setBoolean(3, commodity.isReorder());
            ps.setInt(4, commodity.getCommodityID());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void updateCBatch(ICommodityBatch commodityBatch) throws IUserDAO.DALException {
        try (Connection con = createConnection()) {

            //check remainder?

            PreparedStatement ps = con.prepareStatement("UPDATE cBatch set stock = ?, remainder = ? WHERE cb_ID = ?");

            ps.setInt(1, commodityBatch.getStock());
            ps.setBoolean(2, commodityBatch.isRemainder());
            ps.setInt(3, commodityBatch.getCommodityID());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void deleteCommodity(int commodityID) throws IUserDAO.DALException {
        try (Connection con = createConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Commodity WHERE c_ID = ?");
            ps.setInt(1,commodityID);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void deleteCBatch(int commodityBatchID) throws IUserDAO.DALException {

    }

    @Override  /*PROBLEM! da ingrediens mængde er angivet for én pille og ikke for en batch mængde...
    logik -> en opskrift definerer en standart batch størrelse og tilsvarrende ingrediensmængder? */
    public void checkRemainder(ICommodityBatch commodityBatch) throws IUserDAO.DALException {
        try (Connection con = createConnection()) {

            Statement statement = con.createStatement();
            ResultSet minQuantity = statement.executeQuery("SELECT MIN(quantity) FROM Ingredient NATURAL LEFT JOIN cBatch" +
                    "WHERE c_ID = " + commodityBatch.getCommodityID());

            if (commodityBatch.getStock() < minQuantity.getInt(1)){
                commodityBatch.setRemainder(true);
            }

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void checkReorder(ICommodity commodity) throws IUserDAO.DALException {
        try (Connection con = createConnection()) {

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(quantity) " +
                    "FROM Ingredient NATURAL RIGHT JOIN Commodity WHERE c_ID =" + commodity.getCommodityID());

            int maxQuantity = resultSet.getInt(1);
            int minRequired = 2;

            resultSet = statement.executeQuery("SELECT stock FROM cBatch " +
                    "WHERE c_ID = " + commodity.getCommodityID() + " ORDER BY stock DESC");

            int count = 0;
            while(resultSet.next()){
                if(resultSet.getInt(1) < maxQuantity){
                    count++;
                }
                if(count == minRequired){
                    break;
                }
            }
            if(count < minRequired){
                commodity.setReorder(true);
            }

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }
}
