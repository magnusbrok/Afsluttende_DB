package dal.dao;

import dal.dto.IIngredient;
import dal.dto.IRecipe;
import dal.dto.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO implements IRecipeDAO{

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    //CREATE
    @Override
    public void createRecipe(IRecipe recipe) {

    }

    @Override
    public void createIngredient(IIngredient ingredient) {

    }


    //READ
    @Override
    public IRecipe getRecipe(int recipeID) {
        return null;
    }

    @Override
    public List<IRecipe> getRecipeList() {
        return null;
    }

    @Override
    public List<IRecipe> getRecipeList(int productID) {
        return null;
    }

    @Override
    public List<IIngredient> getIngredientList(IRecipe recipe) {
        return null;
    }


    //UPDATE
    @Override
    public void updateRecipe(IRecipe recipe) {

    }


    //DELETE + log recipe
    @Override
    public void deleteRecipe(int recipeID) {

    }
}
