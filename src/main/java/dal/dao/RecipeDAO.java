package dal.dao;

import dal.dao.interfaces.IRecipeDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.*;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.IIngredient;
import dal.dto.interfaces.IProduct;
import dal.dto.interfaces.IRecipe;


import java.sql.*;
import java.util.List;

public class RecipeDAO implements IRecipeDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    //CREATE
    @Override
    public void createRecipe(IRecipe recipe, IProduct product) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Recipe (re_ID, p_ID, title) " +
                    "VALUES (?, ?, ?);");
            stmt.setInt(1,recipe.getRecipeID());
            stmt.setInt(2,product.getProductID()); //Had to also take "IProduct product" as argument for method, in order to access product ID. - Tim //corrected - siff
            stmt.setString(3,recipe.getTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void createIngredient(IIngredient ingredient) throws IUserDAO.DALException {

    }

    /**

    @Override
    public void createIngredient(IIngredient ingredient, IRecipe recipe, ICommodity commodity) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Ingredient (re_ID, c_ID, quantity, deviation) " +
                    "VALUES (?, ?, ?, ?);");
            stmt.setInt(1,recipe.getRecipeID());
            stmt.setInt(2,commodity.getCommodityID());  //Had to take recipe and commodity as parameters aswell. In order to access c_ID and re_ID - Tim
            stmt.setInt(3,ingredient.getQuantity());
            stmt.setInt(4,ingredient.getDeviation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }
    **/


    //READ
    @Override
    public IRecipe getRecipe(int recipeID) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            IRecipe recipe = new Recipe();
            Statement Statement = con.createStatement();
            ResultSet rs = Statement.executeQuery("SELECT * FROM Recipe WHERE re_ID = " + recipeID + ";");
            if (rs.next()) {
                recipe.setRecipeID(rs.getInt("re_ID"));
                recipe.setProductID(rs.getInt("p_ID"));
                recipe.setTitle(rs.getString("title"));
            }
            return recipe;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }


    @Override
    public List<IIngredient> getIngredientList(IRecipe recipe) throws IUserDAO.DALException {
        return null;
    }


    //UPDATE
    @Override
    public void updateRecipe(IRecipe recipe) throws IUserDAO.DALException {

    }


    //DELETE + log recipe
    @Override
    public void deleteRecipe(int recipeID) throws IUserDAO.DALException {

    }

    @Override
    public void logRecipe(int recipeID) {

    }
}
