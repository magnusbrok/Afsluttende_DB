package dal.test;

import dal.dao.UserDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.User;
import dal.dto.interfaces.IUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserDAOTest {
        IUserDAO userDAO = new UserDAO();


    @Test
    public void UserTest() {
        IUser testuser = new User();
        testuser.setUserName("Magnus");
        testuser.setUserID(11);
        List <String> roles =  new ArrayList<>();
        roles.add("Produktionsleder");
        roles.add("Administrator");
        testuser.setRoles(roles);

        try {
        userDAO.createUser(testuser);
        IUser receivedUser = userDAO.getUser(11);
        assertEquals(testuser.getUserName(), receivedUser.getUserName());
        assertEquals(testuser.getRoles() , receivedUser.getRoles());
        assertEquals(testuser.getRoles().size() , receivedUser.getRoles().size());
        userDAO.deleteUser(11);



        }catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }




    }

    @Test
    void RecipeTest() {

    }



}
