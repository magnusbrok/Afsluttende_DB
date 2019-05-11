package dal.dao;

import dal.dao.interfaces.IUserDAO;
import dal.dto.interfaces.IUser;
import dal.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    @Override
    public IUser getUser(int userID) throws DALException {
        try (Connection con = createConnection()){
            IUser user = new User();
            Statement userStatement = con.createStatement();
            ResultSet userRS = userStatement.executeQuery("SELECT * FROM User WHERE u_ID = " + userID + ";");
            if (userRS.next()) {
                user.setUserID(userRS.getInt("u_ID"));
                user.setUserName(userRS.getString("name"));
            }

            Statement roleStatement = con.createStatement();
            ResultSet roleRS = roleStatement.executeQuery("SELECT name, ro_ID FROM uRoles NATURAL LEFT JOIN Roles WHERE u_ID = " + userID + ";");
            while (roleRS.next()) {
                user.addRole(roleRS.getString("name"));
                user.addRoleID(roleRS.getInt("ro_ID"));
            }

            return user;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public List<IUser> getUserList() throws DALException {
        try (Connection con = createConnection()) {
            Statement stmt = con.createStatement();
            ResultSet userRS = stmt.executeQuery("SELECT * FROM User;");
            List<IUser> userList = new ArrayList<>();
            while (userRS.next()) {
                IUser user = getUser(userRS.getInt("u_ID"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void createUser(IUser user) throws DALException {
        try (Connection con = createConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO User (u_ID, name) " +
                    "VALUES (?, ?);");
            stmt.setInt(1,user.getUserID());
            stmt.setString(2,user.getUserName());
            stmt.executeUpdate();

            for (int i = 0; i < user.getRoleIDs().size(); i++) {
                stmt = con.prepareStatement("INSERT INTO uRoles (u_ID, ro_ID) " +
                        "VALUES (?, ?);");
                stmt.setInt(1, user.getUserID());
                stmt.setInt(2, user.getRoleIDs().get(i));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void updateUser(IUser user) throws DALException {
        try (Connection con = createConnection()){

            PreparedStatement stmt = con.prepareStatement("UPDATE User SET name = ? WHERE u_ID = ?");
            stmt.setString(1,user.getUserName());
            stmt.setInt(2,user.getUserID());
            stmt.executeUpdate();

            stmt = con.prepareStatement("DELETE FROM uRoles WHERE u_ID = ?");
            stmt.setInt(1,user.getUserID());
            stmt.executeUpdate();

            for (int i : user.getRoleIDs()) {
                stmt = con.prepareStatement("INSERT INTO uRoles (u_ID, ro_ID) " +
                        "VALUES (?, ?);");
                stmt.setInt(1, user.getUserID());
                stmt.setInt(2, i);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userID) throws DALException {
        try (Connection con = createConnection()) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM uRoles WHERE u_ID = ?;");
            stmt.setInt(1,userID);
            stmt.executeUpdate();

            stmt = con.prepareStatement("DELETE FROM User WHERE u_ID = ?;");
            stmt.setInt(1,userID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
}
