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

import static org.junit.jupiter.api.Assertions.*;


public class CommodityDAOTest {


    ICommodityDAO commodityDAO = new CommodityDAO();


    @Test
    public void commodityTest() {

        ICommodity test = new Commodity();
        test.setCommodityID(120);
        test.setCommodityName("Silica");
        test.setActive(true);
        test.setReorder(false);

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
            List<ICommodity> com = commodityDAO.getCommodityList();
            boolean found = false;
            for (ICommodity commodity: com) {
                if (commodity.getCommodityID() == test.getCommodityID()) {
                    assertEquals(test.getCommodityName(), commodity.getCommodityName());
                    assertEquals(test.isActive(), commodity.isActive());
                    assertEquals(test.isReorder(), commodity.isReorder());
                    found = true;
                }
            }
            if (!found) {
                fail();
            }

            //Delete commodity
             commodityDAO.deleteCommodity(test.getCommodityID());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }

    }


    @Test
    public void commodityBatchTest() throws IUserDAO.DALException {
        ICommodityBatch test = new CommodityBatch();
        test.setCommodityBatchID(212);
        test.setCommodityID(1);
        test.setManufacturer("PP");
        test.setStock(20000);
        test.setRemainder(false);


        try {
            //Create commodityBatch
            commodityDAO.createCBatch(test);
            ICommodityBatch recived = commodityDAO.getCBatch(test.getCommodityBatchID());
            assertEquals(test.getCommodityBatchID(), recived.getCommodityBatchID());
            assertEquals(test.getCommodityID(),recived.getCommodityID());
            assertEquals(test.getManufacturer(),recived.getManufacturer());
            assertEquals(test.getStock(), recived.getStock());
            assertEquals(test.isRemainder(),recived.isRemainder());

            //Update commodityBatch + reminder check
            test.setStock(10000);
            commodityDAO.updateCBatch(test);
            recived = commodityDAO.getCBatch(test.getCommodityBatchID());
            assertEquals(test.getStock(),recived.getStock());
            assertTrue(recived.isRemainder());

            //Get commodityBatchList !! skal rettes til at checke om reminders (dvs. testbatch) ikke forekommer
            List<ICommodityBatch> cb = commodityDAO.getCBatchList();
            for (ICommodityBatch commodityBatch: cb) {
                if (commodityBatch.getCommodityBatchID() == test.getCommodityBatchID()) {
                    fail();
                }
            }

            //ExtractListTest
            List<ICommodityBatch> list = commodityDAO.getExtractList(1);
            boolean found = false;
            for (ICommodityBatch commodityBatch: list) {
                if (commodityBatch.getCommodityBatchID() == 24) {
                    assertEquals(2, commodityBatch.getCommodityID());
                    assertEquals("TEST_Manufacturer A", commodityBatch.getManufacturer());
                    assertFalse(commodityBatch.isRemainder());
                    found = true;
                }
            }
            if (!found) {
                fail();
            }

            //Delete commodityBatch
            commodityDAO.deleteCBatch(test.getCommodityBatchID());

            assertEquals(0, commodityDAO.getCBatch(test.getCommodityBatchID()).getCommodityBatchID());


        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }

    //TODO implement test of reorderCheck!
}
