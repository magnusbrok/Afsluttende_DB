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
        IUser testUser = new User();
        testUser.setUserName("Magnus");
        testUser.setUserID(11);
        List <String> roles =  new ArrayList<>();
        List <Integer> roleIDs = new ArrayList<>();
        roles.add("Farmaceut");
        roles.add("Produktionsleder");
        roleIDs.add(1);
        roleIDs.add(2);
        testUser.setRoles(roles);
        testUser.setRoleIDs(roleIDs);

        try {
            // Create and Read tests
            userDAO.createUser(testUser);
            IUser receivedUser = userDAO.getUser(testUser.getUserID());
            assertEquals(testUser.getUserName(), receivedUser.getUserName());
            assertEquals(testUser.getRoles() , receivedUser.getRoles());
            assertEquals(testUser.getRoleIDs(), receivedUser.getRoleIDs());
            assertEquals(testUser.getRoles().size() , receivedUser.getRoles().size());
            assertEquals(testUser.getRoleIDs().size() , receivedUser.getRoleIDs().size());

            // Test af getUserList
            List<IUser> allUsers = userDAO.getUserList();
            boolean found = false;
            for (IUser user: allUsers) {
                if(user.getUserID() == testUser.getUserID()){
                    assertEquals(testUser.getUserName(),user.getUserName());
                    assertEquals(testUser.getRoles().get(0),user.getRoles().get(0));
                    assertEquals(testUser.getRoles().size(),user.getRoles().size());
                    found = true;
                }
            }
            if(!found){fail();}

            // Update and Delete test
            testUser.setUserName("Magnus2");
            roleIDs.add(3);
            roles.add("Laborant");
            userDAO.updateUser(testUser);

            receivedUser = userDAO.getUser(testUser.getUserID());
            assertEquals(testUser.getUserName(), receivedUser.getUserName());
            assertEquals(testUser.getRoles() , receivedUser.getRoles());
            assertEquals(testUser.getRoleIDs(), receivedUser.getRoleIDs());
            assertEquals(testUser.getRoles().size() , receivedUser.getRoles().size());
            assertEquals(testUser.getRoleIDs().size() , receivedUser.getRoleIDs().size());

            userDAO.deleteUser(testUser.getUserID());
            assertEquals(null, userDAO.getUser(testUser.getUserID()).getUserName());


        }catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }
}
