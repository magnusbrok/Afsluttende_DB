package dal.dto;

import java.util.List;

public class User implements IUser{

    private int	userId;
    private String userName;
    private List<String> roles;

    @Override
    public int getUserID() {
        return userId;
    }

    @Override
    public void setUserID(int userID) {
        this.userId = userID;
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
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + " roles=" + roles + "]";
    }

}
