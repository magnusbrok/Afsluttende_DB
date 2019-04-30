package dal.dto.interfaces;

import java.util.List;

public interface IUser {

    int getUserID();

    void setUserID(int userID);

    String getUserName();

    void setUserName(String userName);

    List<String> getRoles();

    void setRoles(List<String> roles);

    void addRole(String role);

    boolean removeRole(String role);
}
