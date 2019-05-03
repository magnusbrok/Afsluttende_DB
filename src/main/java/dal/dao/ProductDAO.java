package dal.dao;

import dal.dao.interfaces.IProductDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Product;
import dal.dto.ProductBatch;
import dal.dto.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  ProductDAO implements IProductDAO {


    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    @Override
    public void createProduct(IProduct product) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("INSERT INTO Product VALUES (?,?)");

            statement.setInt(1,product.getProductID());
            statement.setString(2,product.getProductName());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void createPBatch(IProductBatch productBatch) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("INSERT INTO pBatch VALUES (?,?,?,?)");

            statement.setInt(1,productBatch.getProductBatchID());
            statement.setInt(2,productBatch.getProductID());
            statement.setInt(3,productBatch.getRecipeID());
            statement.setInt(4,productBatch.getStatusID());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public IProduct getProduct(int productID)throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("SELECT * FROM Product WHERE p_ID = ?");
            statement.setInt(1,productID);
            ResultSet resultSet = statement.executeQuery();

            IProduct product = new Product();
            if (resultSet.next()){
                product.setProductID(resultSet.getInt("p_ID"));
                product.setProductName(resultSet.getString("name"));
            }

            return product;

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public IProductBatch getPBatch(int productBatchID) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("SELECT * FROM pBatch WHERE pb_ID = ?");
            statement.setInt(1,productBatchID);
            ResultSet resultSet = statement.executeQuery();

            IProductBatch productBatch = new ProductBatch();

            if(resultSet.next()){
                productBatch.setProductBatchID(resultSet.getInt("pb_ID"));
                productBatch.setProductID(resultSet.getInt("p_ID"));
                productBatch.setRecipeID(resultSet.getInt("re_ID"));
                productBatch.setStatusID(resultSet.getInt("s_ID"));
            }

            return productBatch;

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public List<IProductBatch> getPBatchList() throws IUserDAO.DALException {
        try (Connection c = createConnection()){
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pb_ID FROM pBatch");

            List<IProductBatch> productBatchList = new ArrayList<>();
            while (resultSet.next()) {
                IProductBatch productBatch = getPBatch(resultSet.getInt("pb_ID"));
                productBatchList.add(productBatch);
            }
            return productBatchList;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

//    @Override
//    public List<IProductBatch> getPBatchList(IProduct product) throws IUserDAO.DALException {
//        try (Connection c = createConnection()){
//
//            PreparedStatement statement = c.prepareStatement("SELECT pb_ID FROM pBatch WHERE p_ID = ?");
//            statement.setInt(1,product.getProductID());
//            ResultSet resultSet = statement.executeQuery();
//
//            List<IProductBatch> productBatchList = new ArrayList<>();
//            while (resultSet.next()) {
//                IProductBatch productBatch = getPBatch(resultSet.getInt("pb_ID"));
//                productBatchList.add(productBatch);
//            }
//            return productBatchList;
//
//        } catch (SQLException e) {
//            throw new IUserDAO.DALException(e.getMessage());
//        }
//    }

//    @Override
//    public List<IProductBatch> getPBatchList(IRecipe recipe) throws IUserDAO.DALException {
//        try (Connection c = createConnection()){
//
//        } catch (SQLException e) {
//            throw new IUserDAO.DALException(e.getMessage());
//        }
//        return null;
//    }

//    @Override
//    public List<IProductBatch> getPBatchList(int statusID) throws IUserDAO.DALException {
//        try (Connection c = createConnection()){
//
//            PreparedStatement statement = c.prepareStatement("SELECT pb_ID FROM pBatch WHERE s_ID = ?");
//            statement.setInt(1,statusID);
//            ResultSet resultSet = statement.executeQuery();
//
//            List<IProductBatch> productBatchList = new ArrayList<>();
//            while (resultSet.next()) {
//                IProductBatch productBatch = getPBatch(resultSet.getInt("pb_ID"));
//                productBatchList.add(productBatch);
//            }
//
//            return productBatchList;
//
//        } catch (SQLException e) {
//            throw new IUserDAO.DALException(e.getMessage());
//        }
//    }

    @Override
    public List<IProductBatch> getExtractList(int commodityBatchID) throws IUserDAO.DALException {
        try(Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("SELECT pb_ID " +
                    "FROM pBatch NATURAL LEFT JOIN Extract NATURAL LEFT JOIN cBatch WHERE cb_ID = ?;");

            statement.setInt(1,commodityBatchID);
            ResultSet resultSet = statement.executeQuery();

            List<IProductBatch> productBatchList = new ArrayList<>();
            while (resultSet.next()) {
                IProductBatch productBatch = getPBatch(resultSet.getInt("pb_ID"));
                productBatchList.add(productBatch);
            }

            return productBatchList;

        }catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void updateProduct(IProduct product) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("UPDATE Product set name = ? WHERE p_ID = ?");

            statement.setString(1,product.getProductName());
            statement.setInt(2,product.getProductID());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }

    }

    @Override
    public void updatePBatch(IProductBatch productBatch) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("UPDATE pBatch" +
                    " set p_ID = ?, re_ID = ?, s_ID = ? WHERE pb_ID = ?");

            statement.setInt(1,productBatch.getProductID());
            statement.setInt(2,productBatch.getRecipeID());
            statement.setInt(3,productBatch.getStatusID());
            statement.setInt(4,productBatch.getProductBatchID());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void deleteProduct(int productID) throws IUserDAO.DALException {
        try (Connection c = createConnection()){

            PreparedStatement statement = c.prepareStatement("DELETE FROM Product Where p_ID = ?");

            statement.setInt(1,productID);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void deletePBatch(int productBatchID) throws IUserDAO.DALException {
        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("DELETE FROM pBatch Where pb_ID = ?");

            statement.setInt(1,productBatchID);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }
}
