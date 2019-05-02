package dal.dao;

import dal.dao.interfaces.IRecipeDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.*;
import dal.dto.interfaces.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO implements IRecipeDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    //CREATE
    @Override
    public void createRecipe(IRecipe recipe, int productID) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Recipe (re_ID, title, p_ID, quantity) " +
                    "VALUES (?, ?, ?, ?);");
            stmt.setInt(1,recipe.getRecipeID());
            stmt.setString(2,recipe.getTitle());
            stmt.setInt(3,productID);
            stmt.setInt(4,recipe.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void createIngredient(IIngredient ingredient) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Ingredient (re_ID, c_ID, quantity, deviation) " +
                    "VALUES (?, ?, ?, ?);");
            stmt.setInt(1,ingredient.getRecipeID());
            stmt.setInt(2,ingredient.getCommodityID());
            stmt.setInt(3,ingredient.getQuantity());
            stmt.setInt(4,ingredient.getDeviation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }


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
                recipe.setTitle(rs.getString("title"));
                recipe.setProductID(rs.getInt("p_ID"));
                recipe.setQuantity(rs.getInt("quantity"));
            }
            return recipe;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }


    @Override
    public List<IIngredient> getIngredientList(IRecipe recipe) throws IUserDAO.DALException {
        try {
            Connection con = createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ingredient WHERE r_ID = " + recipe.getRecipeID() + ";");
            List<IIngredient> ingredientList = new ArrayList<>();
            while (rs.next()) {
                IIngredient ingredient = new Ingredient();
                ingredient.setRecipeID(recipe.getRecipeID());
                ingredient.setCommodityID(rs.getInt("c_ID"));
                ingredient.setQuantity(rs.getInt("quantity"));
                ingredient.setDeviation(rs.getInt("deviation"));

                ingredientList.add(ingredient);
            }
            return ingredientList;
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    //UPDATE
    @Override
    public void updateRecipe(IRecipe recipe) throws IUserDAO.DALException {
        try (Connection con = createConnection()){

            PreparedStatement stmt = con.prepareStatement("UPDATE Recipe SET title = ?, p_ID = ?, quantity = ? WHERE re_ID = ?");
            stmt.setString(1,recipe.getTitle());
            stmt.setInt(2,recipe.getProductID());
            stmt.setInt(3,recipe.getQuantity());
            stmt.setInt(4,recipe.getRecipeID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }


    //DELETE + log recipe
    @Override
    public void deleteRecipe(int recipeID) throws IUserDAO.DALException {
        try (Connection con = createConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Recipe WHERE re_ID = ?");
            stmt.setInt(1,recipeID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }

    @Override
    public void logRecipe(int recipeID) {

    }
}
