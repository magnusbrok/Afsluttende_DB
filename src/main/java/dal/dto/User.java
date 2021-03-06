package dal.dto;

import dal.dto.interfaces.IUser;
import java.util.ArrayList;
import java.util.List;

public class User implements IUser {

    private int userID;
    private String userName;

    private List<Integer> roleIDs = new ArrayList<>();
    private List<String> roles = new ArrayList<>();

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public void addRole(String role) {
        this.roles.add(role);
    }

    @Override
    public boolean removeRole(String role) {
        return this.roles.remove(role);
    }
    @Override
    public List<Integer> getRoleIDs() {
        return roleIDs;
    }
    @Override
    public void setRoleIDs(List<Integer> roleIDs) {
        this.roleIDs = roleIDs;
    }
    @Override
    public void addRoleID(int roleID) {
        this.roleIDs.add(roleID);
    }

    @Override
    public void removeRoleID(int roleID) {
        this.roleIDs.remove(roleID);
    }
    @Override
    public String toString() {
        return "User [userID=" + userID + ", userName=" + userName + " roles=" + roles + "]";
    }

}
