package dal.dao;

import dal.dto.IUser;
import dal.dto.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO{
    private int u_ID;
    private String name;

    //connection
    String dbAdress = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/";
    String dbUser = "s185037";
    String dbPassWord = "7KZWv1fdgUsV6uSlvhLVb";
    private Connection createConnection() throws IUserDAO.DALException{
        try {

            return DriverManager.getConnection(dbAdress + dbUser + "?"
                    + "user=" + dbUser + "&password="+dbPassWord);
        } catch (SQLException e)    {
            throw new IUserDAO.DALException(e.getMessage());
        }
    }
    //Create
    public void createUser(User user){
        try(Connection c = createConnection()){
            //User insert
        PreparedStatement statement = c.prepareStatement("INSERT INTO User VALUES (?, ?)");
        statement.setInt(1,user.getUserID());
        statement.setString(2, user.getUserName());
        // Role insert
        PreparedStatement rolestatement = c.prepareStatement("INSERT INTO uRoles VALUES (?, ?)");
        rolestatement.setInt(1, user.getUserID());
        rolestatement.setString(2, String.valueOf(user.getRoles()));
        statement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (IUserDAO.DALException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void createUser(IUser user) throws DALException {

    }

    public void getUser(int u_ID) throws IUserDAO.DALException {
    try(Connection c = createConnection()){
        PreparedStatement statement = c.prepareStatement("SELECT * FROM User WHERE u_ID = ?");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public List<IUser> getUserList() throws DALException {
        return null;
    }

    @Override
    public void updateUser(IUser user) throws DALException {

    }

    @Override
    public void deleteUser(int userId) throws DALException {

    }
}
