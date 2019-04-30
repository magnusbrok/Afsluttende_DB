package dal.dao;

import dal.dao.interfaces.IUserDAO;
import dal.dto.interfaces.IUser;
import dal.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

//    String dbAdress = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/";
//    String dbUser = "s185037";
//    String dbPassWord = "7KZWv1fdgUsV6uSlvhLVb";
//    private Connection createConnection() throws IUserDAO.DALException{
//        try {
//
//            return DriverManager.getConnection(dbAdress + dbUser + "?"
//                    + "user=" + dbUser + "&password="+dbPassWord);
//        } catch (SQLException e)    {
//            throw new IUserDAO.DALException(e.getMessage());
//        }
//    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s173998?"
                + "user=s173998&password=qRibfryD9hC7hNICVopba");
    }

    @Override
    public IUser getUser(int userID) throws DALException {
        try {
            Connection con = createConnection();
            IUser user = new User();
            Statement userStatement = con.createStatement();
            ResultSet userRS = userStatement.executeQuery("SELECT * FROM User WHERE u_ID = " + userID + ";");
            if (userRS.next()) {
                user.setUserID(userRS.getInt("u_ID"));
                user.setUserName(userRS.getString("name"));
            }

            Statement roleStatement = con.createStatement();
            ResultSet roleRS = roleStatement.executeQuery("SELECT name FROM uRoles NATURAL LEFT JOIN Roles WHERE u_ID = " + userID + ";");
            while (roleRS.next()) {
                user.addRole(roleRS.getString("name"));
            }

            return user;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public List<IUser> getUserList() throws DALException {
        try {
            Connection con = createConnection();
            Statement stmt = con.createStatement();
            ResultSet userRS = stmt.executeQuery("SELECT * FROM User;");
            List<IUser> userList = new ArrayList<>();
            while (userRS.next()) {
                IUser user = new User();
                user.setUserID(userRS.getInt("u_ID"));
                user.setUserName(userRS.getString("name"));

                Statement roleStatement = con.createStatement();
                ResultSet roleRS = roleStatement.executeQuery("SELECT name FROM uRoles NATURAL LEFT JOIN Roles " +
                        "WHERE u_ID = " + userRS.getInt("u_ID") + ";");
                while (roleRS.next()) {
                    user.addRole(roleRS.getString("name"));
                }
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void createUser(IUser user) throws DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO User (u_ID, name) " +
                    "VALUES (?, ?);");
            stmt.setInt(1,user.getUserID());
            stmt.setString(2,user.getUserName());
            stmt.executeUpdate();

            for (String role: user.getRoles()) {
                insertRole(user, role);
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void updateUser(IUser user) throws DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE User SET name = ? WHERE userID = ?");
            stmt.setString(1,user.getUserName());
            stmt.setInt(2,user.getUserID());
            stmt.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT * FROM uRoles WHERE u_ID =" + user.getUserID() + ";");
            while (rs.next()) {
                Statement deepStatement = con.createStatement();
                int roleID = rs.getInt("ro_ID");
                deepStatement.executeUpdate("DELETE FROM Roles WHERE ro_ID = " + roleID + ";");
            }

            for (String role: user.getRoles()) {
                insertRole(user, role);
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userID) throws DALException {
        try {
            Connection con = createConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM uRoles WHERE u_ID =" + userID + ";");
            while (rs.next()) {
                Statement deepStatement = con.createStatement();
                deepStatement.executeUpdate("DELETE FROM Roles WHERE ro_ID = " + rs.getInt("ro_ID") + ";");
            }

            stmt.executeUpdate("DELETE FROM User WHERE u_ID = " + userID + ";");
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    private void insertRole(IUser user, String role) throws DALException {
        try {
            Connection con = createConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Roles (name) " +
                    "VALUES (?);");
            stmt.setString(1,role);
            stmt.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT ro_ID FROM Roles WHERE name =" + role + ";");
            int roleID = rs.getInt("ro_ID");
            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO uRoles (u_ID, ro_ID) " +
                    "VALUES (?, ?);");
            stmt2.setInt(1,user.getUserID());
            stmt2.setInt(2,roleID);
            stmt2.executeUpdate();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
}
