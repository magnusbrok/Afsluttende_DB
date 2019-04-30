package dal;

import dal.dao.*;
import dal.dao.interfaces.IUserDAO;
import dal.dto.*;
import dal.dto.interfaces.ICommodity;

public class Main {
    public static void main(String[] args) {
        CommodityDAO DAO = new CommodityDAO();
        Commodity testDTO = new Commodity();

        testDTO.setCommodityID(5);
        testDTO.setActive(true);
        testDTO.setCommodityName("apple");
        testDTO.setReorder(false);

        try {
            //DAO.createCommodity(testDTO);
            ICommodity recieved = new Commodity();
            recieved = DAO.getCommodity(17);
            System.out.println(testDTO.getCommodityName());
            System.out.println(recieved.getCommodityName());


        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
        }
    }
}
