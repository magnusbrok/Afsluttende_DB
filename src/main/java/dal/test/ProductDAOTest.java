package dal.test;

import dal.dao.ProductDAO;
import dal.dao.interfaces.IUserDAO;
import dal.dto.Product;
import dal.dto.ProductBatch;
import dal.dto.interfaces.IProduct;
import dal.dao.interfaces.IProductDAO;
import dal.dto.interfaces.IProductBatch;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ProductDAOTest {


    IProductDAO productDAO = new ProductDAO();


    @Test
    public void productTest() throws IUserDAO.DALException {

        //Initialisation
        IProduct testProduct = new Product();
        testProduct.setProductID(300);
        testProduct.setProductName("Antibiotika");

        try {
            //TEST of Create and Reed
            productDAO.createProduct(testProduct);
            IProduct recivedProduct = productDAO.getProduct(testProduct.getProductID());
            assertEquals(testProduct.getProductID(),recivedProduct.getProductID());
            assertEquals(testProduct.getProductName(),recivedProduct.getProductName());

            //Test of Update
            testProduct.setProductName("Panodil");
            productDAO.updateProduct(testProduct);
            recivedProduct = productDAO.getProduct(testProduct.getProductID());
            assertEquals(testProduct.getProductName(),recivedProduct.getProductName());

            //Test of Delete
            productDAO.deleteProduct(testProduct.getProductID());
            boolean success = false;

            try{
                productDAO.getProduct(testProduct.getProductID());
            }catch (IUserDAO.DALException e){
                success = true;
            }
            assertTrue(success);

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }



    @Test
    public void productBatchTest() throws IUserDAO.DALException {

        //Initialisation
        IProductBatch testPBatch = new ProductBatch();
        testPBatch.setProductBatchID(364);
        testPBatch.setProductID(1);
        testPBatch.setRecipeID(1);
        testPBatch.setStatusID(1);

        IProductBatch dbPBatch = new ProductBatch(); // Ligger allerede i databasen
        dbPBatch.setProductBatchID(1);
        dbPBatch.setProductID(1);
        dbPBatch.setRecipeID(1);
        dbPBatch.setStatusID(2);

        try {
            //TEST of Create and Reed
            productDAO.createPBatch(testPBatch);
            IProductBatch recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductBatchID(), recivedPBatch.getProductBatchID());
            assertEquals(testPBatch.getProductID(),recivedPBatch.getProductID());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());
            assertEquals(testPBatch.getStatusID(),recivedPBatch.getStatusID());

            List<IProductBatch> batchList = productDAO.getPBatchList();
            boolean found = false;
            for(IProductBatch productBatch: batchList){
                if(productBatch.getProductBatchID() == testPBatch.getProductBatchID()){
                    assertEquals(testPBatch.getProductID(),recivedPBatch.getProductID());
                    assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());
                    assertEquals(testPBatch.getStatusID(),recivedPBatch.getStatusID());
                    found = true;
                }else if (productBatch.getProductBatchID() == dbPBatch.getProductBatchID()){
                    assertEquals(dbPBatch.getProductID(),recivedPBatch.getProductID());
                    assertEquals(dbPBatch.getRecipeID(),recivedPBatch.getRecipeID());
                    assertEquals(dbPBatch.getStatusID(),recivedPBatch.getStatusID());
                    found = true;
                }
            }
            if()

            //Test of Update
            testPBatch.setRecipeID(2);
            productDAO.updatePBatch(testPBatch);
            recivedPBatch = productDAO.getPBatch(testPBatch.getProductBatchID());
            assertEquals(testPBatch.getRecipeID(),recivedPBatch.getRecipeID());

            productDAO.deletePBatch(testPBatch.getProductBatchID());
            boolean success = false;

            try{
                productDAO.getPBatch(testPBatch.getProductBatchID());
            }catch (IUserDAO.DALException e){
                success = true;
            }
            assertTrue(success);

        } catch (IUserDAO.DALException e) {
            e.printStackTrace();
            fail();
        }
    }

//    @Test
//    public void getPBatchListTest() throws IUserDAO.DALException {
//
//        //Initialisation
//        IProductBatch dbPBatch = new ProductBatch();
//            dbPBatch.setProductBatchID(1);
//            dbPBatch.setProductID(1);
//            dbPBatch.setRecipeID(1);
//            dbPBatch.setStatusID(2);
//
//        IProductBatch testPBatch = new ProductBatch();
//            testPBatch.setProductBatchID(364);
//            testPBatch.setProductID(1);
//            testPBatch.setRecipeID(1);
//            testPBatch.setStatusID(1);
//
//
//        try {
//            productDAO.createPBatch(testPBatch);
//            List<IProductBatch> batchList = productDAO.getPBatchList();
//            assertTrue(batchList.contains(testPBatch) || batchList.contains(dbPBatch));
//
//            productDAO.deletePBatch(testPBatch.getProductBatchID());
//
//        } catch (IUserDAO.DALException e) {
//            e.printStackTrace();
//            fail();
//        }
//    }

//    @Test
//    public void getPBatchListTest() {
//        IProductBatch testPBatch = new ProductBatch();
//            testPBatch.setProductBatchID(364);
//            testPBatch.setProductID(1);
//            testPBatch.setQuantity(500);
//            testPBatch.setRecipeID(1);
//            testPBatch.setStatusID(1);
//
//        try {
//            productDAO.createPBatch(testPBatch);
//            List<IProductBatch> batchList = productDAO.getPBatchList();
//
//            for(IProductBatch batch : batchList){
//                if(batch.getProductBatchID() == 1){
//                    assertEquals(1,batch.getProductID());
//                    assertEquals(10500,batch.getQuantity());
//                    assertEquals(1,batch.getRecipeID());
//                    assertEquals(2,batch.getStatusID());
//                }
//                if(batch.getProductBatchID() == testPBatch.getProductBatchID()){
//                    assertEquals(testPBatch.getProductID(),batch.getProductID());
//                    assertEquals(testPBatch.getQuantity(),batch.getQuantity());
//                    assertEquals(testPBatch.getRecipeID(),batch.getRecipeID());
//                    assertEquals(testPBatch.getStatusID(),batch.getStatusID());
//                }else{
//                    fail();
//                }
//            }
//
//            productDAO.deletePBatch(testPBatch.getProductBatchID());
//
//        } catch (IUserDAO.DALException e) {
//            e.printStackTrace();
//            fail();
//        }
//
//    }
}
