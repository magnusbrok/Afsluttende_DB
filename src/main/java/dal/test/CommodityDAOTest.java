package dal.test;

import dal.dao.CommodityDAO;
import dal.dao.interfaces.ICommodityDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Commodity;
import dal.dto.CommodityBatch;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



public class CommodityDAOTest {


    ICommodityDAO commodityDAO = new CommodityDAO();


    @Test
    public void commodityTest() {

        ICommodity test = new Commodity();
        test.setCommodityID(142);
        test.setCommodityName("Silica");
        test.setActive(true);
        test.setActive(true);


        try {
            //Create commodity
            commodityDAO.createCommodity(test);
            ICommodity recived = commodityDAO.getCommodity(test.getCommodityID());
            assertEquals(test.getCommodityID(),recived.getCommodityID());
            assertEquals(test.getCommodityName(),recived.getCommodityName());
            assertEquals(test.isActive(),recived.isActive());
            assertEquals(test.isReorder(),recived.isReorder());


            //Update commodity
            test.setCommodityName("Laktose");
            test.setActive(false);
            commodityDAO.updateCommodity(test);
            recived = commodityDAO.getCommodity(test.getCommodityID());
            assertEquals(test.getCommodityName(),recived.getCommodityName());
            assertEquals(test.isActive(),recived.isActive());

            //Get CommodityList


            //Delete commodity
             //commodityDAO.deleteCommodity(test.getCommodityID());
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }

    }


    @Test
    public void commodityBatchTest() throws IUserDAO.DALException {
        ICommodityBatch test = new CommodityBatch();

        test.setCommodityBatchID(221);
        test.setCommodityID(140);
        test.setManufacturer("PP");
        test.setStock(20);
        test.setRemainder(true);

        try {
            //Create commodityBatch
            commodityDAO.createCBatch(test);
            ICommodityBatch recived = commodityDAO.getCBatch(test.getCommodityBatchID());
            assertEquals(test.getCommodityBatchID(), recived.getCommodityBatchID());
            assertEquals(test.getCommodityID(),recived.getCommodityID());
            assertEquals(test.getManufacturer(),recived.getManufacturer());
            assertEquals(test.getStock(), recived.getStock());
            assertEquals(test.isRemainder(),recived.isRemainder());

            //Update commodityBatch
            test.setStock(6);
            commodityDAO.updateCBatch(test);
            recived = commodityDAO.getCBatch(test.getCommodityBatchID());
            assertEquals(test.getStock(),recived.getStock());

            //Delete commodityBatch
            commodityDAO.deleteCBatch(test.getCommodityBatchID());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }
}
