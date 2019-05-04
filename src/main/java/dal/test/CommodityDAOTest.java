package dal.test;

import dal.dao.CommodityDAO;
import dal.dao.RecipeDAO;
import dal.dao.interfaces.ICommodityDAO;
import dal.dao.interfaces.IRecipeDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Commodity;
import dal.dto.CommodityBatch;
import dal.dto.Ingredient;
import dal.dto.interfaces.ICommodity;
import dal.dto.interfaces.ICommodityBatch;
import dal.dto.interfaces.IIngredient;
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

            test.setStock(10000);
            commodityDAO.createExtract(1,212,10000);
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

    @Test
    public void reorderCheckTest(){

        //Initiation
        ICommodity testCommodity = new Commodity();
            testCommodity.setCommodityID(320);
            testCommodity.setCommodityName("Bananer");
            testCommodity.setActive(false);
            testCommodity.setReorder(true);

        IIngredient testIngredient = new Ingredient();
            testIngredient.setRecipeID(1);
            testIngredient.setCommodityID(testCommodity.getCommodityID());
            testIngredient.setQuantity(10);
            testIngredient.setDeviation(5);

        ICommodityBatch testCommodityBatch = new CommodityBatch();
            testCommodityBatch.setCommodityBatchID(326);
            testCommodityBatch.setCommodityID(testCommodity.getCommodityID());
            testCommodityBatch.setManufacturer("DTU");
            testCommodityBatch.setStock(testIngredient.getQuantity()*3);
            testCommodityBatch.setRemainder(false);

        IRecipeDAO recipeDAO = new RecipeDAO();

        try {
            commodityDAO.createCommodity(testCommodity);
            recipeDAO.createIngredient(testIngredient);
            testIngredient.setRecipeID(testIngredient.getRecipeID()+1);
            testIngredient.setQuantity(8);
            recipeDAO.createIngredient(testIngredient);

            //Tests reorder when Batch is created
            commodityDAO.createCBatch(testCommodityBatch); // udløser reorder
            assertFalse(commodityDAO.getCommodity(testCommodity.getCommodityID()).isReorder());

            //Tests reorder when stock is updated
            testCommodityBatch.setStock(18); //stock which do not fulfill the requirement
            commodityDAO.updateCBatch(testCommodityBatch);
            assertTrue(commodityDAO.getCommodity(testCommodity.getCommodityID()).isReorder());
            assertFalse(commodityDAO.getCBatch(testCommodityBatch.getCommodityBatchID()).isRemainder());

            commodityDAO.deleteCBatch(testCommodityBatch.getCommodityBatchID());
            recipeDAO.deleteIngredient(testIngredient.getRecipeID(), testIngredient.getCommodityID());
            recipeDAO.deleteIngredient(testIngredient.getRecipeID(), testIngredient.getCommodityID());
            recipeDAO.deleteIngredient(testIngredient.getRecipeID()-1, testIngredient.getCommodityID());
            commodityDAO.deleteCommodity(testCommodity.getCommodityID());

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }

    }

}
