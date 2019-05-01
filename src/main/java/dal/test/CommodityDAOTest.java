package dal.test;

import dal.dao.CommodityDAO;
import dal.dao.interfaces.ICommodityDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Commodity;
import dal.dto.CommodityBatch;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



public class CommodityDAOTest {


    ICommodityDAO commodityDAO = new CommodityDAO();

    @Test
    public void commodityTest() {
        ICommodity test = new Commodity();
        test.setCommodityID(7);
        test.setCommodityName("Laktose");
        test.setActive(true);
        test.setActive(true);

        try {
            commodityDAO.createCommodity(test);
            ICommodity recived = commodityDAO.getCommodity(7);
            assertEquals(test.getCommodityID(),recived.getCommodityID());
            assertEquals(test.getCommodityName(),recived.getCommodityName());
            assertEquals(test.isActive(),recived.isActive());
            assertEquals(test.isReorder(),recived.isReorder());

            test.setCommodityName("Silica");
            test.setActive(false);
            commodityDAO.updateCommodity(test);
            recived = commodityDAO.getCommodity(7);
            assertEquals(test.getCommodityName(),recived.getCommodityName());
            assertEquals(test.isActive(),recived.isActive());

            commodityDAO.deleteCommodity(test.getCommodityID());
        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }


    }
/*
    @Test
    public void commodityBatchTest() throws IUserDAO.DALException {
        ICommodityBatch test = new CommodityBatch();

        test.setCommodityBatchID(1);
        //test.setCommodityID(5);
        test.setManufacturer("PP");
        test.setStock(5);
        test.setRemainder(false);


        try {
            commodityDAO.createCBatch(test);
            ICommodityBatch recived = commodityDAO.getCBatch(1);
            assertEquals(test.getCommodityBatchID(), recived.getCommodityBatchID());
            //assertEquals(test.getCommodityID(),recived.getCommodityID());
            assertEquals(test.getManufacturer(),recived.getManufacturer());
            assertEquals(test.getStock(), recived.getStock());
            assertEquals(test.isRemainder(),recived.isRemainder());


            test.setStock(200);
            commodityDAO.updateCBatch(test);
            recived = commodityDAO.getCBatch(1);
            assertEquals(test.getStock(),recived.getStock());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }*/
}
